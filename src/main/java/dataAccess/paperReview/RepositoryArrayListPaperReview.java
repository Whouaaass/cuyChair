/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paperReview;

import domain.Conference;
import domain.Paper;
import domain.PaperReview;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class RepositoryArrayListPaperReview implements IRepositoryPaperReview{
    private ArrayList<PaperReview> PaperReviewList;
     /**
     * Instancia un objeto de la clase PaperReviewStoreService
     */
    public RepositoryArrayListPaperReview() {
        this.PaperReviewList = new ArrayList();
    }
        /**
     * Guarda un paperReview
     * @param objPaperReview Usuario a guardar
     * @return si el guardado fue correcto
     */
    @Override
    public boolean storePaperReview(PaperReview objPaperReview) {
        boolean varFlag=this.PaperReviewList.add(objPaperReview);
        return varFlag;
    }
     /**
     * Lista los paperReviews
     * @return lista de paperReviews
     */
    @Override
    public List<PaperReview> listPaperReview() {
        return this.PaperReviewList;
    }

    @Override
    public PaperReview getPaperReviewFrom(Paper paper) {
        for (PaperReview objPaperReview : this.PaperReviewList) {
            if (objPaperReview.getPaper().equals(paper)) {
                return objPaperReview;
            }
        }
        return null;
    }

    @Override
    public List<PaperReview> getPaperReviewsRelatedTo(Conference conference) {
        List<PaperReview> varList = new ArrayList<>();
        for (PaperReview objPaperReview : this.PaperReviewList) {
            if (conference.getPapers().contains(objPaperReview.getPaper())) {
                varList.add(objPaperReview);
            }
        }
        return varList;
    }
}
