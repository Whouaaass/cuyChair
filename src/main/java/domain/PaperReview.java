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
    private int reviewId;
    //Paper de la review
    private Paper fldObjPaper;
    //Indica si el paper se admite en la conferencia
    private boolean fldAprobed;

    public PaperReview(int reviewId, Paper fldObjPaper, boolean fldAprobed) {
        this(fldObjPaper,fldAprobed);
        this.reviewId = reviewId;
    }

    public PaperReview(Paper fldObjPaper, boolean fldAprobed) {
        this.fldObjPaper = fldObjPaper;
        this.fldAprobed = fldAprobed;
    }


    public PaperReview(){

    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Paper getFldObjPaper() {
        return fldObjPaper;
    }

    public void setFldObjPaper(Paper fldObjPaper) {
        this.fldObjPaper = fldObjPaper;
    }

    public boolean isFldAprobed() {
        return fldAprobed;
    }

    public void setFldAprobed(boolean fldAprobed) {
        this.fldAprobed = fldAprobed;
    }
    
}
