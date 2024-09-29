package domain;

public class Participation {
    private User user;
    private Conference conference;
    private Role role;
    public Participation(User user, Conference conference, Role role) {
        this.user = user;
        this.conference = conference;
        this.role = role;
    }

    public enum Role {
        NULL,
        AUTHOR,
        REVIEWER,
        ORGANIZER,
    }
}
