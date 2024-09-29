package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa la participacion de un autor en una conferencia
 *
 * @author Frdy
 */
public class ConferenceParticipation {
    private User participant;
    private Conference conference;
    private Role role;

    public ConferenceParticipation(User user, Conference conference, Role role) {
        this.participant = user;
        this.conference = conference;
        this.role = role;
    }
    public ConferenceParticipation() {}

    public Role getRole() {
        return role;
    }

    public Conference getConference() {
        return conference;
    }

    public User getParticipant() {
        return participant;
    }

    public enum Role {
        AUTHOR(1),
        REVIEWER(2),
        ORGANIZER(3);

        private int fldValue;
        Role(int value) {
            fldValue = value;
        }

        private static final Map<Integer, Role> fldMap = new HashMap<>();
        static {
            for (Role role : Role.values()) {
                fldMap.put(role.fldValue, role);
            }
        }

        public static Role valueOf(int value) {
            return fldMap.get(value);
        }

        public int value() {
            return fldValue;
        }


    }
}
