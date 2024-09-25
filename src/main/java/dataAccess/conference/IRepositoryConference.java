/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.conference;

import domain.Conference;
import domain.User;
import java.util.List;

/**
 *
 * @author julia
 */
public interface IRepositoryConference {
    /**
     * Guarda una conferencia
     * @param objConference obj conferencia a guardar
     * @return Si el almacenamiento fue correcto
     */
    public boolean storeConference(Conference objConference);
    /**
     * Función que returna la lista total de conferencias
     * @return 
     */
    public List<Conference> listConference();
    /**
     * Funcion que retorna la lista de conferencias a las que asiste un usuario
     * @param objUser usuario asistente de las conferencias
     * @return la lista de conferencias a las que asiste un usuario
     */
    public List<Conference> listConferenceByUserAssistant(User objUser);
    /**
     * Funcion que retorna la lista de conferencias que son propiedad del usuario
     * @param objUser usuario propietario de las conferencias
     * @return la lista de conferencias que son propiedad del usuario
     */
    public List<Conference> listConferenceByUserOwner(User objUser);
}
