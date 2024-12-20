/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Builder.*;
import DB.*;
import Factory_DoctorSpcialization.*;
import ProtoType.*;
import Singleton.*;

/**
 *
 * @author M_shar
 */
public class MedicalClinicGUI extends JFrame{
    
    private JComboBox<String> specializationComboBox;
    private JTextField appointmentDateField;
    private JButton scheduleButton;
    private JTextArea outputArea;

    public MedicalClinicGUI() {
        // Set up the JFrame
        setTitle("Medical Clinic Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel specializationLabel = new JLabel("Doctor Specialization:");
        specializationComboBox = new JComboBox<>(new String[]{"Cardiologist", "Neurologist", "General Practitioner"});
        JLabel dateLabel = new JLabel("Appointment Date (YYYY-MM-DD):");
        appointmentDateField = new JTextField();
        scheduleButton = new JButton("Schedule Appointment");
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Add components to input panel
        inputPanel.add(specializationLabel);
        inputPanel.add(specializationComboBox);
        inputPanel.add(dateLabel);
        inputPanel.add(appointmentDateField);
        inputPanel.add(scheduleButton);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Add button action listener
        scheduleButton.addActionListener(new ScheduleButtonListener());

        // Make the frame visible
        setVisible(true);
    }

    // Inner class for handling button click
    private class ScheduleButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String specialization = (String) specializationComboBox.getSelectedItem();
            String date = appointmentDateField.getText();

            if (specialization == null || date.isEmpty()) {
                outputArea.setText("Error: Please select a specialization and enter a date.");
                return;
            }

            // Simulate backend logic using factory pattern
            try {
                Doctor doctor = DoctorFactory.createDoctor(specialization, "Dr. Smith");
                outputArea.setText("Appointment scheduled with " + doctor.getName() +
                        " (" + specialization + ") on " + date + ".\n");
                doctor.treatPatient();
            } catch (IllegalArgumentException ex) {
                outputArea.setText("Error: " + ex.getMessage());
            }
        }
    }
}
