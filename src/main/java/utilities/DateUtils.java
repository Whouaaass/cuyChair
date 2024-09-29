package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que funciona como estática y se encarga de manejar la conversión de fechas
 * @Author Frdy
 */
public class DateUtils {
    public static SimpleDateFormat DateDBFormatter;
    static {
        DateDBFormatter = new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * Convierte una cadena que contiene una fecha de la base de datos
     * @param date cadena que contiene la fecha
     * @return Fecha
     */
    public static Date parseDBDate(String date) {
        try {
            return DateDBFormatter.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Convierte una Fecha a una cadena para guardarla en la base de datos
     * @param date Fecha (Date)
     * @return fecha (String)
     */
    public static String formatDBDate(Date date) {
        return DateDBFormatter.format(date);
    }
}
