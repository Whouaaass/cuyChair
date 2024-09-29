package dataAccess.conferenceParticipation;

import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;
import domain.sql.SQLConference;
import domain.sql.SQLConferenceParticipation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositoryArrayListConferenceParticipation implements IRepositoryConferenceParticipation {
    private List<ConferenceParticipation> fldParticipations;
    private AtomicInteger indexCounter;

    public RepositoryArrayListConferenceParticipation() {
        indexCounter = new AtomicInteger(0);
        fldParticipations = new ArrayList<>();
    }

    @Override
    public ConferenceParticipation createParticipation(User user, Conference conference, ConferenceParticipation.Role rol) {
        return new ConferenceParticipation(indexCounter.getAndIncrement(), user, conference, rol);
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

    @Override
    public List<ConferenceParticipation> getParticipationsOf(User user, Conference conference) {
        List<ConferenceParticipation> participations = new ArrayList<>();
        for (ConferenceParticipation participation : fldParticipations) {
            if (participation.getParticipant().equals(user) && participation.getConference().equals(conference)) {
                participations.add(participation);
            }
        }
        return participations;
    }

    @Override
    public boolean RemoveParticipation(ConferenceParticipation conferenceParticipation) {
        boolean flag;
        flag = conferenceParticipation.getParticipant().getParticipations().remove(conferenceParticipation);
        flag = flag && conferenceParticipation.getConference().getParticipations().remove(conferenceParticipation);
        flag = flag && fldParticipations.remove(conferenceParticipation);
        return flag;
    }

}
