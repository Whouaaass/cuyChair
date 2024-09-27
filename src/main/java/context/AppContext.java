package context;

import dataAccess.conference.IRepositoryConference;
import dataAccess.conference.RepositoryArrayListConference;
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

    //constructores
    private AppContext() {
        fldRepositoryConference = new RepositoryArrayListConference();
        fldRepositoryUser = new RepositoryArrayListUser();
        fldRepositoryPaper = new RepositoryArrayListPaper();
        fldRepositoryPaperReview = new RepositoryArrayListPaperReview();
    }
    private AppContext( IRepositoryUser repositoryUser, IRepositoryPaper repositoryPaper, IRepositoryPaperReview repositoryPaperReview,IRepositoryConference repositoryConference) {
        fldRepositoryUser = repositoryUser;
        fldRepositoryPaper = repositoryPaper;
        fldRepositoryPaperReview = repositoryPaperReview;
        fldRepositoryConference = repositoryConference;
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
    public static AppContext init( IRepositoryUser repositoryUser, IRepositoryPaper repositoryPaper, IRepositoryPaperReview repositoryPaperReview, IRepositoryConference repositoryConference) {
        instance = new AppContext( repositoryUser, repositoryPaper, repositoryPaperReview, repositoryConference);
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
    
    public void clear() {

    }
}
