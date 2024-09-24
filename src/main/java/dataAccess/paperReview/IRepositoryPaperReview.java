/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dataAccess.paperReview;

import domain.PaperReview;
import java.util.List;

/**
 *
 * @author julia
 */
public interface IRepositoryPaperReview {
    public boolean storePaperReview(PaperReview objPaper);
    public List<PaperReview> listPaperReview();
}
