/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drivers;

import dataAccess.conference.IRepositoryConference;
import domain.Conference;
import domain.Paper;
import infra.Subject;

import java.util.List;

/**
 * Servicio de gestion de almacenamiento de conferencia
 * @author julia
 * @author Frdy
 */
public class ConferenceStoreService extends Subject {
        private IRepositoryConference objRepositoryConferenceRef;

     /**
     * Instancia un objeto de la clase ConferenceStoreService
     * @param objRepositoryConference Repositorio que utilizara el servicio
     */
    public ConferenceStoreService(IRepositoryConference objRepositoryConference) {
        this.objRepositoryConferenceRef = objRepositoryConference;
    }
    
    /**
     * Guarda un Conference
     * @param objConference Conferencia a guardar
     * @return si el guardado fue correcto
     */
    public boolean storeConference(Conference objConference) {
        boolean varFlag=this.objRepositoryConferenceRef.storeConference(objConference);
        return varFlag;
    }
   
    /**
     * Lista los Conference
     * @return lista de paperReviews
     */
    public List<Conference> listConference() {
        return this.objRepositoryConferenceRef.listConference();
    }

    public boolean addJob(int idConference, Paper newpaper){
        boolean flag= this.objRepositoryConferenceRef.addPaper(idConference,newpaper);
        this.notifyAllObservers();
        return flag;
    }
    
    public boolean addJob(String Conference,Paper newpaper){
        int idConference=-1;
        for(int i=0;i<objRepositoryConferenceRef.listConference().size();i++){
            if(0==Conference.compareTo(objRepositoryConferenceRef.listConference().get(i).getTitle())){
                idConference=objRepositoryConferenceRef.listConference().get(i).getFldId();
            }
        }
        boolean flag= this.objRepositoryConferenceRef.addPaper(idConference,newpaper);
        //this.notifyAllObservers();
        return flag;
    }
    
}
