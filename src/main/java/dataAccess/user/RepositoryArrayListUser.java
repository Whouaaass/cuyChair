/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.user;

import domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio que guarda los usuarios en memoria por medio de un ArrayList
 * @author Frdy
 */
public class RepositoryArrayListUser implements IRepositoryUser {
    
    private ArrayList<User> userList;
    
    /**
     * Genera una instancia del repositorio
     */
    public RepositoryArrayListUser() {
        userList = new ArrayList();
    }
    
    @Override
    public boolean storeUser(User objUser) {
        return userList.add(objUser);
    }

    @Override
    public List<User> listUsers() {
        return userList;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : userList) {
            if (user.getUserEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean modifyUser(int userId, String name, String lastName, String password) {
        for(User user: userList){
            if(user.getUserId()==userId){
                user.setUserName(name);
                user.setUserLastName(lastName);
                user.setUserPassword(password);
                return true;
            }
        }
        return false;
    }
}
