/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drivers;

import dataAccess.conference.IRepositoryConference;
import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;

import infra.Subject;

import java.util.List;

/**
 * Servicio de gestion de almacenamiento de conferencia
 *
 * @author julia
 * @author Frdy
 */
public class ConferenceStoreService extends Subject {
    private final IRepositoryConference objRepositoryConferenceRef;

    /**
     * Instancia un objeto de la clase ConferenceStoreService
     *
     * @param objRepositoryConference Repositorio que utilizara el servicio
     */
    public ConferenceStoreService(IRepositoryConference objRepositoryConference) {
        this.objRepositoryConferenceRef = objRepositoryConference;
    }

    /**
     * Guarda un Conference
     *
     * @param objConference Conferencia a guardar
     * @return si el guardado fue correcto
     */
    public boolean storeConference(Conference objConference) {
        return this.objRepositoryConferenceRef.storeConference(objConference);
    }

    /**
     * Lista los Conference
     *
     * @return lista de paperReviews
     */
    public List<Conference> listConference() {
        return this.objRepositoryConferenceRef.listConference();
    }

    public List<Conference> listAssistantConferences(User user) {
        return objRepositoryConferenceRef.listConferenceRelatedTo(user);
    }

    public List<Conference> listConferenceByOwner(User user) {
        return objRepositoryConferenceRef.listConferenceOrganizedBy(user);
    }
    
    public List<Conference> listConferencesRelatedTo(User user, ConferenceParticipation.Role rol) {
        return objRepositoryConferenceRef.listConferenceRelatedTo(user, rol);
    }

    public List<Conference> listConferencesRelatedTo(User user) {
        List<Conference> li = objRepositoryConferenceRef.listConferenceOrganizedBy(user);
        li.addAll(objRepositoryConferenceRef.listConferenceRelatedTo(user));
        return li;
    }

    public Conference getConferenceById(int id){
        return objRepositoryConferenceRef.getConferenceById(id);
    }


}
