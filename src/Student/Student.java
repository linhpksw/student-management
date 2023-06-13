/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author Win
 */
public class Student {

    private String fullName;
    private String studentCode;
    private String sex;
    private double assignmentGrade;
    private double labGrade;
    private double ptGrade;
    private double peGrade;
    private double feGrade;
    private double result;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public double getAssignmentGrade() {
        return assignmentGrade;
    }

    public void setAssignmentGrade(double assignmentGrade) {
        this.assignmentGrade = assignmentGrade;
    }

    public double getLabGrade() {
        return labGrade;
    }

    public void setLabGrade(double labGrade) {
        this.labGrade = labGrade;
    }

    public double getPtGrade() {
        return ptGrade;
    }

    public void setPtGrade(double ptGrade) {
        this.ptGrade = ptGrade;
    }

    public double getPeGrade() {
        return peGrade;
    }

    public Student(String fullName, String studentCode, String sex, double assignmentGrade, double labGrade, double ptGrade, double peGrade, double feGrade) {
        this.fullName = fullName;
        this.studentCode = studentCode;
        this.sex = sex;
        this.assignmentGrade = assignmentGrade;
        this.labGrade = labGrade;
        this.ptGrade = ptGrade;
        this.peGrade = peGrade;
        this.feGrade = feGrade;
        this.result = calculateResult();
    }

    

    public void setPeGrade(double peGrade) {
        this.peGrade = peGrade;
    }

    public double getFeGrade() {
        return feGrade;
    }

    public void setFeGrade(double feGrade) {
        this.feGrade = feGrade;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    public double calculateResult() {
        return 0.1 * ptGrade + 0.1 * assignmentGrade + 0.1 * labGrade + 0.4 * peGrade + 0.3 * feGrade;
    }
    public String status() {
        if(ptGrade > 0.0 && assignmentGrade > 0.0 && labGrade > 0.0 && peGrade > 0.0 && feGrade >= 4.0 && calculateResult() >= 5){
            return "completed";
        } else {
            return "incompleted";
        }
    }
}
