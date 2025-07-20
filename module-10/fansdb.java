import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class fansdb {
    // Database connection
    static final String DB_URL = "jdbc:mysql://localhost/databasedb";
    static final String USER = "root";
    static final String PASS = "Buckbuck91!";

    public static void main(String[] args) {
        System.out.println("Starting fansdb...");

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("[!] MySQL JDBC Driver was not found.");
            e.printStackTrace();
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected to databasedb as root");

            // Drop the table if table already exists
            String dropTable = "DROP TABLE IF EXISTS Employees";
            stmt.executeUpdate(dropTable);
            System.out.println("Dropped table 'Employees' if it existed.");

            // Create table
            String createTable = "CREATE TABLE Employees (" +
                                 "id INT NOT NULL AUTO_INCREMENT," +
                                 "name VARCHAR(255)," +
                                 "age INT," +
                                 "PRIMARY KEY (id))";
            stmt.executeUpdate(createTable);
            System.out.println("Created table 'Employees'.");

            // Insert sample data
            String insertData = "INSERT INTO Employees (name, age) VALUES " +
                                "('John Doe', 30)," +
                                "('Jane Smith', 25)," +
                                "('Alice Johnson', 28)," +
                                "('Bob Williams', 35)";
            stmt.executeUpdate(insertData);
            System.out.println("Inserted sample data into 'Employees' table.");

            // Query and display data
            String query = "SELECT id, name, age FROM Employees";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nEmployees Table:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age"));
            }

        } catch (SQLException e) {
            System.out.println("[!] Database error occurred!");
            e.printStackTrace();
        }
    }
}
