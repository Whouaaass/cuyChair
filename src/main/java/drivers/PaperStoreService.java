/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drivers;

import dataAccess.paper.IRepositoryPaper;
import domain.Paper;
import domain.User;
import infra.Subject;

import java.util.List;

/**
 * Servicio de gestion de almacenamiento de papers
 * @author julia
 * @author Frdy
 */
public class PaperStoreService extends Subject {
    private IRepositoryPaper objRepositoryPaperRef;

     /**
     * Instancia un objeto de la clase PaperStoreService
     * @param objRepositoryPaperRef Repositorio que utilizara el servicio
     */
    public PaperStoreService(IRepositoryPaper objRepositoryPaperRef) {
        this.objRepositoryPaperRef = objRepositoryPaperRef;
        this.notifyAllObservers();
    }
    
     /**
     * Guarda un paper
     * @param objPaper Paper a guardar
     * @return si el guardado fue correcto
     */
    public boolean storePaper(Paper objPaper) {
        boolean varFlag=this.objRepositoryPaperRef.storePaper(objPaper);
        return varFlag;
    }
   
    /**
     * Lista los papers
     * @return lista de papers
     */
    public List<Paper> listPapers() {
        return this.objRepositoryPaperRef.listPaper();
    }

    /**
     * Lista los papers hechos por un autor
     * @param author
     * @return lista de papers
     */
    public List<Paper> listPapersOf(User author) {
        return this.objRepositoryPaperRef.listPapersOf(author);
    }
}
