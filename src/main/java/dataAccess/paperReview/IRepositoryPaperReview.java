/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.paperReview;

import domain.Conference;
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
     * Guarda una revision de un paper (PaperReview)
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
     * Obtiene la revision de un paper
     * @return paper
     */
    public PaperReview getPaperReviewFrom(Paper paper);

    /**
     * Obtiene los papers de una conferencia
     * @param conference conferencia de la cual obtener los papers
     * @return Conferencia
     */
    public List<PaperReview> getPaperReviewsRelatedTo(Conference conference);
}
