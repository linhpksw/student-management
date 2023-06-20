package Student;

import java.util.ArrayList;

class StudentManager {

    private static ArrayList<Student> danhSachSinhVien;

    public StudentManager() {
        danhSachSinhVien = new ArrayList<>();
    }

    public void themSinhVien(Student sinhVien) {
        danhSachSinhVien.add(sinhVien);
    }

    public static Student timKiemSinhVien(String studentID) {
        for (Student sinhVien : danhSachSinhVien) {
            if (sinhVien.getStudentCode().equals(studentID)) {
                return sinhVien;
            }
        }
        return null;
    }

    public static void xoaSinhVien(String studentID) {
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
