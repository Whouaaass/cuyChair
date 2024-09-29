package dataAccess.conferenceParticipation;

import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class RepositoryArrayListConferenceParticipation implements IRepositoryConferenceParticipation {
    private List<ConferenceParticipation> fldParticipations;

    public RepositoryArrayListConferenceParticipation() {
        fldParticipations = new ArrayList<>();
    }

    @Override
    public List<ConferenceParticipation> getParticipationsOf(User user) {
        List<ConferenceParticipation> participations = new ArrayList<>();
        for (ConferenceParticipation participation : fldParticipations) {
            if (participation.getParticipant().equals(user)) {
                participations.add(participation);
            }
        }
        return participations;
    }

    @Override
    public List<ConferenceParticipation> getParticipationsOf(Conference conference) {
        List<ConferenceParticipation> participations = new ArrayList<>();
        for (ConferenceParticipation participation : fldParticipations) {
            if (participation.getConference().equals(conference)) {
                participations.add(participation);
            }
        }
        return participations;
    }
}
