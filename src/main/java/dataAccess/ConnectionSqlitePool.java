package dataAccess;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import utilities.SQLUtils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Esta clase es un singleton que se utiliza para reutilizar las connectiones 
 * @author Frdy
 */
public class ConnectionSqlitePool {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:MyBd.db");
        config.setDriverClassName("org.sqlite.JDBC");
        config.setMaximumPoolSize(10);
        config.setConnectionTestQuery("SELECT 1");
        config.setPoolName("SQLitePool");
        dataSource = new HikariDataSource(config);

        System.out.println("...Iniciando base de datos");
        initDatabase();
        System.out.println("* Base de datos Iniciada");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }

    /**
     * Inicialización de la base de datos de SQLite
     */
    private static void initDatabase() {
        String filePath = "src/main/resources/sqlScripts/SQLiteCreationScript.sql";
        try {
            SQLUtils.executeSQLFile(getConnection(), filePath);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de creacion de la base de datos");
            System.out.println("-> Se continuara sin el archivo");
            e.printStackTrace();
        }

    }
}

