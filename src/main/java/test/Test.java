package test;

import dataAccess.conference.RepositorySQLiteConference;
import dataAccess.paper.RepositorySQLitePaper;
import dataAccess.paperReview.RepositorySQLitePaperReview;
import dataAccess.user.RepositorySQLiteUser;
import drivers.ConferenceStoreService;
import drivers.PaperReviewStoreService;
import drivers.PaperStoreService;
import drivers.UserStoreService;
import views.ViewLogIn;

public class Test {
    public static void main(String[] args) {
        //Repositortios
        RepositorySQLiteUser objRepositoryArrayListUser = new RepositorySQLiteUser();
        RepositorySQLiteConference objRepositoryArrayListConference = new RepositorySQLiteConference();
        RepositorySQLitePaperReview objRepositoryArrayListPaperReview = new RepositorySQLitePaperReview();
        RepositorySQLitePaper objRepositoryArrayListPaper = new RepositorySQLitePaper();
        //Inicializar servicios de almacenamiento
        UserStoreService objUserStoreService = new UserStoreService(objRepositoryArrayListUser);
        ConferenceStoreService objConferenceStoreService = new ConferenceStoreService(objRepositoryArrayListConference);
        PaperReviewStoreService objPaperReviewStoreService = new PaperReviewStoreService(objRepositoryArrayListPaperReview);
        PaperStoreService objPaperStoreService = new PaperStoreService(objRepositoryArrayListPaper);
        ViewLogIn objViewLogIn=new ViewLogIn(objUserStoreService,objConferenceStoreService,objPaperReviewStoreService,objPaperStoreService);
        objViewLogIn.setVisible(true);
        objViewLogIn.setLocationRelativeTo(null);
    }
}
