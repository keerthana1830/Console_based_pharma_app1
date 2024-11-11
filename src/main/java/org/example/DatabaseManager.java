package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PharmacyDB", "root", "root");
            System.out.println("Connection established...");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void addPrescription(Prescription prescription) throws SQLException {
        String query = "INSERT INTO Prescription (patient_id, medication_id, quantity, date_prescribed) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, prescription.getPatientId());
        statement.setInt(2, prescription.getMedicationId());
        statement.setInt(3, prescription.getQuantity());
        statement.setDate(4, new java.sql.Date(prescription.getDatePrescribed().getTime()));
        statement.executeUpdate();
    }

    public List<Prescription> getPrescriptionsByPatientId(int patientId) throws SQLException {
        String query = "SELECT * FROM Prescription WHERE patient_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, patientId);
        ResultSet resultSet = statement.executeQuery();

        List<Prescription> prescriptions = new ArrayList<>();
        while (resultSet.next()) {
            Prescription prescription = new Prescription(
                    resultSet.getInt("prescription_id"),
                    resultSet.getInt("patient_id"),
                    resultSet.getInt("medication_id"),
                    resultSet.getInt("quantity"),
                    resultSet.getDate("date_prescribed")
            );
            prescriptions.add(prescription);
        }
        return prescriptions;
    }

    public void updateInventory(int medicationId, int quantity) throws SQLException {
        String query = "UPDATE Inventory SET quantity = ? WHERE medication_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, quantity);
        statement.setInt(2, medicationId);
        statement.executeUpdate();
    }

    public Connection getConnection() {
        return connection; // Fixed this to return the actual connection object
    }
}
