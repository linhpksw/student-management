package Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddForm extends JDialog {

    public AddForm(JFrame parentFrame, StudentManager mng) {
        super(parentFrame, "Add Student", true);
        initComponents();
        setLocationRelativeTo(parentFrame);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String studentCode = studentCodeField.getText();
                    String gender = genderField.getSelectedItem().toString();
                    String OGassignmentGrade = assignmentGradeField.getText();
                    String OGlabGrade = labGradeField.getText();
                    String OGptGrade = ptGradeField.getText();
                    String OGpeGrade = peGradeField.getText();
                    String OGfeGrade = feGradeField.getText();

                    if (!isNotEmptyFields(fullName, studentCode, OGassignmentGrade, OGlabGrade, OGptGrade, OGpeGrade, OGfeGrade)) {
                        Notification.showErrorMessage(AddForm.this, "Some fields are blank. Please check the fields.");
                    } else if (isContainNumbers(fullName)) {
                        Notification.showErrorMessage(AddForm.this, "Name can't contain numbers. Please check the Name field.");
                    } else if (!isValidStudentCode(studentCode)) {
                        Notification.showErrorMessage(AddForm.this, "Student ID is not in correct format. Please check the Student ID field.");
                    } else if (!isValidRange(OGassignmentGrade, OGlabGrade, OGptGrade, OGpeGrade, OGfeGrade)) {
                        Notification.showErrorMessage(AddForm.this, "Some grades are not in correct range. Please check the grade fields.");
                    } else {
                        double assignmentGrade = Double.parseDouble(assignmentGradeField.getText());
                        double labGrade = Double.parseDouble(labGradeField.getText());
                        double ptGrade = Double.parseDouble(ptGradeField.getText());
                        double peGrade = Double.parseDouble(peGradeField.getText());
                        double feGrade = Double.parseDouble(feGradeField.getText());
                        Student student = new Student(fullName, studentCode, gender, assignmentGrade, labGrade, ptGrade, peGrade, feGrade);
                        mng.addStudent(student);
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    Notification.showErrorMessage(AddForm.this, "Invalid numeric input. Please check the grade fields.");
                }
            }
        });

        setVisible(true);
    }

    private boolean isValidRange(String OGassignmentGrade, String OGlabGrade, String OGptGrade, String OgpeGrade, String OGfeGrade) {
        double assignmentGrade = Double.parseDouble(assignmentGradeField.getText());
        double labGrade = Double.parseDouble(labGradeField.getText());
        double ptGrade = Double.parseDouble(ptGradeField.getText());
        double peGrade = Double.parseDouble(peGradeField.getText());
        double feGrade = Double.parseDouble(feGradeField.getText());
        return assignmentGrade >= 0 && assignmentGrade <= 10
                && labGrade >= 0 && labGrade <= 10
                && ptGrade >= 0 && ptGrade <= 10
                && peGrade >= 0 && peGrade <= 10
                && feGrade >= 0 && feGrade <= 10;
    }

    public static boolean isNotEmptyFields(String fullName, String studentCode, String assignmentGrade, String labGrade, String ptGrade, String peGrade, String feGrade) {
        return !fullName.isEmpty() && !studentCode.isEmpty()
                && !assignmentGrade.isEmpty() && !labGrade.isEmpty()
                && !labGrade.isEmpty() && !ptGrade.isEmpty()
                && !peGrade.isEmpty() && !feGrade.isEmpty();
    }

    public static boolean isValidStudentCode(String input) {
        if (input.length() != 8) {
            return false;
        }

        if (!input.startsWith("HE")) {
            return false;
        }

        for (int i = 2; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isContainNumbers(String fullName) {
        for (char c : fullName.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
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
        addBtn = new javax.swing.JButton();
        fullNameErrorNotif = new javax.swing.JLabel();
        studentCodeErrorNotif = new javax.swing.JLabel();
        labGradeErrorNotif = new javax.swing.JLabel();
        assignmentGradeErrorNotif = new javax.swing.JLabel();
        ptGradeErrorNotif = new javax.swing.JLabel();
        peGradeErrorNotif = new javax.swing.JLabel();
        feGradeErrorNotif = new javax.swing.JLabel();

        fullNameField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        studentCodeField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        genderField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
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

        addBtn.setBackground(new java.awt.Color(235, 113, 83));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");

        fullNameErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        fullNameErrorNotif.setForeground(new java.awt.Color(244, 67, 54));
        fullNameErrorNotif.setText("jLabel2");

        studentCodeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        studentCodeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));
        studentCodeErrorNotif.setText("jLabel2");

        labGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));
        labGradeErrorNotif.setText("jLabel2");

        assignmentGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        assignmentGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));
        assignmentGradeErrorNotif.setText("jLabel2");

        ptGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ptGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));
        ptGradeErrorNotif.setText("jLabel2");

        peGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        peGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));
        peGradeErrorNotif.setText("jLabel2");

        feGradeErrorNotif.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        feGradeErrorNotif.setForeground(new java.awt.Color(244, 67, 54));
        feGradeErrorNotif.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(583, 583, 583)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(assignmentGradeErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ptGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(feGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assignmentGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(assignmentGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ptGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ptGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(feGradeErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fullNameErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentCodeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(fullNameErrorNotif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignmentGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignmentGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(ptGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feGradeErrorNotif, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public AddForm(JFrame parentFrame, QuanLi mng) {
//        super(parentFrame, "Add Student", true);
//        addBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String fullName = fullNameField.getText();
//                String studentCode = studentCodeField.getText();
//                String gender = genderField.getSelectedItem().toString();
//                double assignmentGrade = Double.parseDouble(assignmentGradeField.getText());
//                double labGrade = Double.parseDouble(labGradeField.getText());
//                double ptGrade = Double.parseDouble(ptGradeField.getText());
//                double peGrade = Double.parseDouble(peGradeField.getText());
//                double feGrade = Double.parseDouble(feGradeField.getText());
//                Student student = new Student(fullName, studentCode, gender, assignmentGrade, labGrade, ptGrade, peGrade, feGrade);
//                mng.AddStudent(student);
//
//            }
//        }
//        );
//    }
    private void genderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderFieldActionPerformed

    private void ptGradeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptGradeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ptGradeFieldActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AddForm.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AddForm.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AddForm.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AddForm.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new AddForm().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel assignmentGradeErrorNotif;
    private javax.swing.JTextField assignmentGradeField;
    private javax.swing.JLabel assignmentGradeText;
    private javax.swing.JLabel feGradeErrorNotif;
    private javax.swing.JTextField feGradeField;
    private javax.swing.JLabel feGradeText;
    private javax.swing.JLabel fullNameErrorNotif;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JLabel fullNameText;
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
