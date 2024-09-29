/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.paperReview;

import domain.PaperReview;
import domain.Paper;
import java.util.List;

/**
 * Interfaz que define los accesos al repositorio de revisiones de papers
 * @author julia
 * @author Frdy
 */
public interface IRepositoryPaperReview {
    
    /**
     * guarda una revision de un paper (PaperReview)
     * @param objPaper revision a guardar
     * @return si se guardo la revision correctamente
     */
    public boolean storePaperReview(PaperReview objPaper);
    
    /**
     * lista todas las revisiones (PaperReviews)
     * @return listado de revisiones
     */
    public List<PaperReview> listPaperReview();

    /**
     * obtiene el paperRevisado
     * @return paper
     */
    public Paper getPaperReviewed(int paperReviewId);
}
