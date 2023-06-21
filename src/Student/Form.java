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
//                System.out.println(studentID);
                StudentManager.deleteStudent(studentID);
//                System.out.println(mng.getStudentList());
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
//                    noInfoPanel.setVisible(false);
                    } else {
                        // If no row is selected, make infoPanel invisible and noInfoPanel visible
                        infoPanel.setVisible(false);
//                    noInfoPanel.setVisible(true);
                    }
                }

                // Refresh the panel
                infoPanel.revalidate();
                infoPanel.repaint();

            }
        });

        addStudentBtn.addActionListener(new ActionListener() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentTable = new Table.Table();
        addStudentBtn = new javax.swing.JButton();
        statisticPanel = new Detail.PanelRound();
        passLabel = new javax.swing.JLabel();
        statisticLabel = new javax.swing.JLabel();
        cntPassLabel = new javax.swing.JLabel();
        notPassLabel = new javax.swing.JLabel();
        cntNotPassLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        cntTotalLabel = new javax.swing.JLabel();
        searchBar = new Search.TextFieldAnimation();
        jLabel5 = new javax.swing.JLabel();
        noInfoPanel = new Detail.PanelRound();
        noInfo = new javax.swing.JLabel();
        infoPanel = new Detail.PanelRound();
        idLabel = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        studentImg = new Detail.ImageAvatar();
        name = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        ptLabel = new javax.swing.JLabel();
        pt = new javax.swing.JLabel();
        assLabel = new javax.swing.JLabel();
        ass = new javax.swing.JLabel();
        wsLabel = new javax.swing.JLabel();
        ws = new javax.swing.JLabel();
        peLabel = new javax.swing.JLabel();
        pe = new javax.swing.JLabel();
        feLabel = new javax.swing.JLabel();
        fe = new javax.swing.JLabel();
        tgLabel = new javax.swing.JLabel();
        tg = new javax.swing.JLabel();
        panelRound2 = new Detail.PanelRound();

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

        addStudentBtn.setBackground(new java.awt.Color(235, 113, 83));
        addStudentBtn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        addStudentBtn.setForeground(new java.awt.Color(255, 255, 255));
        addStudentBtn.setText("Add");

        statisticPanel.setBackground(new java.awt.Color(255, 255, 255));
        statisticPanel.setRoundBottomLeft(50);
        statisticPanel.setRoundBottomRight(50);
        statisticPanel.setRoundTopLeft(50);
        statisticPanel.setRoundTopRight(50);

        passLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/Icon/passIcon.png"))); // NOI18N
        passLabel.setText("Completed");
        passLabel.setIconTextGap(10);

        statisticLabel.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        statisticLabel.setText("Student Statistic");
        statisticLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cntPassLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cntPassLabel.setText("0");

        notPassLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        notPassLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/Icon/failIcon.png"))); // NOI18N
        notPassLabel.setText("Not completed");
        notPassLabel.setIconTextGap(10);

        cntNotPassLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cntNotPassLabel.setText("0");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/Icon/sumIcon.png"))); // NOI18N
        totalLabel.setText("Total");
        totalLabel.setIconTextGap(10);

        cntTotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cntTotalLabel.setText("0");

        statisticPanel.setLayer(passLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        statisticPanel.setLayer(statisticLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        statisticPanel.setLayer(cntPassLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        statisticPanel.setLayer(notPassLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        statisticPanel.setLayer(cntNotPassLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        statisticPanel.setLayer(totalLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        statisticPanel.setLayer(cntTotalLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout statisticPanelLayout = new javax.swing.GroupLayout(statisticPanel);
        statisticPanel.setLayout(statisticPanelLayout);
        statisticPanelLayout.setHorizontalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notPassLabel)
                    .addComponent(passLabel)
                    .addComponent(totalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cntNotPassLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cntPassLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cntTotalLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statisticPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statisticLabel)
                .addGap(83, 83, 83))
        );
        statisticPanelLayout.setVerticalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(statisticLabel)
                .addGap(18, 18, 18)
                .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(cntPassLabel))
                .addGap(18, 18, 18)
                .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notPassLabel)
                    .addComponent(cntNotPassLabel))
                .addGap(18, 18, 18)
                .addGroup(statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(cntTotalLabel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(174, 41, 5));
        jLabel5.setText("STUDENT MANAGEMENT");

        noInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        noInfoPanel.setRoundBottomLeft(50);
        noInfoPanel.setRoundBottomRight(50);
        noInfoPanel.setRoundTopLeft(50);
        noInfoPanel.setRoundTopRight(50);

        noInfo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        noInfo.setForeground(new java.awt.Color(156, 163, 175));
        noInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/Icon/noInfo.png"))); // NOI18N
        noInfo.setText("No student information");
        noInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        noInfo.setIconTextGap(10);
        noInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        noInfoPanel.add(noInfo);
        noInfo.setBounds(40, 100, 311, 430);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoPanel.setPreferredSize(new java.awt.Dimension(389, 667));
        infoPanel.setRoundBottomLeft(50);
        infoPanel.setRoundBottomRight(50);
        infoPanel.setRoundTopLeft(50);
        infoPanel.setRoundTopRight(50);
        infoPanel.setVisible(false);

        idLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        idLabel.setForeground(new java.awt.Color(30, 41, 59));
        idLabel.setText("ID:");
        idLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(idLabel);
        idLabel.setBounds(40, 70, 33, 32);

        id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        id.setForeground(new java.awt.Color(30, 41, 59));
        id.setText("HE182116");
        id.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(id);
        id.setBounds(80, 70, 115, 32);

        studentImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/StudentImg/studentImg0.jpg"))); // NOI18N
        infoPanel.add(studentImg);
        studentImg.setBounds(220, 20, 131, 131);

        name.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(210, 83, 51));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Nguyễn Thị Thanh Thảo");
        name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(name);
        name.setBounds(40, 170, 261, 32);

        genderLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(71, 85, 105));
        genderLabel.setText("Gender");
        genderLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(genderLabel);
        genderLabel.setBounds(40, 220, 80, 32);

        statusLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(71, 85, 105));
        statusLabel.setText("Status");
        statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(statusLabel);
        statusLabel.setBounds(200, 220, 68, 32);

        gender.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        gender.setForeground(new java.awt.Color(100, 116, 139));
        gender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Detail/Icon/female.png"))); // NOI18N
        gender.setText("Female");
        infoPanel.add(gender);
        gender.setBounds(40, 260, 98, 30);

        status.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        status.setForeground(new java.awt.Color(225, 29, 72));
        status.setText("Not Completed");
        infoPanel.add(status);
        status.setBounds(200, 260, 150, 30);

        ptLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        ptLabel.setForeground(new java.awt.Color(71, 85, 105));
        ptLabel.setText("Progress Test");
        ptLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(ptLabel);
        ptLabel.setBounds(40, 310, 145, 32);

        pt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pt.setForeground(new java.awt.Color(100, 116, 139));
        pt.setText("10");
        infoPanel.add(pt);
        pt.setBounds(280, 310, 80, 32);

        assLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        assLabel.setForeground(new java.awt.Color(71, 85, 105));
        assLabel.setText("Assignment");
        assLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(assLabel);
        assLabel.setBounds(40, 360, 127, 32);

        ass.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ass.setForeground(new java.awt.Color(100, 116, 139));
        ass.setText("10");
        infoPanel.add(ass);
        ass.setBounds(280, 360, 80, 32);

        wsLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        wsLabel.setForeground(new java.awt.Color(71, 85, 105));
        wsLabel.setText("Workshop");
        wsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(wsLabel);
        wsLabel.setBounds(40, 410, 111, 32);

        ws.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ws.setForeground(new java.awt.Color(100, 116, 139));
        ws.setText("9.2");
        infoPanel.add(ws);
        ws.setBounds(280, 410, 80, 32);

        peLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        peLabel.setForeground(new java.awt.Color(71, 85, 105));
        peLabel.setText("Practical Exam");
        peLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(peLabel);
        peLabel.setBounds(40, 460, 157, 32);

        pe.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        pe.setForeground(new java.awt.Color(100, 116, 139));
        pe.setText("8.5");
        infoPanel.add(pe);
        pe.setBounds(280, 460, 80, 32);

        feLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        feLabel.setForeground(new java.awt.Color(71, 85, 105));
        feLabel.setText("Final Exam");
        feLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(feLabel);
        feLabel.setBounds(40, 510, 116, 32);

        fe.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        fe.setForeground(new java.awt.Color(100, 116, 139));
        fe.setText("9.6");
        infoPanel.add(fe);
        fe.setBounds(280, 510, 90, 32);

        tgLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        tgLabel.setForeground(new java.awt.Color(71, 85, 105));
        tgLabel.setText("Total Grade ");
        tgLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoPanel.add(tgLabel);
        tgLabel.setBounds(40, 560, 135, 32);

        tg.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tg.setForeground(new java.awt.Color(100, 116, 139));
        tg.setText("9.8");
        infoPanel.add(tg);
        tg.setBounds(280, 560, 90, 32);
        infoPanel.add(panelRound2);
        panelRound2.setBounds(10, 60, 0, 0);

        noInfoPanel.setLayer(infoPanel, javax.swing.JLayeredPane.DRAG_LAYER);
        noInfoPanel.add(infoPanel);
        infoPanel.setBounds(0, 0, 389, 620);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(126, 126, 126)
                                .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel5)))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statisticPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(statisticPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(noInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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
    private javax.swing.JButton addStudentBtn;
    private javax.swing.JLabel ass;
    private javax.swing.JLabel assLabel;
    private javax.swing.JLabel cntNotPassLabel;
    private javax.swing.JLabel cntPassLabel;
    private javax.swing.JLabel cntTotalLabel;
    private javax.swing.JLabel fe;
    private javax.swing.JLabel feLabel;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel id;
    private javax.swing.JLabel idLabel;
    private Detail.PanelRound infoPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel noInfo;
    private Detail.PanelRound noInfoPanel;
    private javax.swing.JLabel notPassLabel;
    private Detail.PanelRound panelRound2;
    private javax.swing.JLabel passLabel;
    private javax.swing.JLabel pe;
    private javax.swing.JLabel peLabel;
    private javax.swing.JLabel pt;
    private javax.swing.JLabel ptLabel;
    private Search.TextFieldAnimation searchBar;
    private javax.swing.JLabel statisticLabel;
    private Detail.PanelRound statisticPanel;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statusLabel;
    private Detail.ImageAvatar studentImg;
    private Table.Table studentTable;
    private javax.swing.JLabel tg;
    private javax.swing.JLabel tgLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel ws;
    private javax.swing.JLabel wsLabel;
    // End of variables declaration//GEN-END:variables
}
