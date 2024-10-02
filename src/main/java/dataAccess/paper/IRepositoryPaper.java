/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.paper;

import domain.Conference;
import domain.Paper;
import domain.PaperReview;
import domain.InfoJob;

import java.util.List;

/**
 *
 * @author julia
 * Modify by Juan
 */
public interface IRepositoryPaper {
    
    /**
     * Guarda un paper en el repositorio
     * @param objPaper
     * @return 
     */
    public boolean storePaper(Paper objPaper);
    
    /**
     * retorna la lista de todos los papers del repositorio
     * @return 
     */
    public List<Paper> listPaper();
    
    /**
     * retorna el paper con el id correspondiente
     * @param paperId
     * @return 
     */
    public Paper getPaperById(int paperId);

    /**
     * Obtiene los papers de una conferencia
     * @param conference
     * @return
     */
    public List<Paper> listPapersFrom(Conference conference);


    /**
     * Obtiene el paper de una revision
     * @param paperReview revision
     * @return paper
     */
    public Paper getPaperOfReview(PaperReview paperReview);

    public InfoJob getInfoJobs();
}
