/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import java.sql.*;

import dataAccess.ConnectionSqlitePool;
import dataAccess.user.RepositorySQLiteUser;
import domain.Conference;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class RepositorySQLiteConference implements IRepositoryConference{

    public RepositorySQLiteConference() {
        initDatabase();
    }
    
    @Override
    public boolean storeConference(Conference objConference) {
        String insertConference="INSERT INTO Conference VALUES(?, ?, ?, ?, ?, date('?'))";
        try(Connection connection= ConnectionSqlitePool.getConnection()){
            PreparedStatement pst=connection.prepareStatement(insertConference);
            pst.setInt(1,objConference.getIdConference());
            pst.setString(2,objConference.getTitle());
            pst.setString(3,objConference.getDescription());
            pst.setString(4,objConference.getCiudad());
            pst.setInt(5,objConference.getConferenceAdmin().getUserId());
            pst.setString(6,objConference.getDate().toString());
            pst.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Conference> listConference() {
        List<Conference> list=new ArrayList<>();
        RepositorySQLiteUser repo=new RepositorySQLiteUser();
        String listConference="SELECT * FROM Conference";
        Conference newConfe=new Conference();
        try(Connection connection= ConnectionSqlitePool.getConnection()){
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(listConference);
           while(rs.next()){
               newConfe.setIdConference(rs.getInt(1));
               newConfe.setTitle(rs.getString(2));
               newConfe.setDescription(rs.getString(3));
               newConfe.setCiudad(rs.getString(4));
               newConfe.setConferenceAdmin(repo.getUserById(rs.getInt(5)));
               newConfe.setDate(rs.getDate(6));
                list.add(newConfe);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Conference> listConferenceByUserAssistant(User objUser) {
       List<Conference> listConfe=new ArrayList<>();
       String listParticipants="SELECT conferenceId FROM Participants WHERE userId= ?";
       try(Connection connection= ConnectionSqlitePool.getConnection()){
          PreparedStatement pst= connection.prepareStatement(listParticipants);
          pst.setInt(1,objUser.getUserId());
          ResultSet rs= pst.executeQuery();
          while(rs.next()){
              listConfe.add(getConferenceById(rs.getInt(1)));
          }
           return listConfe;
       }catch (SQLException e){
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public List<Conference> listConferenceByUserOwner(User objUser) {
        List<Conference> listConfe=new ArrayList<>();
        String listProperties="SELECT conferenceId FROM Conference WHERE AdminId= ?";
        try(Connection connection= ConnectionSqlitePool.getConnection()){
            PreparedStatement pst= connection.prepareStatement(listProperties);
            pst.setInt(1,objUser.getUserId());
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                listConfe.add(getConferenceById(rs.getInt(1)));
            }
            return listConfe;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Conference getConferenceById(int conferenceId) {
        String confe="SELECT * FROM Conference WHERE id=  ? ";
        RepositorySQLiteUser repo=new RepositorySQLiteUser();
        Conference newConfe=new Conference();
        try(Connection connection= ConnectionSqlitePool.getConnection()){
            PreparedStatement pst=connection.prepareStatement(confe);
            pst.setInt(1,conferenceId);
            ResultSet rs= pst.executeQuery();

            newConfe.setIdConference(rs.getInt(1));
            newConfe.setTitle(rs.getString(2));
            newConfe.setDescription(rs.getString(3));
            newConfe.setCiudad(rs.getString(4));
            newConfe.setConferenceAdmin(repo.getUserById(rs.getInt(5)));
            newConfe.setDate(rs.getDate(6));
            return newConfe;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void initDatabase(){
        String tableConference="CREATE TABLE IF NOT EXISTS Conference(\n"
                +"id integer PRIMARY KEY NOT NULL,\n"
                +"fldTitle text NOT NULL,\n"
                +"fldDescription text NOT NULL,\n"
                +"fldCity text NOT NULL,\n"
                +"AdminId integer NOT NULL,\n"
                +"date text NOT NULL,\n"
                +"FOREIGN KEY (AdminId) REFERENCES User(id)\n"
                +");";
        String tableParticipants="CREATE TABLE IF NOT EXISTS Participants(\n"
                +"id PRIMARY KEY AUTOINCREMENT,\n"
                +"conferenceId integer NOT NULL,\n"
                +"userId integer  NOT NULL,\n"
                +"FOREIGN KEY (conferenceId) REFERENCES Conference(id),\n"
                +"FOREIGN KEY (userId) REFERENCES User(id),\n"
                +");";

        String tableJobs="CREATE TABLE IF NOT EXISTS Jobs(\n"
                +"id PRIMARY KEY AUTOINCREMENT,\n"
                +"conferenceId integer NOT NULL,\n"
                +"paperId integer  NOT NULL,\n"
                +"FOREIGN KEY (conferenceId) REFERENCES Conference(conferenceId),\n"
                +"FOREIGN KEY (paperId) REFERENCES paper(id),\n"
                +");";
        String tableReviewers="CREATE TABLE IF NOT EXISTS Reviewers(\n"
                +"id PRIMARY KEY AUTOINCREMENT,\n"
                +"conferenceId integer NOT NULL,\n"
                +"evaluatorId integer  NOT NULL,\n"
                +"FOREIGN KEY (conferenceId) REFERENCES Conference(id),\n"
                +"FOREIGN KEY (evaluatorId) REFERENCES User(id),\n"
                +");";
        String tableReviews="CREATE TABLE IF NOT EXISTS Reviews(\n"
                +"id PRIMARY KEY AUTOINCREMENT,\n"
                +"conferenceId integer NOT NULL,\n"
                +"reviewId integer  NOT NULL,\n"
                +"FOREIGN KEY (conferenceId) REFERENCES Conference(id),\n"
                +"FOREIGN KEY (reviewId) REFERENCES paperreview(id),\n"
                +");";
        try (Connection connection= ConnectionSqlitePool.getConnection()){
            Statement st=connection.createStatement();
            st.execute(tableConference);
            st.execute(tableParticipants);
            st.execute(tableJobs);
            st.execute(tableReviewers);
            st.execute(tableReviews);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
