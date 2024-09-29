/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Modelo de una conferencia
 * @author julia
 */
public class Conference {    
    //Id de la conferencia
    private int fldId;
    //Titulo de la conferencia
    private String fldTitle;
    //Descripción de la conferencia
    private String fldDescription;
    //Ciudad de la conferencia
    private String fldCity;
    //Organizador de la conferencia
    protected User fldConferenceOrganizer;
    //Fecha 
    private Date fldDate;    
    //Lista de papers
    protected List<Paper> fldPapers;
    //Lista de reviews
    protected List<PaperReview> fldReviews;
    //Lista de revisores
    protected List<User> fldReviewers;
    //Lista de asistentes
    protected List<User> fldAuthors;

    /**
     * Instancia una nueva conferencia
     * Este constructor es usado cuando se quiere instanciar una nueva conferencia con todos los datos
     * @param id
     * @param title
     * @param description
     * @param city
     * @param date
     * @param conferenceAdmin
     * @param papers
     * @param reviews
     * @param authors
     */
    public Conference(
            int id,
            String title,
            String description,
            String city, Date date,
            User conferenceAdmin,
            List<Paper> papers,
            List<PaperReview> reviews,
            List<User> authors
    ) {
        this(title,description,date,city);
        fldId = id;
        this.fldConferenceOrganizer = conferenceAdmin;
    }

    /**
     * Instancia una nueva conferencia
     * Este constructor es utilizado cuando se quiere traer una conferencia del repositorio
     * @param id
     * @param title
     * @param description
     * @param date
     * @param city
     */
    public Conference(int id, String title, String description, Date date, String city) {
        this(title, description, date, city);
        fldId = id;
    }

    /**
     * Instancia una nueva conferencia
     * Este constructor es utilizado cuando el usuario "crea" una nueva conferencia
     * @param title Titulo
     * @param description Description
     * @param date Fecha de Inicio
     * @param city Ciudad
     */
    public Conference(String title, String description, Date date, String city) {
        this.fldTitle = title;
        this.fldDescription = description;
        this.fldDate = date;
        this.fldCity = city;
        this.fldAuthors = new ArrayList<User>();
        this.fldPapers = new ArrayList<Paper>();
        this.fldReviewers = new ArrayList<User>();
        this.fldReviews = new ArrayList<PaperReview>();
    }

    /**
     * Instancia una conferencia vacia
     */
    public Conference() {

    }

    public int getId() {
        return fldId;
    }

    public void setFldId(int fldId) {
        this.fldId = fldId;
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

    public User getConferenceOrganizer() {
        return fldConferenceOrganizer;
    }

    public void setConferenceAdmin(User fldConferenceAdmin) {
        this.fldConferenceOrganizer = fldConferenceAdmin;
    }   
    
    public List<Paper> getPapers() {
        return fldPapers;
    }

    public void setPapers(List<Paper> fldPapers) {
        this.fldPapers = fldPapers;
    }

    public List<User> getReviewers() {
        return fldReviewers;
    }

    public void setReviewers(List<User> fldReviewers) {
        this.fldReviewers = fldReviewers;
    }

    public List<User> getAuthors() {
        return fldAuthors;
    }

    public void setAuthors(List<User> fldAuthors) {
        this.fldAuthors = fldAuthors;
    }

    public List<PaperReview> getReviews() {
        return fldReviews;
    }

    public void setReviews(List<PaperReview> fldReviews) {
        this.fldReviews = fldReviews;
    }   
    
}
