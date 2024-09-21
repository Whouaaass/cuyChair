/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;
/**
 *
 * @author julia
 */
import org.passay.*;
public class PasswordManager {
    //Contraseña 
    private String fldPassword;

    public PasswordManager(String fldPassword) {
        this.fldPassword = fldPassword;
    }
    
    public String getFldPassword() {
        return fldPassword;
    }

    public void setFldPassword(String fldPassword) {
        this.fldPassword = fldPassword;
    }
    //Objeto validador 
    PasswordValidator objValidator = new PasswordValidator(
    // Logintud establecida entre 8 y 16 caracteres 
    new LengthRule(8, 16),

    // La contraseña exige almenos un caracter en mayusculas
    new CharacterRule(EnglishCharacterData.UpperCase, 1),

    // La contraseña exige almenos un caracter en minusculas
    new CharacterRule(EnglishCharacterData.LowerCase, 1),

    // La contraseña exige almenos un digito numero
    new CharacterRule(EnglishCharacterData.Digit, 1),

    // no whitespace
    new WhitespaceRule());
    
   
    //Metodo para asignar una contraseña con las reglas establecidas
    public boolean validPassword(PasswordData prmPassword){
        RuleResult objResult = this.objValidator.validate(prmPassword);
        boolean varBell=false;
        varBell=objResult.isValid();
            if(varBell){
                this.fldPassword=objResult.toString();
                System.out.println("Contraseña valida");
                return varBell;
            }
        System.out.println("Contraseña no valida");
        return varBell;
    };
}
