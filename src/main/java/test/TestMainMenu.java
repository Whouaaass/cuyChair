/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dataAccess.conference.RepositorySQLiteConference;
import dataAccess.paper.RepositorySQLitePaper;
import dataAccess.paperReview.RepositorySQLitePaperReview;
import dataAccess.user.RepositorySQLiteUser;
import domain.User;
import drivers.ConferenceStoreService;
import drivers.PaperReviewStoreService;
import drivers.PaperStoreService;
import drivers.UserStoreService;
import javax.swing.JFrame;

import context.AppContext;
import views.ViewMainMenu;

/**
 *
 * @author julia
 */
public class TestMainMenu {
        public static void main(String[] args) {
            RepositorySQLiteUser objRepositoryArrayListUser = new RepositorySQLiteUser();
            RepositorySQLiteConference objRepositoryArrayListConference = new RepositorySQLiteConference();
            RepositorySQLitePaperReview objRepositoryArrayListPaperReview = new RepositorySQLitePaperReview();
            RepositorySQLitePaper objRepositoryArrayListPaper = new RepositorySQLitePaper();
            
            User objUser = new User(1,"MiNombre","MiApellido","1234Jm","jm@gmail.com");
            AppContext.getInstance().setLoggedUser(objUser);
            AppContext.init(objRepositoryArrayListUser,objRepositoryArrayListPaper,objRepositoryArrayListPaperReview,objRepositoryArrayListConference);
            ViewMainMenu objViewMainMenu=new ViewMainMenu();
            objViewMainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            objViewMainMenu.setVisible(true);
        }
}
