package utilities.language;

/**
 * Interfaz que define lo que necesita un controlador (vista) que necesite implementar un cambio de idioma
 * @author Frdy
 */
public interface ILanguageController {
    /**
     * Este metodo implementa una actualizacion de todos los textos de controlador, interfaz o componente
     */
    public void loadLanguage();    
}
