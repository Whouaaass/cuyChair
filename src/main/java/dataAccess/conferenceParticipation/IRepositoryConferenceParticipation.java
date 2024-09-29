package dataAccess.conferenceParticipation;

import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;

import java.util.List;

public interface IRepositoryConferenceParticipation {

    /**
     * Guarda las participaciones
     * @param conference
     * @param user
     * @param rol
     * @return
     */
    public ConferenceParticipation createParticipation(User user, Conference conference, ConferenceParticipation.Role rol);

    /**
     * Retorna las participaciones de un usuario
     * @param user usuario
     * @return participaciones
     */
    public List<ConferenceParticipation> getParticipationsOf(User user);

    /**
     * Retorna las particiones que tiene una conferencia
     * @param conference conferencia
     * @return participaciones
     */
    public List<ConferenceParticipation> getParticipationsOf(Conference conference);

    /**
     * Obtiene las participaciones de un usuario en una conferencia
     * @param user
     * @param conference
     * @return
     */
    public List<ConferenceParticipation> getParticipationsOf(User user, Conference conference);

    /**
     * Remueve una participacion de un usuario en una conferencia
     * @param conferenceParticipation
     * @return
     */
    public boolean RemoveParticipation(ConferenceParticipation conferenceParticipation);
}
