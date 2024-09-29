package utilities;

import dataAccess.ConnectionSqlitePool;
import org.junit.jupiter.api.Test;
import org.sqlite.javax.SQLiteConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SQLUtilsTest {
    @Test
    void dbCreationScript() throws SQLException {
        // se asegura de que se ejecute la connection a la base de datos y así se prueba este método
        Connection c = ConnectionSqlitePool.getConnection();

    }

}