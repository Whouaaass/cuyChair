/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import java.sql.*;

import dataAccess.ConnectionSqlitePool;
import dataAccess.user.RepositorySQLiteUser;
import domain.*;
import domain.sql.SQLConference;
import org.sqlite.SQLiteConnection;
import utilities.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de conferencias que utiliza SQLite
 * @author Juan
 * @author Frdy
 */
public class RepositorySQLiteConference implements IRepositoryConference {

    public RepositorySQLiteConference() {}

    @Override
    public boolean storeConference(Conference objConference) {
        String insertConference = "INSERT INTO Conference(title, description, city, date, adminId) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(insertConference);
            pst.setString(1, objConference.getTitle());
            pst.setString(2, objConference.getDescription());
            pst.setString(3, objConference.getCity());
            pst.setString(4, DateUtils.formatDBDate(objConference.getDate()));
            pst.setInt(5, objConference.getConferenceOrganizer().getUserId());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Conference> listConference() {
        List<Conference> list = new ArrayList<>();
        String listConference = "SELECT * FROM Conference";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(listConference);
            while (rs.next()) {
                list.add(createConferenceWithRowData(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Conference> listConferenceRelatedTo(User user) {
        List<Conference> listConfe = new ArrayList<>();
        String listParticipants = "SELECT Conference.* FROM Conference INNER JOIN UserConference ON Conference.id = UserConference.conferenceId WHERE UserConference.userId = ?";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(listParticipants);
            pst.setInt(1, user.getUserId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listConfe.add(createConferenceWithRowData(rs));
            }
            return listConfe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Conference> listConferenceRelatedTo(User user, ConferenceParticipation.Role role) {
        List<Conference> listConfe = new ArrayList<>();
        String listParticipants = "SELECT Conference.* FROM Conference INNER JOIN UserConference ON Conference.id = UserConference.conferenceId WHERE UserConference.userId = ? and UserConference.rol = ?";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(listParticipants);
            pst.setInt(1, user.getUserId());
            pst.setInt(2, role.value());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listConfe.add(createConferenceWithRowData(rs));
            }
            return listConfe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Conference> listConferenceOrganizedBy(User organizer) {
        List<Conference> listConfe = new ArrayList<>();
        String listProperties = "SELECT * FROM Conference WHERE AdminId = ?";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(listProperties);
            pst.setInt(1, organizer.getUserId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                listConfe.add(getConferenceById(rs.getInt(1)));
            }
            return listConfe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Conference getConferenceById(int conferenceId) {
        String confe = "SELECT * FROM Conference WHERE id = ?";
        Conference newConfe = null;

        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(confe);
            pst.setInt(1, conferenceId);
            ResultSet rs = pst.executeQuery();

            // Solo se cargan los datos de la tabla, lo demás se carga por lazy loading
            if (rs.next()) {
                newConfe = createConferenceWithRowData(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newConfe;
    }

    @Override
    public Conference getConferenceOf(Paper paper) {
        String select = "SELECT * FROM Conference INNER JOIN Paper ON Paper.conferenceId = Conference.id WHERE Paper.id = ?";
        Conference newConference  = null;
        try (Connection conn = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = conn.prepareStatement(select);
            pst.setInt(1, paper.getId());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                newConference = createConferenceWithRowData(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newConference;
    }

    /**
     * Método que crea una conferencia a partir de una fila de un ResultSet
     * @param rs ResultSet a partir de la ejecución de una query
     * @return Conferencia a partir de esa fila
     * @throws SQLException
     */
    private Conference createConferenceWithRowData(ResultSet rs) throws SQLException {
        SQLConference objConference = new SQLConference();
        objConference.setId(rs.getInt("id"));
        objConference.setTitle(rs.getString("title"));
        objConference.setDescription(rs.getString("description"));
        objConference.setCity(rs.getString("city"));
        objConference.setDate(DateUtils.parseDBDate(rs.getString("date")));

        return objConference;
    }

}
