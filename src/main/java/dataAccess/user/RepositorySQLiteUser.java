/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.user;

import dataAccess.ConnectionSqlitePool;
import domain.User;

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
        initDatabase();
    }

    @Override
    public boolean storeUser(User objUser) {
        boolean varFlag;
        try (Connection connection=ConnectionSqlitePool.getConnection()){
            String insertUser = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";

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
        try (Connection connection=ConnectionSqlitePool.getConnection()){
            String listUser = "SELECT * FROM user";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(listUser);
            while (rs.next()) {
                User newUser = new User();
                newUser.setUserId(rs.getInt("fldId"));
                newUser.setUserName(rs.getString("fldName"));
                newUser.setUserLastName(rs.getString("fldLastName"));
                newUser.setUserPassword(rs.getString("fldHashedPassword"));
                newUser.setUserEmail(rs.getString("fldEmail"));
                List.add(newUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List;
    }

    @Override
    public User getUserByEmail(String email) {

        try (Connection connection=ConnectionSqlitePool.getConnection()){

             String selectEmail = "SELECT * FROM user WHERE fldEmail = ? ";
             PreparedStatement pst = connection.prepareStatement(selectEmail);
             pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            User newUser = new User(
                    rs.getInt("fldId"),
                    rs.getString("fldName"),
                    rs.getString("fldLastName"),
                    rs.getString("fldHashedPassword"),
                    rs.getString("fldEmail")
            );

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
    public User getUserById(int userId) {
        try (Connection connection=ConnectionSqlitePool.getConnection()){

            String selectId = "SELECT * FROM user WHERE fldId = ? ";
            PreparedStatement pst = connection.prepareStatement(selectId);
            pst.setInt(1, userId);

            ResultSet rs = pst.executeQuery();

            User newUser = new User(
                    rs.getInt("fldId"),
                    rs.getString("fldName"),
                    rs.getString("fldLastName"),
                    rs.getString("fldHashedPassword"),
                    rs.getString("fldEmail")
            );

            if (rs.wasNull()) {
                return null;
            }

            return newUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initDatabase() {
        try (Connection connection=ConnectionSqlitePool.getConnection()){
            String tableUser = "CREATE TABLE IF NOT EXISTS USER(\n "
                    + "fldId Number PRIMARY KEY,\n"
                    + "fldName text NOT NULL,\n"
                    + "fldLastName text NOT NULL,\n"
                    + "fldHashedPassword text NOT NULL,\n"
                    + "fldEmail text NOT NULL\n"
                    + ");";

            Statement stm = connection.createStatement();
            stm.execute(tableUser);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean modifyUser(int userId,String name, String lastName, String password, String description) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
