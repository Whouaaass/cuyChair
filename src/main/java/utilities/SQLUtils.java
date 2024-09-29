package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLUtils {
    public static void executeSQLFile(Connection connection, String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                // Ignore comments and empty lines
                if (!line.trim().isEmpty() && !line.trim().startsWith("--")) {
                    sql.append(line);
                    // Execute each SQL statement separately if file has multiple queries separated by semicolon
                    if (line.trim().endsWith(";")) {
                        try (Statement stmt = connection.createStatement()) {
                            stmt.execute(sql.toString());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        sql.setLength(0); // Clear the StringBuilder for the next statement
                    }
                }
            }
        }
    }
}
