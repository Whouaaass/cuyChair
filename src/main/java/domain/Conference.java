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
    //Usuarios en la conferencia
    private UserStoreService objUserStoreService;
    //Papers en la conferencia
    private PaperReviewStoreService objPaperReviewStoreService;
    //Constructor para pasarle los repositorios a la conferencia
    public Conference(String fldTitle, Date fldDate,String fldDescription, String fldCiudad, User fldConferenceAdmin, PaperReviewStoreService objPaperReviewStoreService,UserStoreService objUserStoreService) {
        this.fldTitle = fldTitle;
        this.fldDate = fldDate;
        this.fldDescription = fldDescription;
        this.fldCity = fldCiudad;
        this.fldConferenceAdmin = fldConferenceAdmin;
        this.objUserStoreService = objUserStoreService;
        this.objPaperReviewStoreService = objPaperReviewStoreService;
    }
    //Constructor para que los repositorios de la conferencia se creen automaticamente
    public Conference(String fldTitle, Date fldDate,String fldDescription, String fldCiudad, User fldConferenceAdmin) {
        this.fldTitle = fldTitle;
        this.fldDate = fldDate;
        this.fldDescription = fldDescription;
        this.fldCity = fldCiudad;
        this.fldConferenceAdmin = fldConferenceAdmin;
        
        RepositoryArrayListUser usersList= new RepositoryArrayListUser();
        RepositoryArrayListPaperReview paperReviewList = new RepositoryArrayListPaperReview();
        
        this.objPaperReviewStoreService = new PaperReviewStoreService(paperReviewList);
        this.objUserStoreService = new UserStoreService(usersList);
    }
    public Date getFldDate() {
        return fldDate;
    }

    public void setFldDate(Date fldDate) {
        this.fldDate = fldDate;
    }

    public UserStoreService getObjUserStoreService() {
        return objUserStoreService;
    }

    public void setObjUserStoreService(UserStoreService objUserStoreService) {
        this.objUserStoreService = objUserStoreService;
    }

    public PaperReviewStoreService getObjPaperReviewStoreService() {
        return objPaperReviewStoreService;
    }

    public void setObjPaperReviewStoreService(PaperReviewStoreService objPaperReviewStoreService) {
        this.objPaperReviewStoreService = objPaperReviewStoreService;
    }
    
    public String getFldCiudad() {
        return fldCity;
    }

    public void setFldCiudad(String fldCiudad) {
        this.fldCity = fldCiudad;
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


    
}
