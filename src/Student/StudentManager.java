/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
class StudentManager {

    private final ArrayList<Student> danhSachSinhVien;

    public StudentManager() {
        danhSachSinhVien = new ArrayList<>();
    }

    public void themSinhVien(Student sinhVien) {
        danhSachSinhVien.add(sinhVien);
    }

    public Student timKiemSinhVien(String studentID) {
        for (Student sinhVien : danhSachSinhVien) {
            if (sinhVien.getStudentCode().equals(studentID)) {
                return sinhVien;
            }
        }
        return null;
    }

    public void xoaSinhVien(String studentID) {
        Student sinhVien = timKiemSinhVien(studentID);
        if (sinhVien != null) {
            danhSachSinhVien.remove(sinhVien);
        }
    }

    public ArrayList<Student> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }

    public Object[][] getTableData() {
        Object[][] data = new Object[danhSachSinhVien.size()][8];
        for (int i = 0; i < danhSachSinhVien.size(); i++) {
            Student sinhVien = danhSachSinhVien.get(i);
            data[i][0] = sinhVien.getStudentCode();
            data[i][1] = sinhVien.getFullName();
            data[i][2] = sinhVien.getSex();
            data[i][3] = sinhVien.getPeGrade();
            data[i][4] = sinhVien.getAssignmentGrade();
            data[i][5] = sinhVien.getLabGrade();
            data[i][6] = sinhVien.getPeGrade();
            data[i][7] = sinhVien.getFeGrade();
        }
        return data;
    }
}