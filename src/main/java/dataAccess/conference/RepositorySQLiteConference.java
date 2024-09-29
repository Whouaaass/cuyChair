/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import java.sql.*;

import dataAccess.ConnectionSqlitePool;
import dataAccess.user.RepositorySQLiteUser;
import domain.Conference;
import domain.Paper;
import domain.PaperReview;
import domain.User;
import utilities.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio de conferencias que utiliza SQLite
 * @author Juan
 * @author Frdy
 */
public class RepositorySQLiteConference implements IRepositoryConference {

    public RepositorySQLiteConference() {
        initDatabase();
    }

    @Override
    public boolean storeConference(Conference objConference) {
        String insertConference = "INSERT INTO Conference VALUES(?, ?, ?, ?, ?, date('?'))";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(insertConference);
            pst.setInt(1, objConference.getId());
            pst.setString(2, objConference.getTitle());
            pst.setString(3, objConference.getDescription());
            pst.setString(4, objConference.getCiudad());
            pst.setInt(5, objConference.getConferenceOrganizer().getUserId());
            pst.setString(6, objConference.getDate().toString());
            pst.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Conference> listConference() {
        RepositorySQLiteUser repo = new RepositorySQLiteUser();
        List<Conference> list = new ArrayList<>();
        Conference newConfe = new Conference();
        String listConference = "SELECT * FROM Conference";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(listConference);
            while (rs.next()) {
                newConfe.setFldId(rs.getInt(1));
                newConfe.setTitle(rs.getString(2));
                newConfe.setDescription(rs.getString(3));
                newConfe.setCiudad(rs.getString(4));
                newConfe.setConferenceAdmin(repo.getUserById(rs.getInt(5)));
                newConfe.setDate(rs.getDate(6));
                list.add(newConfe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Conference> listConferenceByUserAssistant(int userId) {
        List<Conference> listConfe = new ArrayList<>();
        String listParticipants = "SELECT conferenceId FROM UserConference WHERE userId = ?";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(listParticipants);
            pst.setInt(1, userId);
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
    public List<Conference> listConferenceByUserOwner(int ownerId) {
        List<Conference> listConfe = new ArrayList<>();
        String listProperties = "SELECT conferenceId FROM Conference WHERE AdminId= ?";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(listProperties);
            pst.setInt(1, ownerId);
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
        RepositorySQLiteUser repo = new RepositorySQLiteUser();
        Conference newConfe = new Conference();
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(confe);
            pst.setInt(1, conferenceId);
            ResultSet rs = pst.executeQuery();

            // Solo se cargan los datos de la tabla, lo demás se carga por lazy loading
            newConfe = new Conference(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    DateUtils.parseDBDate(rs.getString("beginDate")),
                    rs.getString("city")
            );
            newConfe.setFldId(rs.getInt(1));
            newConfe.setTitle(rs.getString(2));
            newConfe.setDescription(rs.getString(3));
            newConfe.setCiudad(rs.getString(4));
            newConfe.setConferenceAdmin(repo.getUserById(rs.getInt(5)));
            newConfe.setDate(rs.getDate(6));

            return newConfe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> listReviewers(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listReviewers'");
    }

    @Override
    public List<User> listAuthors(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listAuthors'");
    }

    @Override
    public List<Paper> listPapers(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listPapers'");
    }

    @Override
    public List<PaperReview> listReviews(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listReviews'");
    }

    @Override
    public User getConferenceOrganizer(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getConferenceOrganizer'");
    }

    public void initDatabase() {
        String tableConference = "CREATE TABLE IF NOT EXISTS Conference(\n"
                + "id integer PRIMARY KEY NOT NULL,\n"
                + "title text NOT NULL,\n"
                + "description text NOT NULL,\n"
                + "city text NOT NULL,\n"
                + "adminId integer NOT NULL,\n"
                + "beginDate text NOT NULL,\n"
                + "FOREIGN KEY (adminId) REFERENCES User(id)\n"
                + ");";
        String tableUserConference =
                """
                CREATE TABLE IF NOT EXIST UserConference (
                id integer PRIMARY KEY NOT NULL,
                userId integer NOT NULL,
                conferenceId integer NOT NULL,
                rol integer NOT NULL,
                FOREIGN KEY (userId) REFERENCES User(id),
                FOREIGN KEY (conferenceId) REFERENCES Conference(id)
                );
                """;
        String tableJobs = "CREATE TABLE IF NOT EXISTS Jobs(\n"
                + "conferenceId integer NOT NULL,\n"
                + "paperId integer  NOT NULL,\n"
                + "FOREIGN KEY (conferenceId) REFERENCES Conference(conferenceId),\n"
                + "FOREIGN KEY (paperId) REFERENCES paper(id),\n"
                + ");";

        String tableReviews = "CREATE TABLE IF NOT EXISTS Reviews(\n"
                + "conferenceId integer NOT NULL,\n"
                + "reviewId integer  NOT NULL,\n"
                + "FOREIGN KEY (conferenceId) REFERENCES Conference(id),\n"
                + "FOREIGN KEY (reviewId) REFERENCES paperreview(id),\n"
                + ");";
        try (Connection connection = ConnectionSqlitePool.getConnection()) {
            Statement st = connection.createStatement();
            st.execute(tableConference);
            st.execute(tableUserConference);
            st.execute(tableJobs);
            st.execute(tableReviews);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

}
