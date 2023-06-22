package Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Set;
import java.awt.Color;
import java.awt.Cursor;

public class AddForm extends JDialog {

    public AddForm(JFrame parentFrame, StudentManager mng) {
        super(parentFrame, "Add Student", true);
        initComponents();
        setLocationRelativeTo(parentFrame);

        addBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fullNameField.setText(removeExtraSpaces(fullNameField.getText()));
                studentCodeField.setText(studentCodeField.getText().trim().toUpperCase());
                assignmentGradeField.setText(assignmentGradeField.getText().trim());
                labGradeField.setText(labGradeField.getText().trim());
                ptGradeField.setText(ptGradeField.getText().trim());
                peGradeField.setText(peGradeField.getText().trim());
                feGradeField.setText(feGradeField.getText().trim());

                String fullName = fullNameField.getText();
                String studentCode = studentCodeField.getText();
                String gender = genderField.getSelectedItem().toString();
                String OGassignmentGrade = assignmentGradeField.getText();
                String OGlabGrade = labGradeField.getText();
                String OGptGrade = ptGradeField.getText();
                String OGpeGrade = peGradeField.getText();
                String OGfeGrade = feGradeField.getText();

                boolean flag = true;
                flag &= checkFullName(fullName);
                flag &= checkStudentCode(studentCode, mng);
                flag &= checkGender(gender);
                flag &= checkGrade(OGassignmentGrade, assignmentGradeText, assignmentGradeField, assignmentGradeErrorNotif);
                flag &= checkGrade(OGlabGrade, labGradeText, labGradeField, labGradeErrorNotif);
                flag &= checkGrade(OGptGrade, ptGradeText, ptGradeField, ptGradeErrorNotif);
                flag &= checkGrade(OGpeGrade, peGradeText, peGradeField, peGradeErrorNotif);
                flag &= checkGrade(OGfeGrade, feGradeText, feGradeField, feGradeErrorNotif);

                if (flag == true) {
                    double assignmentGrade = Double.parseDouble(assignmentGradeField.getText());
                    double labGrade = Double.parseDouble(labGradeField.getText());
                    double ptGrade = Double.parseDouble(ptGradeField.getText());
                    double peGrade = Double.parseDouble(peGradeField.getText());
                    double feGrade = Double.parseDouble(feGradeField.getText());
                    Student student = new Student(fullName, studentCode, gender, assignmentGrade, labGrade, ptGrade, peGrade, feGrade);
                    mng.addStudent(student);
                    dispose();
                }

            }
        });

        setVisible(true);
    }

    private boolean checkFullName(String fullName) {
        if (fullName.isEmpty()) {
            fullNameErrorNotif.setText("Name can't be empty!");
            fullNameField.setForeground(new Color(244, 67, 54));
            return false;
        }

        if (!isValidName(fullName)) {
            fullNameErrorNotif.setText("Name is not in correct format!");
            fullNameField.setForeground(new Color(244, 67, 54));
            return false;
        }

        fullNameErrorNotif.setText("");
        fullNameField.setForeground(new Color(0, 0, 0));
        return true;
    }

    private boolean checkStudentCode(String studentCode, StudentManager mng) {
        if (studentCode.isEmpty()) {
            studentCodeErrorNotif.setText("Student ID can't be empty!");
            studentCodeField.setForeground(new Color(244, 67, 54));
            return false;
        }

        if (!isValidStudentCode(studentCode)) {
            studentCodeErrorNotif.setText("Student ID must be in HExxxxxx format!");
            studentCodeField.setForeground(new Color(244, 67, 54));
            return false;
        }

        Set<String> SetStudentCode = mng.getAllStudentIDs();
        if (SetStudentCode.contains(studentCode)) {
            studentCodeErrorNotif.setText("Oops, this ID has already been taken!");
            studentCodeField.setForeground(new Color(244, 67, 54));
            return false;
        }

        studentCodeErrorNotif.setText("");
        studentCodeField.setForeground(new Color(0, 0, 0));
        return true;
    }

    private boolean checkGender(String gender) {
        if (!gender.equals("Male") && !gender.equals("Female") && !gender.equals("Other")) {
            genderErrorNotif.setText("Please choose a correct option!");
            return false;
        }

        genderErrorNotif.setText("");
        return true;
    }

    private boolean checkGrade(String OGgrade, JLabel title, JTextField field, JLabel errorNotif) {
        if (OGgrade.isEmpty()) {
            errorNotif.setText("Grade can't be empty!");
            field.setForeground(new Color(244, 67, 54));
            return false;
        }

        try {
            Double.parseDouble(OGgrade);
        } catch (NumberFormatException ex) {
            errorNotif.setText("Grade must be a value!");
            field.setForeground(new Color(244, 67, 54));
            return false;
        }

        double grade = Double.parseDouble(OGgrade);
        if (grade < 0 || grade > 10) {
            errorNotif.setText("Grade must be from 0 to 10!");
            field.setForeground(new Color(244, 67, 54));
            return false;
        }

        errorNotif.setText("");
        field.setForeground(new Color(0, 0, 0));
        return true;
    }

    public static String removeExtraSpaces(String input) {
        String trimmedString = input.trim();
        String result = trimmedString.replaceAll("\\s+", " ");

        return result;
    }

    private static boolean isValidStudentCode(String input) {
        if (input.length() != 8) {
            return false;
        }

        if (!(input.charAt(0) == 'H') || !(input.charAt(1) == 'E')) {
            return false;
        }

        for (int i = 2; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidName(String fullName) {
        for (int i = 0; i < fullName.length(); i++) {
            char c = fullName.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-') {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fullNameField = new javax.swing.JTextField();
        studentCodeField = new javax.swing.JTextField();
        genderField = new javax.swing.JComboBox<>();
        labGradeField = new javax.swing.JTextField();
        ptGradeField = new javax.swing.JTextField();
        assignmentGradeField = new javax.swing.JTextField();
        peGradeField = new javax.swing.JTextField();
        feGradeField = new javax.swing.JTextField();
        fullNameText = new javax.swing.JLabel();
        studentCodeText = new javax.swing.JLabel();
        genderGradeText = new javax.swing.JLabel();
        labGradeText = new javax.swing.JLabel();
        ptGradeText = new javax.swing.JLabel();
        assignmentGradeText = new javax.swing.JLabel();
        peGradeText = new javax.swing.JLabel();
        feGradeText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fullNameErrorNotif = new javax.swing.JLabel();
        studentCodeErrorNotif = new javax.swing.JLabel();
        labGradeErrorNotif = new javax.swing.JLabel();
        assignmentGradeErrorNotif = new javax.swing.JLabel();
        ptGradeErrorNotif = new javax.swing.JLabel();
        peGradeErrorNotif = new javax.swing.JLabel();
        feGradeErrorNotif = new javax.swing.JLabel();
        genderErrorNotif = new javax.swing.JLabel();
        addBtn1 = new Detail.Button();

        fullNameField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        studentCodeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        genderField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Choose...", "Male", "Female", "Other" }));
        genderField.setToolTipText("");
        genderField.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        genderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderFieldActionPerformed(evt);
            }
        });

        labGradeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        ptGradeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ptGradeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptGradeFieldActionPerformed(evt);
            }
        });

        assignmentGradeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        peGradeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        feGradeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        fullNameText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullNameText.setText("Name");

        studentCodeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentCodeText.setText("Student ID");

        genderGradeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        genderGradeText.setText("Gender");

        labGradeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labGradeText.setText("LAB");

        ptGradeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ptGradeText.setText("Progress Test");

        assignmentGradeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        assignmentGradeText.setText("Assignment");

        peGradeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        peGradeText.setText("Practical Exam");

        feGradeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        feGradeText.setText("Final Exam");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(174, 41, 5));
        jLabel1.setText("ADD STUDENT");

        fullNameErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullNameErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        studentCodeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentCodeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        labGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        assignmentGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        assignmentGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        ptGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ptGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        peGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        peGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        feGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        feGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        genderErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        genderErrorNotif.setForeground(new java.awt.Color(244, 67, 54));

        addBtn1.setBorder(null);
        addBtn1.setForeground(new java.awt.Color(255, 255, 255));
        addBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Student/AddForm/add_button.png"))); // NOI18N
        addBtn1.setText("Add");
        addBtn1.setToolTipText("");
        addBtn1.setActionCommand("Add");
        addBtn1.setBorderColor(new java.awt.Color(190, 81, 8));
        addBtn1.setBorderPainted(false);
        addBtn1.setColor(new java.awt.Color(190, 81, 8));
        addBtn1.setColorClick(new java.awt.Color(255, 140, 9));
        addBtn1.setColorOver(new java.awt.Color(228, 97, 9));
        addBtn1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        addBtn1.setIconTextGap(12);
        addBtn1.setRadius(45);
        addBtn1.setCursor(new Cursor(12));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assignmentGradeErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labGradeErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(feGradeErrorNotif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ptGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assignmentGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assignmentGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ptGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ptGradeErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(peGradeErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 21, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fullNameErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentCodeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullNameErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignmentGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignmentGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignmentGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentCodeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ptGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ptGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ptGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(feGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void genderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderFieldActionPerformed

    private void ptGradeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptGradeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ptGradeFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Detail.Button addBtn1;
    private javax.swing.JLabel assignmentGradeErrorNotif;
    private javax.swing.JTextField assignmentGradeField;
    private javax.swing.JLabel assignmentGradeText;
    private javax.swing.JLabel feGradeErrorNotif;
    private javax.swing.JTextField feGradeField;
    private javax.swing.JLabel feGradeText;
    private javax.swing.JLabel fullNameErrorNotif;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JLabel fullNameText;
    private javax.swing.JLabel genderErrorNotif;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JLabel genderGradeText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labGradeErrorNotif;
    private javax.swing.JTextField labGradeField;
    private javax.swing.JLabel labGradeText;
    private javax.swing.JLabel peGradeErrorNotif;
    private javax.swing.JTextField peGradeField;
    private javax.swing.JLabel peGradeText;
    private javax.swing.JLabel ptGradeErrorNotif;
    private javax.swing.JTextField ptGradeField;
    private javax.swing.JLabel ptGradeText;
    private javax.swing.JLabel studentCodeErrorNotif;
    private javax.swing.JTextField studentCodeField;
    private javax.swing.JLabel studentCodeText;
    // End of variables declaration//GEN-END:variables

}
