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
    //Titulo de la conferencia
    private String fldTitle;
    //Descripción de la conferencia
    private String fldDescription;
    //Ciudad de la conferencia
    private String fldCiudad;
    //Organizador de la conferencia
    private User fldConferenceAdmin;
    //Usuarios en la conferencia
    private ArrayList<User> fldUsersList;
    //Papers en la conferencia
    private ArrayList<PaperReview> fldPaperReviewsList;

    public Conference(String fldTitle, String fldDescription, String fldCiudad, User fldConferenceAdmin, ArrayList<User> fldUsersList, ArrayList<PaperReview> fldPaperReviewsList) {
        this.fldTitle = fldTitle;
        this.fldDescription = fldDescription;
        this.fldCiudad = fldCiudad;
        this.fldConferenceAdmin = fldConferenceAdmin;
        this.fldUsersList = fldUsersList;
        this.fldPaperReviewsList = fldPaperReviewsList;
    }

    public String getFldCiudad() {
        return fldCiudad;
    }

    public void setFldCiudad(String fldCiudad) {
        this.fldCiudad = fldCiudad;
    }

    public ArrayList<User> getFldUsersList() {
        return fldUsersList;
    }

    public void setFldUsersList(ArrayList<User> fldUsersList) {
        this.fldUsersList = fldUsersList;
    }

    public ArrayList<PaperReview> getFldPaperReviewsList() {
        return fldPaperReviewsList;
    }

    public void setFldPaperReviewsList(ArrayList<PaperReview> fldPaperReviewsList) {
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

    public ArrayList<PaperReview> getFldArrPaperReviews() {
        return fldPaperReviewsList;
    }

    public void setFldArrPaperReviews(ArrayList<PaperReview> fldPaperReviewsList) {
        this.fldPaperReviewsList = fldPaperReviewsList;
    }
    
}
