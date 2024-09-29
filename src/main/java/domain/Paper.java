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
    private User fldAuthor;

    public Paper(int fldId, String fldDescription, String fldTitle, User fldAutor) {
        this(fldDescription,fldTitle,fldAutor);
        this.fldId = fldId;
    }

    public Paper(String fldTitle, String fldDescription, User fldAutor) {
        this.fldTitle = fldTitle;
        this.fldDescription = fldDescription;
        this.fldAuthor = fldAutor;
    }

    public Paper(){

    }

    public int getId() {
        return fldId;
    }

    public void setId(int fldId) {
        this.fldId = fldId;
    }

    public String getTitle() {
        return fldTitle;
    }

    public void setTitle(String fldTitle) {
        this.fldTitle = fldTitle;
    }

    public String getDescription() {
        return fldDescription;
    }

    public void setDescription(String fldDescription) {
        this.fldDescription = fldDescription;
    }

    public User getAuthor() {
        return fldAuthor;
    }

    public void setAuthor(User fldAutor) {
        this.fldAuthor = fldAutor;
    }
}
