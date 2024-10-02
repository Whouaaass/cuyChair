/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.conference;

import domain.*;

import java.util.List;

/**
 * Interfaz que define los métodos del repositorio de conferencias
 *
 * @author julia
 * @author Frdy
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
     * @return la lista de conferencias a las que asiste un usuario
     */
    public List<Conference> listConferenceRelatedTo(User user);

    /**
     * Funcion que retorna las conferencias a las que un usuario esta asociado por un rol
     *
     * @param user
     * @return
     */
    public List<Conference> listConferenceRelatedTo(User user, ConferenceParticipation.Role role);

    /**
     * Funcion que retorna la lista de conferencias que son propiedad del usuario
     * es decir, en las que el usurio es organizador
     *
     * @param organizer organizador de esas conferencias
     * @return la lista de conferencias que son propiedad del usuario
     */
    public List<Conference> listConferenceOrganizedBy(User organizer);

    /**
     * Función que retorna una conferencia dado su id
     *
     * @param conferenceId id de la conferencia
     * @return Coferencia
     */
    public Conference getConferenceById(int conferenceId);

    /**
     * Función que retorna la conferencia de un Paper
     * @param paper paper
     * @return conferencia asociada
     */
    public Conference getConferenceOf(Paper paper);


}
