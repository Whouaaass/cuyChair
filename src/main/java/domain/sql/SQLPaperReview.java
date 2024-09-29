package domain.sql;

import context.AppContext;
import dataAccess.paper.IRepositoryPaper;
import dataAccess.user.IRepositoryUser;
import domain.Paper;
import domain.PaperReview;
import domain.User;

public class SQLPaperReview extends PaperReview {

    public SQLPaperReview() {}

    @Override
    public User getReviewer() {
        IRepositoryUser repositoryUser = AppContext.getInstance().getRepositoryUser();
        if (super.fldReviewer == null) {
            super.fldReviewer =  repositoryUser.getReviewerOf(this);
        }
        return super.fldReviewer;
    }

    @Override
    public Paper getPaper() {
        IRepositoryPaper repositoryPaper = AppContext.getInstance().getRepositoryPaper();
        if (super.fldPaper == null) {
            super.fldPaper = repositoryPaper.getPaperOfReview(this);
        }
        return super.fldPaper;
    }
}
