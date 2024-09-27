/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import domain.Conference;
import domain.Paper;
import domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class RepositoryArrayListConference implements IRepositoryConference{
    private ArrayList<Conference> ConferenceList;
     /**
     * Instancia un objeto de la clase ConferenceStoreService
     * @param objRepositoryConference Repositorio que utilizara el servicio
     */
    public RepositoryArrayListConference() {
        this.ConferenceList = new ArrayList();
    }
    /**
     * Guarda un Conference
     * @param objConference Conferencia a guardar
     * @return si el guardado fue correcto
     */
    @Override
    public boolean storeConference(Conference objConference) {
        boolean varFlag=this.ConferenceList.add(objConference);
        return varFlag;
    }
    /**
     * Lista los Conference
     * @return lista de paperReviews
     */
    @Override
    public List<Conference> listConference() {
        return this.ConferenceList;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addPaper(int idConference, Paper objPaper) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
