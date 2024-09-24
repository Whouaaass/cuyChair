/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dataAccess.user.RepositoryArrayListUser;
import domain.User;
import drivers.UserStoreService;
import javax.swing.JFrame;
import views.ViewMainMenu;

/**
 *
 * @author julia
 */
public class TestMainMenu {
        public static void main(String[] args) {
            RepositoryArrayListUser objRepositoryArrayListUser = new RepositoryArrayListUser();
            UserStoreService objUserStoreService = new UserStoreService(objRepositoryArrayListUser);
            User objUser = new User(1,"MiNombre","MiApellido","1234Jm","jm@gmail.com");
            ViewMainMenu objViewMainMenu=new ViewMainMenu(objUserStoreService,objUser);
            objViewMainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            objViewMainMenu.setVisible(true);
        }
}
