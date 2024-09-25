/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author julia
 *  Modifi by Juan
 */
public class Paper {
    private int fldId;
    private String fldTitle;
    private String fldDescription;
    //Autor del trabajo
    private User fldAutor;

    public Paper(int fldId, String fldDescription, String fldTitle, User fldAutor) {
        this(fldDescription,fldTitle,fldAutor);
        this.fldId = fldId;
    }

    public Paper(String fldTitle, String fldDescription, User fldAutor) {
        this.fldTitle = fldTitle;
        this.fldDescription = fldDescription;
        this.fldAutor = fldAutor;
    }

    public Paper(){

    }

    public int getFldId() {
        return fldId;
    }

    public void setFldId(int fldId) {
        this.fldId = fldId;
    }

    public String getFldTitle() {
        return fldTitle;
    }

    public void setFldTitle(String fldTitle) {
        this.fldTitle = fldTitle;
    }

    public String getFldDescription() {
        return fldDescription;
    }

    public void setFldDescription(String fldDescription) {
        this.fldDescription = fldDescription;
    }

    public User getFldAutor() {
        return fldAutor;
    }

    public void setFldAutor(User fldAutor) {
        this.fldAutor = fldAutor;
    }
    
    
}
