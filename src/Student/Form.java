package Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import javax.swing.table.*;
import ActionField.TableActionCellEditor;
import ActionField.TableActionCellRender;
import ActionField.TableActionEvent;
import Search.SearchAction;

public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    private StudentManager mng;
    private DefaultTableModel tableModel;

    public Form(StudentManager manager) {
        this.mng = manager;
        initComponents();       
        init();
    }

    private void init() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (studentTable.isEditing()) {
                    studentTable.getCellEditor().stopCellEditing();
                }
                String studentID = studentTable.getValueAt(row, 2).toString();
                System.out.println(studentID);
                mng.xoaSinhVien(studentID);
                System.out.println(studentID);
                System.out.println(mng.getDanhSachSinhVien());
                updateTableData();                
            }           
        };
        SearchAction search = new SearchAction() {
            @Override
            public void onSearch() {
                if(textFieldAnimation1.getText().equals("table")){
                    updateTableData();
                    return;
                }
                String studentID = textFieldAnimation1.getText();
                Student student = StudentManager.timKiemSinhVien(studentID);
                if (student != null) {
//                    JOptionPane.showMessageDialog(null, "Student found:\n" +
//                            "No. " + (mng.getDanhSachSinhVien().indexOf(student)+1) + "\n" +
//                            "Student ID: " + student.getStudentCode() + "\n" +
//                            "Full Name: " + student.getFullName() + "\n" +
//                            "Sex: " + student.getSex());
                    DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                    model.setRowCount(0); // Clear the existing table data
            
                    Object[] row = {
                        mng.getDanhSachSinhVien().indexOf(student)+1,
                        student.getFullName(),
                        student.getStudentCode(),
                        student.getSex(),
                        student.getResult(),
                        student.status()
                    };
                     
                    model.addRow(row);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Student not found!");
                }
            }

            @Override
            public void resetTable() {
                updateTableData();
                
            }
        };
        textFieldAnimation1.initEvent(search);
        studentTable.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        studentTable.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));

        studentTable.fixTable(jScrollPane2);
        
        studentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = studentTable.getSelectedRow();
                    if (selectedRow != -1) {
                        String getFullName = studentTable.getValueAt(selectedRow, 1).toString();
                        String getGender = studentTable.getValueAt(selectedRow, 2).toString();
                        String getStudentID = studentTable.getValueAt(selectedRow, 3).toString();
                        double getTotal = Double.parseDouble(studentTable.getValueAt(selectedRow, 4).toString());
                        String getStatus = studentTable.getValueAt(selectedRow, 5).toString();
                        System.out.println("Selected Row Data: " + getFullName + " " + getGender + " " + getStudentID
                                + " " + getTotal + " " + getStatus);
                    }
                }
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddForm(Form.this, mng);
                updateTableData();
            }
        });
        
//        public void updateTableData(){
//            studentTable.
//        }
    }

    public void updateTableData() {
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0); // Clear the existing table data
        int listNumber = 1;
        ArrayList<Student> danhSachSinhVien = mng.getDanhSachSinhVien();

        for (Student sinhVien : danhSachSinhVien) {
            Object[] row = {
                listNumber++,
                sinhVien.getFullName(),
                sinhVien.getStudentCode(),
                sinhVien.getSex(),
                sinhVien.getResult(),
                sinhVien.status()
            };
            model.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new Table.Table();
        jButton1 = new javax.swing.JButton();
        textFieldAnimation1 = new Search.TextFieldAnimation();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1432, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 827, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(245, 234, 232));

        jPanel3.setBackground(new java.awt.Color(246, 189, 176));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        studentTable.setBackground(new java.awt.Color(246, 189, 176));
        studentTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        studentTable.setForeground(new java.awt.Color(246, 189, 176));
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Name", "Student ID", "Gender", "Total", "Status", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable.setFocusable(false);
        studentTable.setRowHeight(65);
        studentTable.setSelectionBackground(new java.awt.Color(235, 113, 83));
        studentTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(studentTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(299, 299, 299))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(459, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(textFieldAnimation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
//        AddForm addform = new AddForm(Form.this, mng);
//        addform.setVisible(true);
//    }// GEN-LAST:event_jButton2ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StudentManager manager = new StudentManager();

                // Create an instance of Form and pass the manager to the constructor
                Form form = new Form(manager);

                // Update the table data
                form.updateTableData();

                // Display the form
                form.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private Table.Table studentTable;
    private Search.TextFieldAnimation textFieldAnimation1;
    // End of variables declaration//GEN-END:variables
}
