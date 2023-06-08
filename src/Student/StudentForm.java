/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentForm extends JFrame {

    private JTextField fullNameField;
    private JTextField studentIdField;
    private JTextField assignmentGradeField;
    private JTextField labGradeField;
    private JTextField ptGradeField;
    private JTextField peGradeField;
    private JTextField feGradeField;

    public StudentForm() {
        // Create labels and text fields
        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameField = new JTextField(30);

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdField = new JTextField(8);

        JLabel assignmentGradeLabel = new JLabel("Assignment Grade:");
        assignmentGradeField = new JTextField(5);

        JLabel labGradeLabel = new JLabel("Lab Grade:");
        labGradeField = new JTextField(5);

        JLabel ptGradeLabel = new JLabel("PT Grade:");
        ptGradeField = new JTextField(5);

        JLabel peGradeLabel = new JLabel("PE Grade:");
        peGradeField = new JTextField(5);

        JLabel feGradeLabel = new JLabel("FE Grade:");
        feGradeField = new JTextField(5);

        // Create a button to submit the form
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the entered data
                String fullName = fullNameField.getText();
                String studentId = studentIdField.getText();
                double assignmentGrade = Double.parseDouble(assignmentGradeField.getText());
                double labGrade = Double.parseDouble(labGradeField.getText());
                double ptGrade = Double.parseDouble(ptGradeField.getText());
                double peGrade = Double.parseDouble(peGradeField.getText());
                double feGrade = Double.parseDouble(feGradeField.getText());

                // Create a new Student object
                SinhVien student = new SinhVien(fullName, studentId, assignmentGrade, labGrade, ptGrade, peGrade, feGrade);

                // Do something with the student object (e.g., store it, display it)
                // ...
            }
        });

        // Create the form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 2));
        formPanel.add(fullNameLabel);
        formPanel.add(fullNameField);
        formPanel.add(studentIdLabel);
        formPanel.add(studentIdField);
        formPanel.add(assignmentGradeLabel);
        formPanel.add(assignmentGradeField);
        formPanel.add(labGradeLabel);
        formPanel.add(labGradeField);
        formPanel.add(ptGradeLabel);
        formPanel.add(ptGradeField);
        formPanel.add(peGradeLabel);
        formPanel.add(peGradeField);
        formPanel.add(feGradeLabel);
        formPanel.add(feGradeField);
        formPanel.add(submitButton);

        // Add the form panel to the frame
        add(formPanel);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Form");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new StudentForm();
//        });
//    }
}
