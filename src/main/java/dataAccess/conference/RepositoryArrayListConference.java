/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class RepositoryArrayListConference implements IRepositoryConference{
    private List<Conference> ListConference;
     /**
     * Instancia un objeto de la clase ConferenceStoreService
     */
    public RepositoryArrayListConference() {
        this.ListConference = new ArrayList<>();
    }
    /**
     * Guarda un Conference
     * @param objConference Conferencia a guardar
     * @return si el guardado fue correcto
     */
    @Override
    public boolean storeConference(Conference objConference) {
        boolean varFlag=ListConference.add(objConference);
        return varFlag;
    }
    /**
     * Lista los Conference
     * @return lista de paperReviews
     */
    @Override
    public List<Conference> listConference() {
        return ListConference;
    }

    @Override
    public List<Conference> listConferenceRelatedTo(User user) {
        List<Conference> conferenceList = new ArrayList<>();
        for (ConferenceParticipation participation : user.getParticipations()) {
            conferenceList.add(participation.getConference());
        }
        return conferenceList;
    }

    @Override
    public List<Conference> listConferenceRelatedTo(User user, ConferenceParticipation.Role role) {
        List<Conference> userConferenceList = new ArrayList<>();
        for (ConferenceParticipation conference : user.getParticipations()) {
            userConferenceList.add(conference.getConference());
        }
        return userConferenceList;
    }

    @Override
    public List<Conference> listConferenceOrganizedBy(User organizer) {
        List<Conference> organizerConferenceList = new ArrayList<>();
        for (Conference conference : ListConference) {
            if (conference.getConferenceOrganizer().getUserId() == organizer.getUserId()) {
                organizerConferenceList.add(conference);
            }
        }
        return organizerConferenceList;
    }

    @Override
    public Conference getConferenceById(int conferenceId) {
        for (Conference conference : ListConference) {
            if (conference.getId() == conferenceId) {
                return conference;
            }
        }
        return null;
    }

    @Override
    public boolean addPaper(int idConference, Paper objPaper) {
        for(int i=0;i<this.ListConference.size();i++){
            if(ListConference.get(i).getId()==idConference){
                return this.ListConference.get(i).getPapers().add(objPaper);
            }
        }
        return false;
    }
    public Conference getConferenceOf(Paper paper) {
        return paper.getConference();

    }


}
