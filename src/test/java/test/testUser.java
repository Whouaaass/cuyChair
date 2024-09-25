/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dataAccess.user.RepositoryArrayListUser;
import dataAccess.user.RepositorySQLiteUser;
import domain.Paper;
import domain.User;
import domain.User;
import drivers.UserStoreService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author julia
 */
public class testUser {
    @Test
    public void testSQLiteRepository(){
        //Repositorio
        RepositorySQLiteUser objRepositorySQLiteUser = new RepositorySQLiteUser();
        UserStoreService objUserStoreService = new UserStoreService(objRepositorySQLiteUser);
        //Conferencia a comparar
        User objUser = new User(1,"pepo","perez","seguridad123A","pepopepon@gmail.com");
        objUserStoreService.storeUser(objUser);
        assertEquals(objUser.getUserId(),objUserStoreService.listUsers().getFirst().getUserId());
    }
    @Test
    public void testArrayRepository(){
        //Repositorio
        RepositoryArrayListUser objRepositorySQLiteUser = new RepositoryArrayListUser();
        UserStoreService objUserStoreService = new UserStoreService(objRepositorySQLiteUser);
        //Conferencia a comparar
        User objUser = new User(1,"pepo","perez","seguridad123A","pepopepon@gmail.com");
        objUserStoreService.storeUser(objUser);
        assertEquals(objUser.getUserId(),objUserStoreService.listUsers().getFirst().getUserId());
    }
}
