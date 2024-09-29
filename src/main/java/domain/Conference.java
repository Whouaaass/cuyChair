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
 *
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
    protected List<ConferenceParticipation> fldParticipations;

    public Conference(int id, String title, String description, String city, Date date, User conferenceOrganizer, List<Paper> papers, List<ConferenceParticipation> participations) {
        this(title, description, city, date, conferenceOrganizer);
        fldId = id;
        this.fldConferenceOrganizer = conferenceOrganizer;
        this.fldParticipations = participations;
    }

    public Conference(int id, String title, String description, String city, Date date, User conferenceAdmin) {
        this(title, description, city, date, conferenceAdmin);
        fldId = id;
    }

    public Conference(String title, String description, String city, Date date, User conferenceOrganizer) {
        this.fldTitle = title;
        this.fldDescription = description;
        this.fldDate = date;
        this.fldCity = city;
        this.fldConferenceOrganizer = conferenceOrganizer;
        this.fldPapers = new ArrayList<>();
        this.fldParticipations = new ArrayList<>();
        this.fldReviews = new ArrayList<>();
    }

    /**
     * Instancia una conferencia vacia
     */
    public Conference() {

    }

    public int getId() {
        return fldId;
    }

    public void setId(int fldId) {
        this.fldId = fldId;
    }

    public Date getDate() {
        return fldDate;
    }

    public void setDate(Date fldDate) {
        this.fldDate = fldDate;
    }

    public String getCity() {
        return fldCity;
    }

    public void setCity(String city) {
        this.fldCity = city;
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

    public List<ConferenceParticipation> getParticipations() {
        return fldParticipations;
    }

    public void setParticipations(List<ConferenceParticipation> fldParticipations) {
        this.fldParticipations = fldParticipations;
    }

    public List<PaperReview> getReviews() {
        return fldReviews;
    }

    public void setReviews(List<PaperReview> fldReviews) {
        this.fldReviews = fldReviews;
    }

}
