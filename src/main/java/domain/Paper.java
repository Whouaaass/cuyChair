/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 * @author julia
 * Modifi by Juan
 */
public class Paper {
    private int fldId;
    private String fldTitle;
    private String fldDescription;
    //Autor del articulo
    protected User fldAuthor;
    protected Conference fldConference;

    public Paper(int fldId, String fldDescription, String fldTitle, User fldAutor, Conference fldConference) {
        this(fldDescription, fldTitle, fldAutor, fldConference);
        this.fldId = fldId;
    }

    public Paper(String fldTitle, String fldDescription, User fldAutor, Conference fldConference) {
        this.fldTitle = fldTitle;
        this.fldDescription = fldDescription;
        this.fldAuthor = fldAutor;
        this.fldConference = fldConference;
    }

    public Paper() {

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

    public Conference getConference() {
        return fldConference;
    }

    public void setConference(Conference fldConference) {
        this.fldConference = fldConference;
    }
}
