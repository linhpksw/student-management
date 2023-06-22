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
import Detail.StudentInfo;
import Search.SearchAction;
import java.awt.Color;
import java.awt.Cursor;

public class Form extends javax.swing.JFrame {

    // Creates new form Form
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
                // System.out.println(studentID);
                StudentManager.deleteStudent(studentID);
                // System.out.println(mng.getStudentList());
                updateTableData();
                updateStudentCounts();
                updateTableVisibility();
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
                Student student = StudentManager.searchStudent(studentID);
                if (student != null) {
                    // JOptionPane.showMessageDialog(null, "Student found:\n" +
                    // "No. " + (mng.getDanhSachSinhVien().indexOf(student)+1) + "\n" +
                    // "Student ID: " + student.getStudentCode() + "\n" +
                    // "Full Name: " + student.getFullName() + "\n" +
                    // "Sex: " + student.getSex());
                    DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
                    model.setRowCount(0); // Clear the existing table data

                    Object[] row = {
                        mng.getStudentList().indexOf(student) + 1,
                        student.getName(),
                        student.getStudentID(),
                        student.getGender(),
                        student.getTg(),
                        student.getStatus()
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

                int selectedRow = studentTable.getSelectedRow();

                if (!e.getValueIsAdjusting()) {
                    if (selectedRow != -1) {
                        String studentID = studentTable.getValueAt(selectedRow, 2).toString();
                        Student selectedStudent = StudentManager.searchStudent(studentID);

                        String getStatus = selectedStudent.getStatus();
                        // set color of status based on condition
                        if ("Completed".equals(getStatus)) {
                            status.setForeground(Color.decode("#16a34a"));
                        } else {
                            status.setForeground(Color.decode("#e11d48"));
                        }

                        String getGender = selectedStudent.getGender();
                        ImageIcon maleIcon = new ImageIcon(getClass().getResource("/Detail/Icon/male.png"));
                        ImageIcon femaleIcon = new ImageIcon(getClass().getResource("/Detail/Icon/female.png"));

                        if ("Male".equalsIgnoreCase(getGender)) {
                            gender.setIcon(maleIcon);
                            gender.setText("Male");
                        } else if ("Female".equalsIgnoreCase(getGender)) {
                            gender.setIcon(femaleIcon);
                            gender.setText("Female");
                        }

                        StudentInfo.updateInfo(id, name, gender, status,
                                pt, ass, ws, pe, fe, tg,
                                selectedStudent.getStudentID(), selectedStudent.getName(),
                                selectedStudent.getGender(), selectedStudent.getStatus(),
                                selectedStudent.getPt(), selectedStudent.getAss(),
                                selectedStudent.getWs(), selectedStudent.getPe(),
                                selectedStudent.getFe(), selectedStudent.getTg());

                        // Fetching the index of the student in your list
                        int studentIndex = mng.getStudentList().indexOf(selectedStudent);
                        // Create the path for the student's image
                        String imgPath = "/Detail/StudentImg/studentImg" + studentIndex + ".jpg";
                        // Set the image for the studentImg label
                        studentImg.setIcon(new ImageIcon(getClass().getResource(imgPath)));

                        // Make infoPanel visible and noInfoPanel invisible
                        infoPanel.setVisible(true);
                    } else {
                        // If no row is selected, make infoPanel invisible and noInfoPanel visible
                        infoPanel.setVisible(false);
                    }
                }

                // Refresh the panel
                infoPanel.revalidate();
                infoPanel.repaint();

            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddForm(Form.this, mng);
                updateTableData();
                updateStudentCounts();
                updateTableVisibility();
            }
        });

        updateStudentCounts();
        updateTableVisibility();
    }

    public void updateTableData() {
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(0); // Clear the existing table data
        int listNumber = 1;
        ArrayList<Student> studentList = mng.getStudentList();

        for (Student student : studentList) {
            Object[] row = {
                listNumber++,
                student.getName(),
                student.getStudentID(),
                student.getGender(),
                student.getTg(),
                student.getStatus()
            };
            model.addRow(row);
        }
    }

    public void updateStudentCounts() {
        int[] counts = mng.getStudentStatusCount();
        completed.setText(String.valueOf(counts[0]));
        incompleted.setText(String.valueOf(counts[1]));
        total.setText(String.valueOf(counts[2]));
    }

    public void updateTableVisibility() {
        if (mng.getStudentList().isEmpty()) {
            // If there are no students, show the 'noTablePanel' and hide the 'tablePanel'
            noTablePanel.setVisible(true);
            tablePanel.setVisible(false);
        } else {
            // If there are students, show the 'tablePanel' and hide the 'noTablePanel'
            noTablePanel.setVisible(false);
            tablePanel.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

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
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(245, 234, 232));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(174, 41, 5));
        jLabel5.setText("STUDENT MANAGEMENT APPLICATION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel5)
                .addContainerGap(1589, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(880, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
