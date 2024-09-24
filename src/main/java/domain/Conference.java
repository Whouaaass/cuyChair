/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Conference {
    private String fldTitle;
    private String fldDescription;
    //Organizador de la conferencia
    private User fldConferenceAdmin;
    //Usuarios en la conferencia
    private ArrayList<User> fldArrUsers;
    //Papers en la conferencia
    private ArrayList<PaperReview> fldArrPaperReviews;

    public Conference(String fldTitle, String fldDescription, User fldConferenceAdmin, ArrayList<User> fldArrUsers, ArrayList<PaperReview> fldArrPaperReviews) {
        this.fldTitle = fldTitle;
        this.fldDescription = fldDescription;
        this.fldConferenceAdmin = fldConferenceAdmin;
        this.fldArrUsers = fldArrUsers;
        this.fldArrPaperReviews = fldArrPaperReviews;
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

    public User getFldConferenceAdmin() {
        return fldConferenceAdmin;
    }

    public void setFldConferenceAdmin(User fldConferenceAdmin) {
        this.fldConferenceAdmin = fldConferenceAdmin;
    }

    public ArrayList<User> getFldArrUsers() {
        return fldArrUsers;
    }

    public void setFldArrUsers(ArrayList<User> fldArrUsers) {
        this.fldArrUsers = fldArrUsers;
    }

    public ArrayList<PaperReview> getFldArrPaperReviews() {
        return fldArrPaperReviews;
    }

    public void setFldArrPaperReviews(ArrayList<PaperReview> fldArrPaperReviews) {
        this.fldArrPaperReviews = fldArrPaperReviews;
    }
    
}
