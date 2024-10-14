package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI {

    public static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Hospital Registration System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);  // Adjusted for more buttons
        frame.setLayout(null);

        // Set background color
        frame.getContentPane().setBackground(new Color(224, 255, 255));

        // Font settings
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // Register Patient Button
        JButton registerButton = new JButton("Register Patient");
        registerButton.setBounds(100, 30, 200, 40);
        registerButton.setFont(buttonFont);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(70, 130, 180));
        frame.add(registerButton);
        
        // Update Patient Button
        JButton updateButton = new JButton("Update Patient");
        updateButton.setBounds(100, 90, 200, 40);
        updateButton.setFont(buttonFont);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBackground(new Color(60, 179, 113));
        frame.add(updateButton);
        
        // Delete Patient Button
        JButton deleteButton = new JButton("Delete Patient");
        deleteButton.setBounds(100, 150, 200, 40);
        deleteButton.setFont(buttonFont);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(220, 20, 60));
        frame.add(deleteButton);

        // Display Appointment Button
        JButton displayButton = new JButton("Display Appointment");
        displayButton.setBounds(100, 210, 200, 40);
        displayButton.setFont(buttonFont);
        displayButton.setForeground(Color.WHITE);
        displayButton.setBackground(new Color(70, 130, 180));
        frame.add(displayButton);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 270, 200, 40);
        exitButton.setFont(buttonFont);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(new Color(220, 20, 60));
        frame.add(exitButton);

        // Add action listener for Register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientRegistrationGUI.showPatientRegistrationGUI(frame);  // Pass main frame
            }
        });

        // Add action listener for Update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePatientGUI.showUpdatePatientGUI(frame);  // Pass main frame
            }
        });

        // Add action listener for Delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeletePatientGUI.showDeletePatientGUI(frame);  // Pass main frame
            }
        });

        // Add action listener for Display Appointment button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayAppointmentGUI.showAppointmentGUI(frame);  // Pass main frame
            }
        });

        // Add action listener for Exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Run GUI in the event-dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
