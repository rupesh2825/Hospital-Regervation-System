package Hospital;

import java.sql.*;

public class PatientDatabase {

    // Get Patient by ID
    public static Patient getPatientById(int id) throws SQLException {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Patient(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("contact"),
                        resultSet.getString("medical_history")
                );
            } else {
                return null;  // Patient not found
            }
        } catch (SQLException e) {
            System.err.println("Error fetching patient: " + e.getMessage());
            throw e;  // Re-throw the exception to be handled by the caller
        }
    }

    // Update Patient Details
    public static void updatePatient(int id, String name, String address, String contact, String history) throws SQLException {
        String sql = "UPDATE patients SET name = ?, address = ?, contact = ?, medical_history = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, contact);
            statement.setString(4, history);
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Patient updated successfully.");
            } else {
                System.out.println("Patient not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating patient: " + e.getMessage());
            throw e;
        }
    }

    // Delete Patient by ID
    public static void deletePatient(int id) throws SQLException {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Patient deleted successfully.");
            } else {
                System.out.println("Patient not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting patient: " + e.getMessage());
            throw e;
        }
    }
}
