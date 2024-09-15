/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.user;

import domain.user;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class repositoryArrayListUser implements IRepositoryUser{
    private ArrayList<user> usersList;

    public repositoryArrayListUser() {
        this.usersList = new ArrayList();
    }

    @Override
    public boolean storeUser(user objUser) {
        boolean varFlag=this.usersList.add(objUser);
        return varFlag;
    }

    @Override
    public List<user> listUser() {
        return this.usersList;
    }
    
    
    
}
