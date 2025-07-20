// Jacob Achenbach
// 7/20/2025

// App lets you view and update employee records in a MySQL database using a simple window with two buttons.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class fansdb extends JFrame {
    // Database connection details
    static final String DB_URL = "jdbc:mysql://localhost/databasedb";
    static final String USER = "root";
    static final String PASS = "Buckbuck91!";

    private JTextField idField, nameField, ageField;
    private JButton displayButton, updateButton;


    // Sets up the GUI
    public fansdb() {
        setTitle("Employee Database");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // ID row
        add(new JLabel("Employee ID:"));
        idField = new JTextField();
        add(idField);

        // Name row
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        // Age row
        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        displayButton = new JButton("Display");
        updateButton = new JButton("Update");

        add(displayButton);
        add(updateButton);

        // Display button action
        displayButton.addActionListener(e -> displayEmployee());

        // Update button action
        updateButton.addActionListener(e -> updateEmployee());
    }

    // Display an employee's details from DB
    private void displayEmployee() {
        String idText = idField.getText().trim();
        if (idText.isEmpty() || !idText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Employee ID.");
            return;
        }

        int empId = Integer.parseInt(idText);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT name, age FROM Employees WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, empId);

            ResultSet rs = stmt.executeQuery();
            // Add fields with data from DB
            if (rs.next()) {
                nameField.setText(rs.getString("name"));
                ageField.setText(String.valueOf(rs.getInt("age")));
                JOptionPane.showMessageDialog(this, "Employee data loaded.");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found.");
                nameField.setText("");
                ageField.setText("");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }
    // Update an employee's details in DB
    private void updateEmployee() {
        String idText = idField.getText().trim();
        String ageText = ageField.getText().trim();


        // Validate ID
        if (idText.isEmpty() || !idText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Employee ID.");
            return;
        }
        // Validate age
        if (ageText.isEmpty() || !ageText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Age.");
            return;
        }

        int empId = Integer.parseInt(idText);
        int age = Integer.parseInt(ageText);

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String updateQuery = "UPDATE Employees SET name = ?, age = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, nameField.getText().trim());
            stmt.setInt(2, age);
            stmt.setInt(3, empId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Employee updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    // Starts the application
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found.");
            return;
        }

        SwingUtilities.invokeLater(() -> {
            new fansdb().setVisible(true);
        });
    }
}
