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
    private ArrayList<User> fldUsersList;
    //Papers en la conferencia
    private ArrayList<PaperReview> fldPaperReviewsList;
    public Conference(String fldTitle, String fldDescription, User fldConferenceAdmin, ArrayList<User> fldArrUsers, ArrayList<PaperReview> fldPaperReviewsList) {
        this.fldTitle = fldTitle;
        this.fldDescription = fldDescription;
        this.fldConferenceAdmin = fldConferenceAdmin;
        this.fldUsersList = fldArrUsers;
        this.fldPaperReviewsList = fldPaperReviewsList;
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
        return this.fldUsersList;
    }

    public void setFldArrUsers(ArrayList<User> fldArrUsers) {
        this.fldUsersList = fldArrUsers;
    }

    public ArrayList<PaperReview> getFldArrPaperReviews() {
        return fldPaperReviewsList;
    }

    public void setFldArrPaperReviews(ArrayList<PaperReview> fldPaperReviewsList) {
        this.fldPaperReviewsList = fldPaperReviewsList;
    }
    
}
