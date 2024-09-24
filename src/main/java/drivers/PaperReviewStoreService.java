/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drivers;

import dataAccess.paperReview.IRepositoryPaperReview;
import domain.PaperReview;
import java.util.List;

/**
 * Servicio de gestion de almacenamiento de paperReviews
 * @author julia
 * @author Frdy
 */
public class PaperReviewStoreService {
    private IRepositoryPaperReview objRepositoryPaperReviewRef;

     /**
     * Instancia un objeto de la clase PaperReviewStoreService
     * @param objRepositoryPaperReview Repositorio que utilizara el servicio
     */
    public PaperReviewStoreService(IRepositoryPaperReview objRepositoryPaperReview) {
        this.objRepositoryPaperReviewRef = objRepositoryPaperReview;
    }
    
    /**
     * Guarda un paperReview
     * @param objPaperReview PaperReview a guardar
     * @return si el guardado fue correcto
     */
    public boolean storePaperReview(PaperReview objPaperReview) {
        boolean varFlag=this.objRepositoryPaperReviewRef.storePaperReview(objPaperReview);
        return varFlag;
    }
   
    /**
     * Lista los paperReviews
     * @return lista de paperReviews
     */
    public List<PaperReview> listPapers() {
        return this.objRepositoryPaperReviewRef.listPaperReview();
    }
    
}
