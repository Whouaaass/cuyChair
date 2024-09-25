/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.user;

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

    private Connection connection;

    /**
     * Genera una instancia del repositorio
     */
    public RepositorySQLiteUser() {
        initDatabase();
    }

    @Override
    public boolean storeUser(User objUser) {
        this.connect();
        boolean varFlag;
        try {
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
        this.closeConnection();
        return varFlag;
    }

    @Override
    public List<User> listUsers() {
        List<User> List = new ArrayList<>();
        this.connect();
        try {
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

        try {
            this.connect();
            /**
             * String selectEmail = "SELECT * FROM user WHERE fldEmail = ? ";
             * PreparedStatement pst = connection.prepareStatement(selectEmail);
             * pst.setString(1, email);
             */
            String selectEmail = "SELECT * FROM user WHERE fldEmail = '" + email + "' ";
            PreparedStatement pst = connection.prepareStatement(selectEmail);
            ResultSet rs = pst.executeQuery();

            User newUser = new User(
                    rs.getInt("fldId"),
                    rs.getString("fldName"),
                    rs.getString("fldLastName"),
                    rs.getString("fldHashedPassword"),
                    rs.getString("fldEmail")
            );

            if (rs.wasNull()) {
                this.closeConnection();
                return null;
            }

            this.closeConnection();
            return newUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnection();
        return null;
    }

    public void initDatabase() {
        try {
            this.connect();
            String tableUser = "CREATE TABLE IF NOT EXISTS USER(\n "
                    + "fldId Number PRAMARY KEY,\n"
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
        this.closeConnection();
    }

    public void connect() {
        String URL = "jdbc:sqlite:MyBd.db";
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Fallo conexion a la base de datos");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar Base de datos");
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean modifyUser(User objUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
