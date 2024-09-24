/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import domain.User;
import javax.swing.JFrame;
import views.AlertSimple;

/**
 *
 * @author julia
 */
public class Utilities {
    //Imprime el resultado de un booleano
    public static void printResult(boolean prmBoolean){
        if(prmBoolean){
            System.out.println("True");
            return;
        }
        System.out.println("False");        
    }
    //Imprime un usuario
    public static void printUser(User objUser){
        System.out.println("\n-----Usuario-----\n"
                +"\nID: "+objUser.getUserId()
                +"\nNombre: "+objUser.getUserName()
                +"\nApellido: "+objUser.getUserLastName()
                +"\nEmail: "+objUser.getUserEmail()
                +"\nContraseña: "+objUser.getUserPassword()
        );
    }
    
    public static void setAlert(String title, String description) {
        AlertSimple objAlert = new AlertSimple(title, description);
        objAlert.pack();
        objAlert.setVisible(true);
        objAlert.setLocationRelativeTo(null);
        
        objAlert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
    }
}
