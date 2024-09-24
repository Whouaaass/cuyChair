/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author julia
 */
public class User {
    private int id;
    private String name;
    private String lastName;
    private String hashedPassword; 
    private String email;

    public User(int userId, String userName, String userLastName, String userPassword, String userEmail) {
        this.id = userId;
        this.name = userName;
        this.lastName = userLastName;
        this.hashedPassword = userPassword;
        this.email = userEmail;
    }
    
    public User(User objUser) {
        this.id = objUser.id;
        this.name = objUser.name;
        this.lastName = objUser.lastName;
        this.hashedPassword = objUser.hashedPassword;
        this.email = objUser.email;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int userId) {
        this.id = userId;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String userName) {
        this.name = userName;
    }

    public String getUserLastName() {
        return lastName;
    }

    public void setUserLastName(String userLastName) {
        this.lastName = userLastName;
    }

    public String getUserPassword() {
        return hashedPassword;
    }

    public void setUserPassword(String userPassword) {        
        this.hashedPassword = userPassword;
    }
    
    public boolean comparePassword(String inPassword) throws Exception {
        throw new Exception("");
    }
    
}
