/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess.paperReview;

import domain.PaperReview;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class RepositoryArrayListPaperReview implements IRepositoryPaperReview{
    private ArrayList<PaperReview> PaperReviewList;

    public RepositoryArrayListPaperReview() {
        this.PaperReviewList = new ArrayList();
    }
    
    @Override
    public boolean storePaperReview(PaperReview objPaperReview) {
        boolean varFlag=this.PaperReviewList.add(objPaperReview);
        return varFlag;
    }

    @Override
    public List<PaperReview> listPaperReview() {
        return this.PaperReviewList;
    }
}
