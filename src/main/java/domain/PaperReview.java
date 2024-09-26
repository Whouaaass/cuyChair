/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author julia
 * Modify by Juan
 */
public class PaperReview {
    private int fldId;
    //Paper de la review
    private Paper fldObjPaper;
    //Indica si el paper se admite en la conferencia
    private boolean fldApproved;

    public PaperReview(int reviewId, Paper fldObjPaper, boolean fldAprobed) {
        this(fldObjPaper,fldAprobed);
        this.fldId = reviewId;
    }

    public PaperReview(Paper fldObjPaper, boolean fldApproved) {
        this.fldObjPaper = fldObjPaper;
        this.fldApproved = fldApproved;
    }
    
    public PaperReview(){

    }

    public int getReviewId() {
        return fldId;
    }

    public void setReviewId(int reviewId) {
        this.fldId = reviewId;
    }

    public Paper getObjPaper() {
        return fldObjPaper;
    }

    public void setObjPaper(Paper fldObjPaper) {
        this.fldObjPaper = fldObjPaper;
    }

    public boolean isAprobed() {
        return fldApproved;
    }

    public void setAprobed(boolean fldAprobed) {
        this.fldApproved = fldAprobed;
    }
    
}
