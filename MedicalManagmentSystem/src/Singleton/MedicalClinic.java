package Singleton;
import DB.DatabaseConnection;
import java.sql.*;

public class MedicalClinic {
    
    private static MedicalClinic instance;

    private MedicalClinic() {}

    public static synchronized MedicalClinic getInstance() {
        if (instance == null) {
            instance = new MedicalClinic();
        }
        return instance;
    }

    // Check if the doctor's slot is available
    public boolean checkSlot(int doctorId, String appointmentDate) {
        String query = "SELECT COUNT(*) FROM Appointments WHERE DoctorID = ? AND AppointmentDate = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, doctorId);
            statement.setString(2, appointmentDate);
            ResultSet rs = statement.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return false;  // Slot is taken
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;  // Slot is available
    }

    // Book an appointment
    public void bookSlot(int doctorId, String appointmentDate, int patientId) {
        if (checkSlot(doctorId, appointmentDate)) {
            String query = "INSERT INTO Appointments (DoctorID, AppointmentDate, PatientID, Status) VALUES (?, ?, ?, 'Scheduled')";
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, doctorId);
                statement.setString(2, appointmentDate);
                statement.setInt(3, patientId);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Appointment booked successfully.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Slot is unavailable for Doctor " + doctorId + " on " + appointmentDate + ".");
        }
    }

    // Cancel an appointment
    public void cancelAppointment(int doctorId, String appointmentDate) {
        String query = "DELETE FROM Appointments WHERE DoctorID = ? AND AppointmentDate = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, doctorId);
            statement.setString(2, appointmentDate);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Appointment for Doctor " + doctorId + " on " + appointmentDate + " has been canceled.");
            } else {
                System.out.println("No appointment found to cancel.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MedicalClinic scheduler = MedicalClinic.getInstance();

        // Book an appointment
        scheduler.bookSlot(101, "2024-12-15 10:00", 1);

        // Check if the slot is available (should be unavailable after booking)
        System.out.println(scheduler.checkSlot(101, "2024-12-15 10:00"));  // Should return False

        // Cancel the appointment
        scheduler.cancelAppointment(101, "2024-12-15 10:00");
    }
    
}
