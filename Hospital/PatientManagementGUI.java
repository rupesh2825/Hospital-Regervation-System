package Hospital;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PatientManagementGUI {

    public static void showPatientManagementGUI(JFrame mainMenuFrame) {
        JFrame frame = new JFrame("Patient Management");
        frame.setSize(500, 500);
        frame.setLayout(null);

        frame.getContentPane().setBackground(new Color(245, 245, 245));
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        JLabel idLabel = new JLabel("Patient ID:");
        idLabel.setBounds(50, 50, 100, 30);
        idLabel.setFont(labelFont);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(150, 50, 200, 30);
        idField.setFont(textFieldFont);
        frame.add(idField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(370, 50, 100, 30);
        searchButton.setFont(buttonFont);
        frame.add(searchButton);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        nameLabel.setFont(labelFont);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 30);
        frame.add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 150, 100, 30);
        frame.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(150, 150, 200, 30);
        frame.add(addressField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(50, 200, 100, 30);
        frame.add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(150, 200, 200, 30);
        frame.add(contactField);

        JLabel historyLabel = new JLabel("Medical History:");
        historyLabel.setBounds(50, 250, 120, 30);
        frame.add(historyLabel);

        JTextField historyField = new JTextField();
        historyField.setBounds(150, 250, 200, 30);
        frame.add(historyField);

        // Buttons: Update, Delete, and Back
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(50, 320, 100, 40);
        updateButton.setBackground(new Color(60, 179, 113));
        updateButton.setForeground(Color.WHITE);
        frame.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(180, 320, 100, 40);
        deleteButton.setBackground(new Color(220, 20, 60));
        deleteButton.setForeground(Color.WHITE);
        frame.add(deleteButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(310, 320, 100, 40);
        backButton.setBackground(new Color(70, 130, 180));
        backButton.setForeground(Color.WHITE);
        frame.add(backButton);

        // Search button action: Fetch patient data
        searchButton.addActionListener(e -> {
            try {
                int patientId = Integer.parseInt(idField.getText());
                Patient patient = PatientDatabase.getPatientById(patientId);
                if (patient != null) {
                    nameField.setText(patient.getName());
                    addressField.setText(patient.getAddress());
                    contactField.setText(patient.getContact());
                    historyField.setText(patient.getMedicalHistory());
                } else {
                    JOptionPane.showMessageDialog(frame, "Patient not found!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid Patient ID.");
            } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });

        // Update button action
        updateButton.addActionListener(e -> {
            try {
                int patientId = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String address = addressField.getText();
                String contact = contactField.getText();
                String history = historyField.getText();

                PatientDatabase.updatePatient(patientId, name, address, contact, history);
                JOptionPane.showMessageDialog(frame, "Patient updated successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error updating patient details.");
            }
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            try {
                int patientId = Integer.parseInt(idField.getText());
                PatientDatabase.deletePatient(patientId);
                JOptionPane.showMessageDialog(frame, "Patient deleted successfully!");

                // Clear fields after deletion
                nameField.setText("");
                addressField.setText("");
                contactField.setText("");
                historyField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error deleting patient.");
            }
        });

        // Back button action
        backButton.addActionListener(e -> {
            frame.dispose();
            mainMenuFrame.setVisible(true);
        });

        frame.setVisible(true);
        mainMenuFrame.setVisible(false);
    }
}
