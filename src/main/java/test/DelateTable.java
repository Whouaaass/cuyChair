package test;

import dataAccess.ConnectionSqlitePool;

import java.sql.*;
public class DelateTable {
    public static void main(String[] args) {
        try(Connection connection= ConnectionSqlitePool.getConnection()){
            String delateuser="DROP TABLE IF EXISTS user;";
            String delatepaper="DROP TABLE IF EXISTS paper;";
            String delateconference="DROP TABLE IF EXISTS conference;";
            String delatepaperReview="DROP TABLE IF EXISTS paperreview;";
            String delateuserconference="DROP TABLE IF EXISTS userconference;";

            Statement st= connection.createStatement();
            st.execute(delateuser);
            st.execute(delatepaper);
            st.execute(delateconference);
            st.execute(delatepaperReview);
            st.execute(delateuserconference);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
