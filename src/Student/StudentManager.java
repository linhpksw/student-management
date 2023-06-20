package Student;

import java.util.ArrayList;

class StudentManager {

    private static ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public static Student searchStudent(String studentID) {
        for (Student student : studentList) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public static void deleteStudent(String studentID) {
        Student student = searchStudent(studentID);
        if (student != null) {
            studentList.remove(student);
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public Object[][] getTableData() {
        Object[][] data = new Object[studentList.size()][8];
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            data[i][0] = student.getStudentID();
            data[i][1] = student.getName();
            data[i][2] = student.getGender();
            data[i][3] = student.getPt();
            data[i][4] = student.getAss();
            data[i][5] = student.getWs();
            data[i][6] = student.getPe();
            data[i][7] = student.getFe();
        }
        return data;
    }
}
