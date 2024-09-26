package utilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author julia
 */
public class EmailManager {

    // Expresión regular para validar formato de email
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public static boolean isValidEmail(String email) {
        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        // Verificar si coincide con el formato de email
        return matcher.matches();
    }

}
