/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.conference;

import domain.Conference;
import domain.Paper;
import domain.PaperReview;
import domain.User;
import java.util.List;

/**
 *
 * @author julia
 */
public interface IRepositoryConference {
    /**
     * Guarda una conferencia
     * 
     * @param objConference obj conferencia a guardar
     * @return Si el almacenamiento fue correcto
     */
    public boolean storeConference(Conference objConference);

    /**
     * Función que returna la lista total de conferencias
     * 
     * @return
     */
    public List<Conference> listConference();

    /**
     * Funcion que retorna la lista de conferencias a las que asiste un usuario
     * 
     * @param objUser usuario asistente de las conferencias
     * @return la lista de conferencias a las que asiste un usuario
     */
    public List<Conference> listConferenceByUserAssistant(int userId);

    /**
     * Funcion que retorna la lista de conferencias que son propiedad del usuario
     * es decir, en las que el usurio es organizador
     * 
     * @param objUser usuario propietario de las conferencias
     * @return la lista de conferencias que son propiedad del usuario
     */
    public List<Conference> listConferenceByUserOwner(int ownerId);

    /**
     * Funcion que retorna una conferencia por id
     * 
     * @param conferenceId Id de conferencia
     * @return una conferencia
     */

    /**
     * Funcion que retorna una lista de revisores de una conferencia
     * 
     * @param conference
     * @return
     */
    public List<User> listReviewers(int conferenceId);

    /**
     * Funcion que retorna una lista de autores de una conferencia
     * 
     * @param conference
     * @return
     */
    public List<User> listAuthors(int conferenceId);

    /**
     * Funcion que retorna una lista de papers de una conferencia
     * @param conferenceId
     * @return
     */
    public List<Paper> listPapers(int conferenceId);

    /**
     * Funcion que retorna una lista de reviews de una conferencia
     * @param conferenceId
     * @return
     */
    public List<PaperReview> listReviews(int conferenceId);

    /**
     * Función que retorna una conferencia dado su id
     * 
     * @param conference
     * @return
     */
    public Conference getConferenceById(int conferenceId);

    /**
     * Función que retorna el organizador de una conferencia
     */
    public User getConferenceOrganizer(int conferenceId);
    
}
