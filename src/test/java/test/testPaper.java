/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import dataAccess.paper.RepositoryArrayListPaper;
import dataAccess.paper.RepositorySQLitePaper;
import domain.Paper;
import domain.User;
import drivers.PaperStoreService;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author julia
 */
public class testPaper {
    @Test
    public void testSQLiteRepository(){
        //Repositorio
        RepositorySQLitePaper objRepositorySQLitePaper = new RepositorySQLitePaper();
        PaperStoreService objPaperStoreService = new PaperStoreService(objRepositorySQLitePaper);
        //Admin
        User objUserAuthor = new User();
        //Conferencia a comparar
        Paper objPaper = new Paper("Matematica1","Mucha matematica",objUserAuthor);
        objPaperStoreService.storePaper(objPaper);
        assertEquals(objPaper.getTitle(),objPaperStoreService.listPapers().getFirst().getTitle());
    }
    @Test
    public void testArrayRepository(){
        //Repositorio
        RepositoryArrayListPaper objRepositoryArrayListPaper = new RepositoryArrayListPaper();
        PaperStoreService objPaperStoreService = new PaperStoreService(objRepositoryArrayListPaper);
        //Admin
        User objUserAuthor = new User();
        //Conferencia a comparar
        Paper objPaper = new Paper("Matematica1","Mucha matematica",objUserAuthor);
        objPaperStoreService.storePaper(objPaper);
        assertEquals(objPaper.getTitle(),objPaperStoreService.listPapers().getFirst().getTitle());
    }
}
