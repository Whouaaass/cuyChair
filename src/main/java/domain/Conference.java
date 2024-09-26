/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import dataAccess.paperReview.RepositoryArrayListPaperReview;
import dataAccess.user.RepositoryArrayListUser;
import drivers.PaperReviewStoreService;
import drivers.UserStoreService;
import java.util.ArrayList;
import java.util.Date;

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
    private String fldCity;
    //Organizador de la conferencia
    private User fldConferenceAdmin;
    //Fecha 
    private Date fldDate;
    //Lista de papers
    private ArrayList<Paper> fldPapers = new ArrayList<Paper>();
    //Lista de revisores
    private ArrayList<User> fldReviewers = new ArrayList<User>();
    //Lista de asistentes
    private ArrayList<User> fldAuthors = new ArrayList<User>();
    //Lista de reviews
    private ArrayList<PaperReview> fldReviews = new ArrayList<PaperReview>();
    
    
    public Conference(String fldTitle, Date fldDate,String fldDescription, String fldCiudad, User fldConferenceAdmin) {
        this.fldTitle = fldTitle;
        this.fldDate = fldDate;
        this.fldDescription = fldDescription;
        this.fldCity = fldCiudad;
        this.fldConferenceAdmin = fldConferenceAdmin;    
        this.fldAuthors = new ArrayList<User>();
        this.fldPapers = new ArrayList<Paper>();
        this.fldReviewers = new ArrayList<User>();
        this.fldReviews = new ArrayList<PaperReview>();
    }    
    
    public Date getDate() {
        return fldDate;
    }

    public void setDate(Date fldDate) {
        this.fldDate = fldDate;
    }   
    
    public String getCiudad() {
        return fldCity;
    }

    public void setCiudad(String fldCiudad) {
        this.fldCity = fldCiudad;
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

    public User getConferenceAdmin() {
        return fldConferenceAdmin;
    }

    public void setConferenceAdmin(User fldConferenceAdmin) {
        this.fldConferenceAdmin = fldConferenceAdmin;
    }

    public ArrayList<Paper> getPapers() {
        return fldPapers;
    }

    public void setPapers(ArrayList<Paper> fldPapers) {
        this.fldPapers = fldPapers;
    }

    public ArrayList<User> getReviewers() {
        return fldReviewers;
    }

    public void setReviewers(ArrayList<User> fldReviewers) {
        this.fldReviewers = fldReviewers;
    }

    public ArrayList<User> getAuthors() {
        return fldAuthors;
    }

    public void setAuthors(ArrayList<User> fldAuthors) {
        this.fldAuthors = fldAuthors;
    }

    public ArrayList<PaperReview> getReviews() {
        return fldReviews;
    }

    public void setReviews(ArrayList<PaperReview> fldReviews) {
        this.fldReviews = fldReviews;
    }
    
}
