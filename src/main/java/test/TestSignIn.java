package test;
import dataAccess.conference.RepositorySQLiteConference;
import dataAccess.paper.RepositorySQLitePaper;
import dataAccess.paperReview.RepositorySQLitePaperReview;
import dataAccess.user.RepositorySQLiteUser;
import drivers.ConferenceStoreService;
import drivers.PaperReviewStoreService;
import drivers.PaperStoreService;
import drivers.UserStoreService;
import org.passay.*;

//MyCommitEnMyRama
//Comiteando ando
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;


import utilities.*;
import views.ViewSignIn;
/**
 *
 * @author julia
 */
public class TestSignIn {
    public static void main(String[] args){
        int varOpt=0;
        Utilities objUtil = new Utilities();
        RepositorySQLiteUser objRepositoryArrayListUser = new RepositorySQLiteUser();
        RepositorySQLiteConference objRepositoryArrayListConference = new RepositorySQLiteConference();
        RepositorySQLitePaperReview objRepositoryArrayListPaperReview = new RepositorySQLitePaperReview();
        RepositorySQLitePaper objRepositoryArrayListPaper = new RepositorySQLitePaper();
        Scanner objScan = new Scanner(System.in);
        //Menu de pruebas
        do{
            System.out.println("\n-------MENU TEST-------\n1. Lectura de contraseña\n2. Registro general \n3. Imprimir el ultimo registro"); 
            varOpt=objScan.nextInt();
            switch(varOpt){
                case 1:
                    objUtil.printResult(testPasswordReading());
                    break;
                case 2:
                    objRepositoryArrayListUser=testGeneralSignIn(objRepositoryArrayListUser,objRepositoryArrayListConference,objRepositoryArrayListPaperReview,objRepositoryArrayListPaper);
                    break;
                case 3:
                    objUtil.printUser(objRepositoryArrayListUser.listUsers().getLast());
                    break;
                case 0:
                    System.out.println("Cerrando testing");
                    break;
                default:
                    System.out.println("\nOpción no contemplada");
                    break;
            }
        }while(varOpt!=0);
        

    }
    

    //Test para lectura de contraseña con las reglas de contraseña
    private static boolean testPasswordReading(){
        Scanner objScan = new Scanner(System.in);
        PasswordData objPassword = new PasswordData();
        try{
            String varPassword;
            //Leemos la contraseña
            System.out.println("Contraseña:");
            varPassword=objScan.nextLine();
            //La asignamos a un objeto contraseña
            PasswordManager objPasswordManager = new PasswordManager(varPassword);
            objPassword.setPassword(varPassword);
            //Se la pasamos al controlador de contraseña
            objPasswordManager.validPassword(objPassword);
            //Imprimimos la contraseña
            System.out.println("Tu contraseña es: "+objPasswordManager.getFldPassword());
             
        }catch(Exception e){
            System.out.println("Algo salió mal con la lectura de la contraseña");
            return false;
        }
        return true;
    }
    
    //Test para checkeo general de guardado de usuario
    private static RepositorySQLiteUser testGeneralSignIn(RepositorySQLiteUser objRepositoryArrayListUser,RepositorySQLiteConference objRepositoryConference,
            RepositorySQLitePaperReview objRepositoryPaperReview, RepositorySQLitePaper objRepositoryPaper){
        Utilities objUtil = new Utilities();
        try{
            //Inicializar servicio de almacenamiento de usuario
            UserStoreService objUserStoreService = new UserStoreService(objRepositoryArrayListUser);
            //Iniclializar servicios de almacenamiento de conferencia, paper y paperReview de la plataforma
            ConferenceStoreService objConferenceStoreService = new ConferenceStoreService(objRepositoryConference);
            PaperReviewStoreService objPaperReviewStoreService = new PaperReviewStoreService(objRepositoryPaperReview);
            PaperStoreService objPaperStoreService = new PaperStoreService(objRepositoryPaper);
            //Asociar el servicio de almacenamiento de usuario
            ViewSignIn objViewSignIn = new ViewSignIn(objUserStoreService,objConferenceStoreService,objPaperReviewStoreService,objPaperStoreService);
            objViewSignIn.associateUserStoreService(objUserStoreService,objConferenceStoreService,objPaperReviewStoreService,objPaperStoreService);
            //Lanzar interfaz
            objViewSignIn.setVisible(true);
        }catch(Exception e){
            System.out.println("Algo salió mal con el registro");
            return objRepositoryArrayListUser;
        }
        return objRepositoryArrayListUser;
    }
    
}
