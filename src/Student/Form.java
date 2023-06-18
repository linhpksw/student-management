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
import java.awt.Color;

public class Form extends javax.swing.JFrame {
    // Creates new form Form

    private StudentManager mng;
    private DefaultTableModel tableModel;

    public Form(StudentManager manager) {
        this.mng = manager;
        initComponents();
        init();

        getContentPane().setBackground(new Color(250, 250, 250));
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
                StudentManager.xoaSinhVien(studentID);
                System.out.println(studentID);
                System.out.println(mng.getDanhSachSinhVien());
                updateTableData();
            }
        };
        // search here
        SearchAction search = new SearchAction() {
            @Override
            public void onSearch() {
                if (searchBar.getText().equals("table")) {
                    updateTableData();
                    return;
                }
                String studentID = searchBar.getText();
                Student student = StudentManager.timKiemSinhVien(studentID);
                if (student != null) {
                    // JOptionPane.showMessageDialog(null, "Student found:\n" +
                    // "No. " + (mng.getDanhSachSinhVien().indexOf(student)+1) + "\n" +
                    // "Student ID: " + student.getStudentCode() + "\n" +
                    // "Full Name: " + student.getFullName() + "\n" +
                    // "Sex: " + student.getSex());
                    DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                    model.setRowCount(0); // Clear the existing table data

                    Object[] row = {
                            mng.getDanhSachSinhVien().indexOf(student) + 1,
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
        searchBar.initEvent(search);

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
                        double getTotal = Double.parseDouble(
                                studentTable.getValueAt(selectedRow, 4).toString());
                        String getStatus = studentTable.getValueAt(selectedRow, 5).toString();

                        System.out.println("Selected Row Data: " + getFullName + " "
                                + getGender + " " + getStudentID
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new Table.Table();
        jButton1 = new javax.swing.JButton();
        panelRound1 = new Detail.PanelRound();
        passLabel = new javax.swing.JLabel();
        statisticLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        notPassLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRound2 = new Detail.PanelRound();
        imageAvatar2 = new Detail.ImageAvatar();
        statisticLabel1 = new javax.swing.JLabel();
        statisticLabel2 = new javax.swing.JLabel();
        statisticLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        searchBar = new Search.TextFieldAnimation();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1432, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 827, Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(245, 234, 232));

        jPanel3.setBackground(new java.awt.Color(246, 189, 176));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        studentTable.setBackground(new java.awt.Color(246, 189, 176));
        studentTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        studentTable.setForeground(new java.awt.Color(246, 189, 176));
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "No.", "Name", "Student ID", "Gender", "Total", "Status", ""
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
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
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 894,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jButton1.setBackground(new java.awt.Color(235, 113, 83));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("jButton1");

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        passLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/check.png"))); // NOI18N
        passLabel.setText("Passed");
        passLabel.setIconTextGap(10);

        statisticLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        statisticLabel.setText("Student Statistic");
        statisticLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("0");

        notPassLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        notPassLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/close.png"))); // NOI18N
        notPassLabel.setText("Not Passed");
        notPassLabel.setIconTextGap(10);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("0");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/sigma.png"))); // NOI18N
        totalLabel.setText("Total");
        totalLabel.setIconTextGap(10);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("0");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
                panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelRound1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound1Layout.createSequentialGroup()
                                                .addGroup(panelRound1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(notPassLabel)
                                                        .addComponent(totalLabel))
                                                .addGap(50, 50, 50)
                                                .addGroup(panelRound1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(panelRound1Layout.createSequentialGroup()
                                                .addComponent(passLabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))))
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(statisticLabel)
                                .addGap(0, 0, Short.MAX_VALUE)));
        panelRound1Layout.setVerticalGroup(
                panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(statisticLabel)
                                .addGap(18, 18, 18)
                                .addGroup(panelRound1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(passLabel))
                                .addGap(26, 26, 26)
                                .addGroup(
                                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(notPassLabel))
                                .addGap(32, 32, 32)
                                .addGroup(panelRound1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalLabel)
                                        .addComponent(jLabel3))
                                .addContainerGap(73, Short.MAX_VALUE)));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        panelRound2.setRoundBottomLeft(50);
        panelRound2.setRoundBottomRight(50);
        panelRound2.setRoundTopLeft(50);
        panelRound2.setRoundTopRight(50);

        imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/studentImg2.jpg"))); // NOI18N

        statisticLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        statisticLabel1.setForeground(new java.awt.Color(210, 83, 51));
        statisticLabel1.setText("Nguyễn Thị Thanh Thảo");
        statisticLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        statisticLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        statisticLabel2.setText("Sex");
        statisticLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        statisticLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 28)); // NOI18N
        statisticLabel3.setText("Student ID: HE182116");
        statisticLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("0");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGroup(panelRound2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound2Layout.createSequentialGroup()
                                                .addGap(125, 125, 125)
                                                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelRound2Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(panelRound2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(statisticLabel1)
                                                        .addComponent(statisticLabel2)))
                                        .addGroup(panelRound2Layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(jLabel4)))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(statisticLabel3)
                                        .addContainerGap(70, Short.MAX_VALUE))));
        panelRound2Layout.setVerticalGroup(
                panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(statisticLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statisticLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addContainerGap(152, Short.MAX_VALUE))
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(statisticLabel3)
                                        .addContainerGap(478, Short.MAX_VALUE))));

        searchBar.setText("textFieldAnimation1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(77, 77, 77)
                                                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)))
                                .addContainerGap(1287, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addGap(90, 90, 90)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(576, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//
    // GEN-FIRST:event_jButton2ActionPerformed
    // AddForm addform = new AddForm(Form.this, mng);
    // addform.setVisible(true);
    // }// GEN-LAST:event_jButton2ActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
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
    private Detail.ImageAvatar imageAvatar2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel notPassLabel;
    private Detail.PanelRound panelRound1;
    private Detail.PanelRound panelRound2;
    private javax.swing.JLabel passLabel;
    private Search.TextFieldAnimation searchBar;
    private javax.swing.JLabel statisticLabel;
    private javax.swing.JLabel statisticLabel1;
    private javax.swing.JLabel statisticLabel2;
    private javax.swing.JLabel statisticLabel3;
    private Table.Table studentTable;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
