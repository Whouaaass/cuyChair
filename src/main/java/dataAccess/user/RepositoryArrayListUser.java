/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.user;

import domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class RepositoryArrayListUser implements IRepositoryUser{
    private ArrayList<User> usersList;

    public RepositoryArrayListUser() {
        this.usersList = new ArrayList();
    }

    @Override
    public boolean storeUser(User objUser) {
        boolean varFlag = this.usersList.add(objUser);
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
    
}
