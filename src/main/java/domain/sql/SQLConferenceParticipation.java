package domain.sql;

import context.AppContext;
import dataAccess.conference.IRepositoryConference;
import dataAccess.user.IRepositoryUser;
import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;

public class SQLConferenceParticipation extends ConferenceParticipation {

    private int userId;
    private int conferenceId;

    public SQLConferenceParticipation(int id, int userId, int conferenceId, ConferenceParticipation.Role role) {
        super(id, null, null, role);
        this.userId = userId;
        this.conferenceId = conferenceId;
    }

    @Override
    public User getParticipant() {
        IRepositoryUser repositoryUser = AppContext.getInstance().getRepositoryUser();
        if (fldParticipant == null) {
            fldParticipant = repositoryUser.getUserById(userId);
        }
        return fldParticipant;
    }

    @Override
    public Conference getConference() {
        IRepositoryConference repositoryConference = AppContext.getInstance().getRepositoryConference();
        if (fldConference == null) {
            fldConference = repositoryConference.getConferenceById(conferenceId);
        }
        return fldConference;
    }

}
