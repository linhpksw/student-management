package Student;

import java.text.DecimalFormat;

public class Student {

    private String name;
    private String studentID;
    private String gender;
    private double pt;
    private double ass;
    private double ws;
    private double pe;
    private double fe;

    public Student(String name, String studentID, String gender,
            double ass, double ws, double pt, double pe, double fe) {
        this.name = name;
        this.studentID = studentID;
        this.gender = gender;
        this.ass = roundedNumber(ass);
        this.ws = roundedNumber(ws);
        this.pt = roundedNumber(pt);
        this.pe = roundedNumber(pe);
        this.fe = roundedNumber(fe);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getAss() {
        return ass;
    }

    public void setAss(double ass) {
        this.ass = ass;
    }

    public double getWs() {
        return ws;
    }

    public void setWs(double ws) {
        this.ws = ws;
    }

    public double getPt() {
        return pt;
    }

    public void setPt(double pt) {
        this.pt = pt;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public double getTg() {
        return calcTotalGrade();
    }

    public final double calcTotalGrade() {
        return roundedNumber(0.1 * pt + 0.1 * ass + 0.1 * ws + 0.4 * pe + 0.3 * fe);
    }

    public String getStatus() {
        if (pt > 0.0 && ass > 0.0 && ws > 0.0 && pe > 0.0 && fe >= 4.0 && calcTotalGrade() >= 5) {
            return "Completed";
        } else {
            return "Incompleted";
        }
    }

    public static double roundedNumber(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        double roundedNumber = Double.parseDouble(df.format(number));
        return roundedNumber;
    }
}
