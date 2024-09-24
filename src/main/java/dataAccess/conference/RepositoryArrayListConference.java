/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import domain.Conference;
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
    public RepositoryArrayListConference(ArrayList<Conference> ConferenceList) {
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
    
}
