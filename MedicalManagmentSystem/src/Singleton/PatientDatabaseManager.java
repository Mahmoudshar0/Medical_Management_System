package Singleton;
import DB.DatabaseConnection;
import java.sql.*;

public class PatientDatabaseManager {
    
    private static PatientDatabaseManager instance;

    private PatientDatabaseManager() {}

    public static synchronized PatientDatabaseManager getInstance() {
        if (instance == null) {
            instance = new PatientDatabaseManager();
        }
        return instance;
    }

    // Add a patient
    public void addPatient(int patientId, String patientInfo) {
        String query = "INSERT INTO Patients (PatientID, PatientInfo) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            statement.setString(2, patientInfo);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Patient added/updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get patient details
    public String getPatient(int patientId) {
        String query = "SELECT * FROM Patients WHERE PatientID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return "Patient Info: " + rs.getString("PatientInfo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Patient not found.";
    }

    // Delete a patient
    public void deletePatient(int patientId) {
        String query = "DELETE FROM Patients WHERE PatientID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Patient deleted successfully.");
            } else {
                System.out.println("Patient not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
