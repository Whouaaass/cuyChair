package test;

import dataAccess.conference.RepositoryArrayListConference;
import dataAccess.conference.RepositorySQLiteConference;
import dataAccess.paper.RepositoryArrayListPaper;
import dataAccess.paper.RepositorySQLitePaper;
import dataAccess.paperReview.RepositoryArrayListPaperReview;
import dataAccess.paperReview.RepositorySQLitePaperReview;
import dataAccess.user.RepositoryArrayListUser;
import dataAccess.user.RepositorySQLiteUser;
import drivers.ConferenceStoreService;
import drivers.PaperReviewStoreService;
import drivers.PaperStoreService;
import drivers.UserStoreService;
import javax.swing.JFrame;
import views.ViewLogIn;

public class Test {
    public static void main(String[] args) {
        //Repositortios
        RepositoryArrayListUser objRepositoryArrayListUser = new RepositoryArrayListUser();
        RepositoryArrayListConference objRepositoryArrayListConference = new RepositoryArrayListConference();
        RepositoryArrayListPaperReview objRepositoryArrayListPaperReview = new RepositoryArrayListPaperReview();
        RepositoryArrayListPaper objRepositoryArrayListPaper = new RepositoryArrayListPaper();
        //Inicializar servicios de almacenamiento
        UserStoreService objUserStoreService = new UserStoreService(objRepositoryArrayListUser);
        ConferenceStoreService objConferenceStoreService = new ConferenceStoreService(objRepositoryArrayListConference);
        PaperReviewStoreService objPaperReviewStoreService = new PaperReviewStoreService(objRepositoryArrayListPaperReview);
        PaperStoreService objPaperStoreService = new PaperStoreService(objRepositoryArrayListPaper);
        //LogIn inicializando
        ViewLogIn objViewLogIn=new ViewLogIn(objUserStoreService,objConferenceStoreService,objPaperReviewStoreService,objPaperStoreService);
        objViewLogIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        objViewLogIn.setVisible(true);
        objViewLogIn.setLocationRelativeTo(null);
    }
}
