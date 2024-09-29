/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.sql;

import java.util.List;

import dataAccess.conference.IRepositoryConference;
import domain.Conference;
import domain.Paper;
import domain.PaperReview;
import domain.User;

/**
 * Es una conferencia que sobrecarga los métodos de get que implican una relacion
 * para implementar lazy loading
 * @implNote Esta clase se debe implementar únicamente con repositorios SQL
 * @author Frdy
 */
public class SQLConference extends Conference {
    private IRepositoryConference conferenceRepo;
    
    public SQLConference(IRepositoryConference conferenceRepo) {
        this.conferenceRepo = conferenceRepo;
    }

    @Override
    public List<User> getReviewers() {
        if (super.getReviewers() == null) {
            super.fldReviewers = conferenceRepo.listReviewers(this.getId());
        }
        return super.fldReviewers;
    }    

    @Override
    public List<User> getAuthors() {
        if (super.getAuthors() == null) {
            super.fldAuthors = conferenceRepo.listAuthors(this.getId());
        }
        return super.fldAuthors;
    }

    @Override
    public List<Paper> getPapers() {
        if (super.getPapers() == null) {
            super.fldPapers = conferenceRepo.listPapers(this.getId());
        }
        return super.fldPapers;
    }

    @Override
    public List<PaperReview> getReviews() {
        if (super.getReviews() == null) {
            super.fldReviews = conferenceRepo.listReviews(this.getId());
        }
        return super.fldReviews;
    }

    @Override
    public User getConferenceOrganizer() {
        if (super.getConferenceOrganizer() == null) {
            super.fldConferenceOrganizer = conferenceRepo.getConferenceOrganizer(this.getId());
        }
        return super.fldConferenceOrganizer;
    }
}
