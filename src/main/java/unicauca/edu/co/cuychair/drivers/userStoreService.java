/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drivers;

import dataAccess.user.IRepositoryUser;
import domain.user;
import java.util.List;

/**
 *
 * @author julia
 */
public class userStoreService {
    private IRepositoryUser objRepositoryUserRef;
    
    public userStoreService(IRepositoryUser objRepositoryUserRef)
    {
        this.objRepositoryUserRef=objRepositoryUserRef;
    }
    
    public boolean storeUser(user objUser) {
        boolean varFlag=this.objRepositoryUserRef.storeUser(objUser);
        return varFlag;
    }

   
    public List<user> listUser() {
        return this.objRepositoryUserRef.listUser();
    }
}
