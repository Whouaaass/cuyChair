package test;

import dataAccess.conference.RepositoryArrayListConference;
import dataAccess.conference.RepositorySQLiteConference;
import dataAccess.conferenceParticipation.RepositoryArrayListConferenceParticipation;
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

import context.AppContext;
import views.ViewLogIn;

public class Test {
    public static void main(String[] args) {
        //Repositortios
        RepositoryArrayListUser objRepositoryArrayListUser = new RepositoryArrayListUser();
        RepositoryArrayListConference objRepositoryArrayListConference = new RepositoryArrayListConference();
        RepositoryArrayListPaperReview objRepositoryArrayListPaperReview = new RepositoryArrayListPaperReview();
        RepositoryArrayListPaper objRepositoryArrayListPaper = new RepositoryArrayListPaper();
        RepositoryArrayListConferenceParticipation objRepositoryConferenceParticipation = new RepositoryArrayListConferenceParticipation();
        
        //LogIn inicializando
        AppContext.init(objRepositoryArrayListConference,objRepositoryArrayListUser,objRepositoryArrayListPaper,objRepositoryArrayListPaperReview, objRepositoryConferenceParticipation);
        ViewLogIn objViewLogIn=new ViewLogIn();        
        objViewLogIn.setVisible(true);
        objViewLogIn.setLocationRelativeTo(null);
    }
}
