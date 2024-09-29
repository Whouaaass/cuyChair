package domain.sql;

import context.AppContext;
import dataAccess.conference.IRepositoryConference;
import dataAccess.user.IRepositoryUser;
import domain.Conference;
import domain.Paper;
import domain.User;

public class SQLPaper extends Paper {
    public SQLPaper() {}

    @Override
    public User getAuthor() {
        IRepositoryUser repositoryUser = AppContext.getInstance().getRepositoryUser();
        if (fldAuthor != null) {
            fldAuthor = repositoryUser.getAuthorOf(this);
        }
        return fldAuthor;
    }

    @Override
    public Conference getConference() {
        IRepositoryConference repositoryConference = AppContext.getInstance().getRepositoryConference();
        if (fldConference != null) {
            fldConference = repositoryConference.getConferenceOf(this);
        }
        return fldConference;
    }

}
