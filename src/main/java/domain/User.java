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
    private int fldId;
    private String fldName;
    private String fldLastName;
    private String fldHashedPassword; 
    private String fldEmail;
    
    public User(int userId, String userName, String userLastName, String userPassword, String userEmail) {
        this.fldId = userId;
        this.fldName = userName;
        this.fldLastName = userLastName;
        this.fldHashedPassword = userPassword;
        this.fldEmail = userEmail;
    }
    
    public User(User objUser) {
        this.fldId = objUser.fldId;
        this.fldName = objUser.fldName;
        this.fldLastName = objUser.fldLastName;
        this.fldHashedPassword = objUser.fldHashedPassword;
        this.fldEmail = objUser.fldEmail;
    }
    
    
    public User(){

    }

    public String getUserEmail() {
        return fldEmail;
    }

    public void setUserEmail(String userEmail) {
        this.fldEmail = userEmail;
    }

    public int getUserId() {
        return fldId;
    }

    public void setUserId(int userId) {
        this.fldId = userId;
    }

    public String getUserName() {
        return fldName;
    }

    public void setUserName(String userName) {
        this.fldName = userName;
    }

    public String getUserLastName() {
        return fldLastName;
    }

    public void setUserLastName(String userLastName) {
        this.fldLastName = userLastName;
    }

    public String getUserPassword() {
        return fldHashedPassword;
    }

    public void setUserPassword(String userPassword) {        
        this.fldHashedPassword = userPassword;
    }
    
    public boolean comparePassword(String inPassword) throws Exception {
        throw new Exception("");
    }
    
}
