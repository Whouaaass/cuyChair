package test;
import dataAccess.user.repositoryArrayListUser;
import drivers.userStoreService;
import org.passay.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;


import utilities.*;
import views.viewSignIn;
/**
 *
 * @author julia
 */
public class testSignIn {
    public static void main(String[] args){
        int varOpt=0;
        utilities objUtil = new utilities();
        repositoryArrayListUser objRepositoryArrayListUser = new repositoryArrayListUser();
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
                    objRepositoryArrayListUser=testGeneralSignIn(objRepositoryArrayListUser);
                    break;
                case 3:
                    objUtil.printUser(objRepositoryArrayListUser.listUser().getLast());
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
            passwordManager objPasswordManager = new passwordManager(varPassword);
            objPassword.setPassword(varPassword);
            //Se la pasamos al controlador de contraseña
            objPasswordManager.setPassword(objPassword);
            //Imprimimos la contraseña
            System.out.println("Tu contraseña es: "+objPasswordManager.getFldPassword());
             
        }catch(Exception e){
            System.out.println("Algo salió mal con la lectura de la contraseña");
            return false;
        }
        return true;
    }
    
    //Test para checkeo general de guardado de usuario
    private static repositoryArrayListUser testGeneralSignIn(repositoryArrayListUser objRepositoryArrayListUser){
        utilities objUtil = new utilities();
        try{
            //Inicializar servicio de almacenamiento de usuario
            userStoreService objUserStoreService = new userStoreService(objRepositoryArrayListUser);
            //Asociar el servicio de almacenamiento de usuario
            viewSignIn objViewSignIn = new viewSignIn(objUserStoreService);
            objViewSignIn.associateUserStoreService(objUserStoreService);
            //Lanzar interfaz
            objViewSignIn.setVisible(true);
        }catch(Exception e){
            System.out.println("Algo salió mal con el registro");
            return objRepositoryArrayListUser;
        }
        return objRepositoryArrayListUser;
    }
    
}
