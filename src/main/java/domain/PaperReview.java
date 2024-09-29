/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 * @author julia
 * Modify by Juan
 */
public class PaperReview {
    private int fldId;

    //Paper de la review
    protected Paper fldPaper;

    protected User fldReviewer;

    //Indica si el paper se admite en la conferencia
    private boolean fldApproved;

    public PaperReview(int reviewId, Paper fldObjPaper, User fldReviewer, boolean fldApproved) {
        this(fldObjPaper, fldReviewer, fldApproved);
        this.fldId = reviewId;
    }

    public PaperReview(Paper fldObjPaper, User fldReviewer, boolean fldApproved) {
        this.fldPaper = fldObjPaper;
        this.fldApproved = fldApproved;
        this.fldReviewer = fldReviewer;
    }

    public PaperReview() {

    }

    public int getReviewId() {
        return fldId;
    }

    public void setReviewId(int reviewId) {
        this.fldId = reviewId;
    }

    public Paper getPaper() {
        return fldPaper;
    }

    public void setPaper(Paper fldObjPaper) {
        this.fldPaper = fldObjPaper;
    }

    public boolean isApproved() {
        return fldApproved;
    }

    public User getReviewer() {
        return fldReviewer;
    }

    public void setReviewer(User fldReviewer) {
        this.fldReviewer = fldReviewer;
    }

    public void setApproved(boolean fldApproved) {
        this.fldApproved = fldApproved;
    }

}
