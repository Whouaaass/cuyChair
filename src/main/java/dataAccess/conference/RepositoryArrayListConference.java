/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import dataAccess.ConnectionSqlitePool;
import domain.Conference;
import domain.User;
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
     * @param objRepositoryConference Repositorio que utilizara el servicio
     */
    public RepositoryArrayListConference() {
        this.ListConference=new ArrayList<>();
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

        return null;
    }

    @Override
    public List<Conference> listConferenceByUserAssistant(User objUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Conference> listConferenceByUserOwner(User objUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Conference getConferenceById(int conferenceId) {
        return null;
    }


}
