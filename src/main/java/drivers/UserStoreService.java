/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drivers;

import co.edu.unicauca.cuychair.common.notificationPlugin.Contact;
import co.edu.unicauca.cuychair.common.notificationPlugin.Notification;
import dataAccess.user.IRepositoryUser;
import domain.User;
import plugins.PluginManager;

import java.util.List;

/**
 * Servicio de gestion de almacenamiento de usuarios
 * @author julia
 * @author Frdy
 */
public class UserStoreService {
    private IRepositoryUser objRepositoryUserRef;
    
    /**
     * Instancia un servicio de usuario
     * @param objRepositoryUserRef Repositorio que utilizara el servicio
     */
    public UserStoreService(IRepositoryUser objRepositoryUserRef)
    {
        this.objRepositoryUserRef=objRepositoryUserRef;
    }
    
    /**
     * Guarda un usuario
     * @param objUser Usuario a guardar
     * @return si el guardado fue correcto
     */
    public boolean storeUser(User objUser) {
        boolean varFlag=this.objRepositoryUserRef.storeUser(objUser);
        PluginManager.getInstance().notifyPlugins(new Notification(
                new Contact(objUser.getUserEmail(), null),
                Notification.Action.CREATION,
                Notification.Entity.USER,
                varFlag ? Notification.ActionState.OK: Notification.ActionState.FAIL
        ));
        return varFlag;
    }
   
    /**
     * Lista los usuarios
     * @return lista de usuarios
     */
    public List<User> listUsers() {
        return this.objRepositoryUserRef.listUsers();
    }
    
    /**
     * Busca un usuario por su email
     * @param email email del usuario
     * @return el primer usuario con ese email
     */
    public User getUserByEmail(String email) {
        return this.objRepositoryUserRef.getUserByEmail(email);
    }
    
    public boolean modifyUser(int userId, String name, String lastName, String password, String description) {
        boolean varFlag=this.objRepositoryUserRef.modifyUser(userId, name, lastName, password, description);
        return varFlag;
    }
}
