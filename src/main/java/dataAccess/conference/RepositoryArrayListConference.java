/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.conference;

import domain.Conference;
import domain.Paper;
import domain.PaperReview;
import domain.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class RepositoryArrayListConference implements IRepositoryConference{
    private List<Conference> fldConferenceList;
     /**
     * Instancia un objeto de la clase ConferenceStoreService
     * @param objRepositoryConference Repositorio que utilizara el servicio
     */
    public RepositoryArrayListConference() {
        this.fldConferenceList=new ArrayList<>();
    }
    /**
     * Guarda un Conference
     * @param objConference Conferencia a guardar
     * @return si el guardado fue correcto
     */
    @Override
    public boolean storeConference(Conference objConference) {
        boolean varFlag=fldConferenceList.add(objConference);
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
    public List<Conference> listConferenceByUserAssistant(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Conference> listConferenceByUserOwner(int ownerId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Conference getConferenceById(int conferenceId) {
        return null;
    }
    @Override
    public List<User> listReviewers(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listReviewers'");
    }
    @Override
    public List<User> listAuthors(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listAuthors'");
    }
    @Override
    public List<Paper> listPapers(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listPapers'");
    }
    @Override
    public List<PaperReview> listReviews(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'listReviews'");
    }
    @Override
    public User getConferenceOrganizer(int conferenceId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getConferenceOrganizer'");
    }


}
