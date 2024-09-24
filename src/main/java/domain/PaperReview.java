/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author julia
 */
public class PaperReview {
    //Paper de la review
    private Paper fldObjPaper;
    //Indica si el paper se admite en la conferencia
    private boolean fldAprobed;

    public PaperReview(Paper fldObjPaper, boolean fldAprobed) {
        this.fldObjPaper = fldObjPaper;
        this.fldAprobed = fldAprobed;
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
