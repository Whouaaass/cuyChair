/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import domain.user;

/**
 *
 * @author julia
 */
public class utilities {
    //Imprime el resultado de un booleano
    public void printResult(boolean prmBoolean){
        if(prmBoolean){
            System.out.println("True");
            return;
        }
        System.out.println("False");
        return;
    }
    //Imprime un usuario
    public void printUser(user objUser){
        System.out.println("\n-----Usuario-----\n"
                +"\nID: "+objUser.getUserId()
                +"\nNombre: "+objUser.getUserName()
                +"\nApellido: "+objUser.getUserLastName()
                +"\nEmail: "+objUser.getUserEmail()
                +"\nContraseña: "+objUser.getUserPassword()
        );
    }
}
