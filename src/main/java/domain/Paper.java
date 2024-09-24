/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author julia
 */
public class Paper {
    private String fldTitle;
    private String fldDescription;
    //Autor del trabajo
    private User fldAutor;

    public Paper(String fldTitle, String fldDescription, User fldAutor) {
        this.fldTitle = fldTitle;
        this.fldDescription = fldDescription;
        this.fldAutor = fldAutor;
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
