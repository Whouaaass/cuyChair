package domain.sql;

import java.util.List;

import context.AppContext;
import dataAccess.conferenceParticipation.IRepositoryConferenceParticipation;
import dataAccess.paper.IRepositoryPaper;
import dataAccess.paperReview.IRepositoryPaperReview;
import dataAccess.user.IRepositoryUser;
import domain.*;

/**
 * Es una conferencia que sobrecarga los métodos de get que implican una relacion
 * para implementar lazy loading
 * @implNote Esta clase se debe implementar únicamente con repositorios SQL
 * @author Frdy
 */
public class SQLConference extends Conference {

    @Override
    public List<Paper> getPapers() {
        IRepositoryPaper paperRepository = AppContext.getInstance().getRepositoryPaper();
        if (super.fldPapers == null) {
            super.fldPapers = paperRepository.listPapersFrom(this);
        }
        return super.fldPapers;
    }

    @Override
    public List<PaperReview> getReviews() {
        IRepositoryPaperReview paperReviewRepository = AppContext.getInstance().getRepositoryPaperReview();
        if (super.fldReviews == null) {
            super.fldReviews = paperReviewRepository.getPaperReviewsRelatedTo(this);
        }
        return super.fldReviews;
    }

    @Override
    public User getConferenceOrganizer() {
        IRepositoryUser userRepository = AppContext.getInstance().getRepositoryUser();
        if (super.fldConferenceOrganizer == null) {
            super.fldConferenceOrganizer = userRepository.getUserOrganizerOf(this);
        }
        return super.fldConferenceOrganizer;
    }

    @Override
    public List<ConferenceParticipation> getParticipations() {
        IRepositoryConferenceParticipation repositoryConferenceParticipation = AppContext.getInstance().getRepositoryConferenceParticipation();
        if (super.fldParticipations == null) {
            super.fldParticipations = repositoryConferenceParticipation.getParticipationsOf(this);
        }
        return super.fldParticipations;
    }
}
