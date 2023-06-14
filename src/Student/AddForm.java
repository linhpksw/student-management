package Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class AddForm extends JDialog {

    public AddForm(JFrame parentFrame, StudentManager mng) {
        super(parentFrame, "Add Student", true);
        initComponents();
        setLocationRelativeTo(parentFrame);
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameField.getText();
                String studentCode = studentCodeField.getText();
                String sex = genderField.getSelectedItem().toString();
                double assignmentGrade = Double.parseDouble(assignmentGradeField.getText());
                double labGrade = Double.parseDouble(labGradeField.getText());
                double ptGrade = Double.parseDouble(ptGradeField.getText());
                double peGrade = Double.parseDouble(peGradeField.getText());
                double feGrade = Double.parseDouble(feGradeField.getText());
                Student sv = new Student(fullName, studentCode, sex, assignmentGrade, labGrade, ptGrade, peGrade, feGrade);
                mng.themSinhVien(sv);
                dispose();
            }
        });
        setVisible(true);
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

        fullNameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        studentCodeField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        genderField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        genderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderFieldActionPerformed(evt);
            }
        });

        labGradeField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        ptGradeField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        assignmentGradeField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        peGradeField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        feGradeField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        fullNameText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fullNameText.setText("Name");

        studentCodeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        studentCodeText.setText("Student ID");

        genderGradeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        genderGradeText.setText("Gender");

        labGradeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labGradeText.setText("LAB");

        ptGradeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ptGradeText.setText("Progress Test");

        assignmentGradeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        assignmentGradeText.setText("Assignment");

        peGradeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        peGradeText.setText("Practical Exam");

        feGradeText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        feGradeText.setText("Final Exam");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(174, 41, 5));
        jLabel1.setText("ADD STUDENT");

        addBtn.setBackground(new java.awt.Color(235, 113, 83));
        addBtn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(fullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(addBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(feGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assignmentGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assignmentGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ptGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ptGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(feGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(62, 62, 62))
                            .addComponent(fullNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentCodeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignmentGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assignmentGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ptGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(genderField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(ptGradeField, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(peGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(peGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(feGradeText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(addBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feGradeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
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
//                String sex = genderField.getSelectedItem().toString();
//                double assignmentGrade = Double.parseDouble(assignmentGradeField.getText());
//                double labGrade = Double.parseDouble(labGradeField.getText());
//                double ptGrade = Double.parseDouble(ptGradeField.getText());
//                double peGrade = Double.parseDouble(peGradeField.getText());
//                double feGrade = Double.parseDouble(feGradeField.getText());
//                Student sv = new Student(fullName, studentCode, sex, assignmentGrade, labGrade, ptGrade, peGrade, feGrade);
//                mng.AddStudent(sv);
//
//            }
//        }
//        );
//    }
    private void genderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderFieldActionPerformed

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
    private javax.swing.JTextField assignmentGradeField;
    private javax.swing.JLabel assignmentGradeText;
    private javax.swing.JTextField feGradeField;
    private javax.swing.JLabel feGradeText;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JLabel fullNameText;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JLabel genderGradeText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField labGradeField;
    private javax.swing.JLabel labGradeText;
    private javax.swing.JTextField peGradeField;
    private javax.swing.JLabel peGradeText;
    private javax.swing.JTextField ptGradeField;
    private javax.swing.JLabel ptGradeText;
    private javax.swing.JTextField studentCodeField;
    private javax.swing.JLabel studentCodeText;
    // End of variables declaration//GEN-END:variables

}
