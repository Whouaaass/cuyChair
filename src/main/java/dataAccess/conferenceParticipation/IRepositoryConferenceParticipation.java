package dataAccess.conferenceParticipation;

import domain.Conference;
import domain.ConferenceParticipation;
import domain.User;

import java.util.List;

public interface IRepositoryConferenceParticipation {

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
}
