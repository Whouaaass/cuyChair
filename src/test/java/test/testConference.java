/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import dataAccess.conference.RepositoryArrayListConference;
import dataAccess.conference.RepositorySQLiteConference;
import domain.Conference;
import domain.User;
import drivers.ConferenceStoreService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author julia
 */
public class testConference {
    @Test
    public void testSQLiteRepository() throws ParseException{
        //fecha
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = formatter.parse("11/02/2020");
        //Repositorio
        RepositorySQLiteConference objRepositorySQLiteConference = new RepositorySQLiteConference();
        ConferenceStoreService objConferenceStoreService = new ConferenceStoreService(objRepositorySQLiteConference);
        //Admin
        User objUserAdmin = new User();
        //Conferencia a comparar
        Conference objConference = new Conference("MiConferencia",date,"Una conferencia","Cali",objUserAdmin);
        objConferenceStoreService.storeConference(objConference);
        assertEquals(objConference.getTitle(),objConferenceStoreService.listConference().getFirst().getTitle());
    }
    @Test
    public void testArrayRepository() throws ParseException{
        //fecha
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = formatter.parse("11/02/2020");
        //Repositorio
        RepositoryArrayListConference objRepositorySQLiteConference = new RepositoryArrayListConference();
        ConferenceStoreService objConferenceStoreService = new ConferenceStoreService(objRepositorySQLiteConference);
        //Admin
        User objUserAdmin = new User();
        //Conferencia a comparar
        Conference objConference = new Conference("MiConferencia",date,"Una conferencia","Cali",objUserAdmin);
        objConferenceStoreService.storeConference(objConference);
        assertEquals(objConference.getTitle(),objConferenceStoreService.listConference().getFirst().getTitle());
    }
}
