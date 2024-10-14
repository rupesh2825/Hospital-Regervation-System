package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeletePatientGUI {

    public static void showDeletePatientGUI(JFrame mainMenuFrame) {
        JFrame frame = new JFrame("Delete Patient");
        frame.setSize(400, 200);
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

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(150, 100, 100, 40);
        deleteButton.setFont(buttonFont);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(220, 20, 60));
        frame.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                // Call your delete method here
                try {
                    PatientDatabase.deletePatient(id);
                    JOptionPane.showMessageDialog(frame, "Patient Deleted Successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error deleting patient: " + ex.getMessage());
                }

                frame.dispose();
                mainMenuFrame.setVisible(true);
            }
        });

        frame.setVisible(true);
        mainMenuFrame.setVisible(false);  // Hide the main menu while delete is open
    }
}
