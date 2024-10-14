package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdatePatientGUI {

    public static void showUpdatePatientGUI(JFrame mainMenuFrame) {
        JFrame frame = new JFrame("Update Patient");
        frame.setSize(400, 400);
        frame.setLayout(null);

        // Set background color
        frame.getContentPane().setBackground(new Color(255, 248, 220));

        // Font settings
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        JLabel idLabel = new JLabel("Patient ID:");
        idLabel.setBounds(50, 50, 150, 30);
        idLabel.setFont(labelFont);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(200, 50, 150, 30);
        idField.setFont(textFieldFont);
        frame.add(idField);

        JLabel nameLabel = new JLabel("Patient Name:");
        nameLabel.setBounds(50, 100, 150, 30);
        nameLabel.setFont(labelFont);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 100, 150, 30);
        nameField.setFont(textFieldFont);
        frame.add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 150, 150, 30);
        addressLabel.setFont(labelFont);
        frame.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(200, 150, 150, 30);
        addressField.setFont(textFieldFont);
        frame.add(addressField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(50, 200, 150, 30);
        contactLabel.setFont(labelFont);
        frame.add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(200, 200, 150, 30);
        contactField.setFont(textFieldFont);
        frame.add(contactField);

        JLabel historyLabel = new JLabel("Medical History:");
        historyLabel.setBounds(50, 250, 150, 30);
        historyLabel.setFont(labelFont);
        frame.add(historyLabel);

        JTextField historyField = new JTextField();
        historyField.setBounds(200, 250, 150, 30);
        historyField.setFont(textFieldFont);
        frame.add(historyField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(150, 300, 100, 40);
        updateButton.setFont(buttonFont);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBackground(new Color(34, 139, 34));
        frame.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String address = addressField.getText();
                String contact = contactField.getText();
                String medicalHistory = historyField.getText();

                // Call your update method here
                try {
                    PatientDatabase.updatePatient(id, name, address, contact, medicalHistory);
                    JOptionPane.showMessageDialog(frame, "Patient Updated Successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error updating patient: " + ex.getMessage());
                }

                frame.dispose();
                mainMenuFrame.setVisible(true);
            }
        });

        frame.setVisible(true);
        mainMenuFrame.setVisible(false);  // Hide the main menu while update is open
    }
}
