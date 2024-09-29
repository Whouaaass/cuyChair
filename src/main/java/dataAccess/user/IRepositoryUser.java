/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.user;

import domain.*;

import java.util.List;

/**
 * Interfaz que define los metodos para los repositorios de usuario
 *
 * @author julia
 * @author Frdy
 */
public interface IRepositoryUser {

    /**
     * Guarda un usuario
     *
     * @param objUser usuario a guardar
     * @return si el usuario se guardo correctamente
     */
    public boolean storeUser(User objUser);

    /**
     * Lista los usuarios
     *
     * @return lista de usuarios
     */
    public List<User> listUsers();

    /**
     * Busca un usuario por email
     *
     * @param email email del usuario
     * @return el primer usuario con ese email
     */
    public User getUserByEmail(String email);

    /**
     * Busca un usuario por id
     *
     * @param userId id del usuario
     * @return el primer usuario con ese id
     */
    public User getUserById(int userId);

    /**
     * Modifica el usuario
     *
     * @param userId   identificación del usuario a modificar
     * @param name     nombre del usuario
     * @param lastName apellido del usuario
     * @param password contraseña del usuario
     * @return Si la operacion fue exitosa
     */
    public boolean modifyUser(int userId, String name, String lastName, String password, String description);

    /**
     * Obtiene los participantes de la conferencia
     *
     * @param conference conferencias
     * @return
     */
    public List<User> listUsersRelatedTo(Conference conference);

    /**
     * Obtiene los participantes de la conferencia dado un rol
     * @param conference
     * @param role
     * @return
     */
    public List<User> listUsersRelatedTo(Conference conference, ConferenceParticipation.Role role);

    /**
     * Obtiene el organizador de una coferencia
     * @param conference
     * @return
     */
    public User getUserOrganizerOf(Conference conference);

    /**
     * Obtiene el revisor del articulo
     * @param paperReview
     */
    public User getReviewerOf(PaperReview paperReview);

    public User getAuthorOf(Paper paper);
}
