package context;

import dataAccess.conference.IRepositoryConference;
import dataAccess.conference.RepositoryArrayListConference;
import dataAccess.conferenceParticipation.IRepositoryConferenceParticipation;
import dataAccess.conferenceParticipation.RepositoryArrayListConferenceParticipation;
import dataAccess.paper.IRepositoryPaper;
import dataAccess.paper.RepositoryArrayListPaper;
import dataAccess.paperReview.IRepositoryPaperReview;
import dataAccess.paperReview.RepositoryArrayListPaperReview;
import dataAccess.user.IRepositoryUser;
import dataAccess.user.RepositoryArrayListUser;
import domain.User;

public class AppContext {
    private static AppContext instance = new AppContext();

    //usuario logueado
    private User loggedUser;

    //repositorios
    private IRepositoryConference fldRepositoryConference;
    private IRepositoryUser fldRepositoryUser;
    private IRepositoryPaper fldRepositoryPaper;
    private IRepositoryPaperReview fldRepositoryPaperReview;
    private IRepositoryConferenceParticipation fldRepositoryConferenceParticipation;

    //constructores
    private AppContext() {
        fldRepositoryConference = new RepositoryArrayListConference();
        fldRepositoryUser = new RepositoryArrayListUser();
        fldRepositoryPaper = new RepositoryArrayListPaper();
        fldRepositoryPaperReview = new RepositoryArrayListPaperReview();
        fldRepositoryConferenceParticipation = new RepositoryArrayListConferenceParticipation();
    }
    private AppContext(
            IRepositoryConference repositoryConference,
            IRepositoryUser repositoryUser,
            IRepositoryPaper repositoryPaper,
            IRepositoryPaperReview repositoryPaperReview,
            IRepositoryConferenceParticipation repositoryConferenceParticipation) {
        fldRepositoryConference = repositoryConference;
        fldRepositoryUser = repositoryUser;
        fldRepositoryPaper = repositoryPaper;
        fldRepositoryPaperReview = repositoryPaperReview;
        fldRepositoryConferenceParticipation = repositoryConferenceParticipation;
    }

    /**
     * Instancia o devuelve la instancia de la clase
     * @return Instancia de AppContext
     */
    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    /**
     * Inicializa la instancia de la clase con los repositorios pasados por parámetro
     * @param repositoryConference
     * @param repositoryUser
     * @param repositoryPaper
     * @param repositoryPaperReview
     * @return instancia de la clase
     */
    public static AppContext init(IRepositoryConference repositoryConference,
                                  IRepositoryUser repositoryUser,
                                  IRepositoryPaper repositoryPaper,
                                  IRepositoryPaperReview repositoryPaperReview,
                                  IRepositoryConferenceParticipation repositoryConferenceParticipation
    ) {
        instance = new AppContext(repositoryConference, repositoryUser, repositoryPaper, repositoryPaperReview, repositoryConferenceParticipation);
        return instance;
    }

    /**
     * Inicializa la instancia de la clase con los repositorios por defecto
     * @return instancia de la clase
     */
    public static AppContext init() {
        instance = new AppContext();
        return instance;
    }
    
    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public IRepositoryConference getRepositoryConference() {
        return fldRepositoryConference;
    }

    public IRepositoryUser getRepositoryUser() {
        return fldRepositoryUser;
    }

    public IRepositoryPaper getRepositoryPaper() {
        return fldRepositoryPaper;
    }

    public IRepositoryPaperReview getRepositoryPaperReview() {
        return fldRepositoryPaperReview;
    }

    public IRepositoryConferenceParticipation getFldRepositoryConferenceParticipation() { return fldRepositoryConferenceParticipation; }
    
    public void clear() {

    }
}
