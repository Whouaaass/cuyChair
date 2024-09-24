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
        this.conect();
        try {
            String insertUser = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(insertUser);
            pst.setInt(1,objUser.getUserId());
            pst.setString(2, objUser.getUserName());
            pst.setString(3, objUser.getUserLastName());
            pst.setString(4, objUser.getUserPassword());
            pst.setString(5, objUser.getUserEmail());
            pst.executeUpdate();
            System.out.println("Usuario insertado");
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.closeconection();
        return varFlag;
    }

    @Override
    public List<User> listUsers() {
        ArrayList<User> List=new ArrayList<>();
        this.conect();
        try {
            String listUser="SELECT * FROM user";
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(listUser);
            while (rs.next()) {
                User newUser = new User();
                newUser.setUserId(rs.getInt("fldId"));
                newUser.setUserName(rs.getString("fldName"));
                newUser.setUserLastName(rs.getString("fldLastName"));
                newUser.setUserPassword(rs.getString("fldHashedPassword"));
                newUser.setUserEmail(rs.getString("fldEmail"));
                List.add(newUser);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return List;
    }
     
    @Override
    public User getUserByEmail(String email) {

        try{
            this.conect();
            String selectEmail="SELECT * FROM user WHERE fldEmail = ' "
                                +email+"'";

            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery(selectEmail);
            User newUser=new User();

            newUser.setUserId(rs.getInt("fldId"));
            newUser.setUserName(rs.getString("fldName"));
            newUser.setUserLastName(rs.getString("fldLastName"));
            newUser.setUserPassword(rs.getString("fldHashedPassword"));
            newUser.setUserEmail(rs.getString("fldEmail"));
            if(rs.wasNull()){
                this.closeconection();
                return null;
            }
            this.closeconection();
            return newUser;
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.closeconection();
        return null;
    }

    public void initDatabase(){
        try{
            this.conect();
            String tableUser="CREATE TABLE IF NOT EXISTS USER(\n "
                    +"fldId Number PRAMARY KEY,\n"
                    +"fldName text NOT NULL,\n"
                    +"fldLastName text NOT NULL,\n"
                    +"fldHashedPassword text NOT NULL,\n"
                    +"fldEmail text NOT NULL\n"
                    +");";

            Statement stm= conn.createStatement();
            stm.execute(tableUser);
            System.out.println("Tabla creada");
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.closeconection();
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
