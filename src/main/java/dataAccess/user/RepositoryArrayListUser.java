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
 * Repositorio que guarda a los usuarios
 * @author julia
 * @author Frdy
 * @author Juan
 */
public class RepositoryArrayListUser implements IRepositoryUser{
    private ArrayList<User> usersList;
    private Connection conn;

    public RepositoryArrayListUser() {
        initDatabase();
        this.usersList = new ArrayList();
    }

    @Override
    public boolean storeUser(User objUser) {
        boolean varFlag = this.usersList.add(objUser);
        try {
            String insertUser = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(insertUser);
            pst.setInt(1,objUser.getUserId());
            pst.setString(2, objUser.getUserName());
            pst.setString(3, objUser.getUserLastName());
            pst.setString(4, objUser.getUserPassword());
            pst.setString(5, objUser.getUserEmail());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return varFlag;
    }

    @Override
    public List<User> listUsers() {
        return this.usersList;
    }
     
    @Override
    public User getUserByEmail(String email) {
        for (User objUser : usersList) {
            if (objUser.getUserEmail().equals(email)) {
                return objUser;
            }
        }
        return null;
    }

    public void initDatabase(){
        String tableUser="CREATE TABLE IF NOT EXIST USER(\n "
                        +"fldId Number PRAMARY KEY,\n"
                        +"fldName text NOT NULL,\n"
                        +"fldLastName text NOT NULL,\n"
                        +"fldHashedPassword text NOT NULL,\n"
                        +"fldEmail text NOT NULL\n"
                        +");";
        try{
            this.conect();
            Statement stm= conn.createStatement();
            stm.execute(tableUser);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void conect(){
        String URL="jdbc:sqlite:MyBd.db";
        try{
            conn=DriverManager.getConnection(URL);
        }catch (SQLException e){
            System.out.println("Fallo conexion a la base de datos");
            e.printStackTrace();
        }
    }

    public void closeconection(){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar Base de datos");
                e.printStackTrace();
            }
        }
    }
    
}
