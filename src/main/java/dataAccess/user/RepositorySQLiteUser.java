/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.user;

import dataAccess.ConnectionSqlitePool;
import domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio que guarda a los usuarios en una base de datos local
 *
 * @author julia
 * @author Frdy
 * @author Juan
 */
public class RepositorySQLiteUser implements IRepositoryUser {
    /**
     * Genera una instancia del repositorio
     */
    public RepositorySQLiteUser() {
    }

    @Override
    public boolean storeUser(User objUser) {
        boolean varFlag;
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            String insertUser = "INSERT INTO USER(id, name, lastName, hashedPassword, email) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = connection.prepareStatement(insertUser);
            pst.setInt(1, objUser.getUserId());
            pst.setString(2, objUser.getUserName());
            pst.setString(3, objUser.getUserLastName());
            pst.setString(4, objUser.getUserPassword());
            pst.setString(5, objUser.getUserEmail());
            pst.executeUpdate();
            System.out.println("Usuario guardado correctamente");
            varFlag = true;
        } catch (SQLException e) {
            e.printStackTrace();
            varFlag = false;
        }
        return varFlag;
    }

    @Override
    public List<User> listUsers() {
        List<User> List = new ArrayList<>();
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            String listUser = "SELECT * FROM user";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(listUser);
            while (rs.next()) {
                List.add(createUserFromRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List;
    }

    @Override
    public User getUserByEmail(String email) {

        try (Connection connection = ConnectionSqlitePool.getConnection()) {

            String selectEmail = "SELECT * FROM user WHERE email = ? ";
            PreparedStatement pst = connection.prepareStatement(selectEmail);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return createUserFromRow(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int userId) {
        try (Connection connection = ConnectionSqlitePool.getConnection()) {

            String selectId = "SELECT * FROM user WHERE id = ? ";
            PreparedStatement pst = connection.prepareStatement(selectId);
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            User newUser = createUserFromRow(rs);

            if (rs.wasNull()) {
                return null;
            }

            return newUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean modifyUser(int userId, String name, String lastName, String password, String description) {
        String updateStatement = "UPDATE User SET name = ?, lastName = ?, hashedPassword = ?, description = ? WHERE id = ?";
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(updateStatement);
            pst.setString(1, name);
            pst.setString(2, lastName);
            pst.setString(3, password);
            pst.setString(4, description);
            pst.setInt(5, userId);
            int affected = pst.executeUpdate();
            if (affected > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> listUsersRelatedTo(Conference conference) {
        String select = "SELECT User.* FROM User INNER JOIN UserConference ON User.id = User.id = UserConference.userId WHERE UserConference.conferenceId = ?";
        List<User> newUsers = new ArrayList<>();
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(select);
            pst.setInt(1, conference.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                newUsers.add(createUserFromRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUsers;
    }

    @Override
    public List<User> listUsersRelatedTo(Conference conference, ConferenceParticipation.Role role) {
        String select = "SELECT User.* FROM User INNER JOIN UserConference ON User.id = User.id = UserConference.userId WHERE UserConference.conferenceId = ? AND UserConference.rol = ? ";
        List<User> newUsers = new ArrayList<>();
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(select);
            pst.setInt(1, conference.getId());
            pst.setInt(2, role.value());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                newUsers.add(createUserFromRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUsers;
    }

    @Override
    public User getUserOrganizerOf(Conference conference) {
        String select = "SELECT User.* FROM User INNER JOIN Conference ON User.id = Conference.adminId WHERE Conference.id = ?";
        User newUser = null;
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(select);
            pst.setInt(1, conference.getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                newUser = createUserFromRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    @Override
    public User getReviewerOf(PaperReview paperReview) {
        String select = "SELECT User.* FROM User INNER JOIN PaperReview ON User.id = PaperReview.reviewerId WHERE PaperReview.id = ?";
        User newUser = null;
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(select);
            pst.setInt(1, paperReview.getReviewId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                newUser = createUserFromRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    @Override
    public User getAuthorOf(Paper paper) {
        String select = "SELECT User.* FROM User INNER JOIN Paper ON User.id = Paper.userId WHERE Paper.id = ?";
        User newUser = null;
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(select);
            pst.setInt(1, paper.getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                newUser = createUserFromRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newUser;
    }

    private User createUserFromRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("id"));
        user.setUserName(rs.getString("name"));
        user.setUserLastName(rs.getString("lastName"));
        user.setUserPassword(rs.getString("hashedPassword"));
        user.setUserEmail(rs.getString("email"));
        user.setDescription(rs.getString("description"));
        return user;
    }
}
