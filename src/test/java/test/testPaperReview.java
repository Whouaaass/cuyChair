/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dataAccess.paperReview.RepositoryArrayListPaperReview;
import dataAccess.paperReview.RepositorySQLitePaperReview;
import domain.Paper;
import domain.PaperReview;
import domain.User;
import drivers.PaperReviewStoreService;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author julia
 */
public class testPaperReview {
    @Test
    public void testSQLiteRepository(){
        //Repositorio
        RepositorySQLitePaperReview objRepositorySQLitePaperReview = new RepositorySQLitePaperReview();
        PaperReviewStoreService objPaperReviewStoreService = new PaperReviewStoreService(objRepositorySQLitePaperReview);
        //Admin
        User objUserReviewer = new User();
        //Paper
        Paper objPaper = new Paper();
        //Conferencia a comparar
        PaperReview objPaperReview = new PaperReview(1,objPaper,objUserReviewer,true);
        objPaperReviewStoreService.storePaperReview(objPaperReview);
        assertEquals(objPaperReview.getReviewId(),objPaperReviewStoreService.listPapers().getFirst().getReviewId());
    }
    @Test
    public void testArrayRepository(){
        //Repositorio
        RepositoryArrayListPaperReview objRepositoryArrayListPaperReview = new RepositoryArrayListPaperReview();
        PaperReviewStoreService objPaperReviewStoreService = new PaperReviewStoreService(objRepositoryArrayListPaperReview);
        //Admin
        User objUserReviewer = new User();
        //Paper
        Paper objPaper = new Paper();
        //Conferencia a comparar
        PaperReview objPaperReview = new PaperReview(1,objPaper, objUserReviewer,true);
        objPaperReviewStoreService.storePaperReview(objPaperReview);
        assertEquals(objPaperReview.getReviewId(),objPaperReviewStoreService.listPapers().getFirst().getReviewId());
    }
}
