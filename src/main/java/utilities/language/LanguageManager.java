package utilities.language;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Esta Clase es un singleton que permite el manejo de diferentes lenguajes
 * @author Frdy
 */
public class LanguageManager {
    private static LanguageManager instance; 
    private ResourceBundle resourceBundle;
    private Locale locale;

    /**
     * Genera una instancia del LanguageManager
     */
    private LanguageManager() {
        // Inicializa con el idioma por defecto, español Colombia
        setLocale(new Locale("es", "CO"));
    }

    /**
     * Método estático para obtener una instancia del singleton
     * @return Instancia de gestor de Idioma
     */
    public static LanguageManager getInstance() {
        if (instance == null) {
            instance = new LanguageManager();
        }
        return instance;
    }

    /**
     * Cambia el idioma
     * @param locale 
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle("messages.messages", locale);
    }

    /**
     * Obtiene la traducción
     * @param key
     * @return 
     */
    public String getText(String key) {
        return resourceBundle.getString(key);
    }

    /**
     * Obtiene el idioma (Locale) actual
     * es necesario instanciarla antes
     * @return instancia de Locale 
     */
    public Locale getLocale() {
        return locale;
    }
}