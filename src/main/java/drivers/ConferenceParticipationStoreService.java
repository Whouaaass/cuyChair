/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drivers;

import dataAccess.conferenceParticipation.IRepositoryConferenceParticipation;
import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;

import java.util.List;

/**
 *
 * @author Frdy
 */
public class ConferenceParticipationStoreService {

    private final IRepositoryConferenceParticipation fldRepositoryConferenceParticipation;

    public ConferenceParticipationStoreService(IRepositoryConferenceParticipation repositoryConferenceParticipation) {
        fldRepositoryConferenceParticipation = repositoryConferenceParticipation;
    }

    public boolean createConferenceParticipation(User participant, Conference conference, ConferenceParticipation.Role rol) {
        return fldRepositoryConferenceParticipation.createParticipation(participant, conference, rol) != null;
    }

    public List<ConferenceParticipation> ListParticipationsOf(Conference conference) {
        return fldRepositoryConferenceParticipation.getParticipationsOf(conference);
    }

    public List<ConferenceParticipation> listParticipationsOf(User user) {
        return fldRepositoryConferenceParticipation.getParticipationsOf(user);
    }
}
