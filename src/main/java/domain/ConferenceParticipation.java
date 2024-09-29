package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa la participacion de un autor en una conferencia
 *
 * @author Frdy
 */
public class ConferenceParticipation {
    private int fldInt;
    protected User fldParticipant;
    protected Conference fldConference;
    private Role fldRole;

    public ConferenceParticipation(int id, User user, Conference conference, Role role) {
        this.fldInt = id;
        this.fldParticipant = user;
        this.fldConference = conference;
        this.fldRole = role;
    }

    public ConferenceParticipation() {}

    public int getId() {
        return fldInt;
    }

    public Role getRole() {
        return fldRole;
    }

    public Conference getConference() {
        return fldConference;
    }

    public User getParticipant() {
        return fldParticipant;
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
