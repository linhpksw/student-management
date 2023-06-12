package student;
import java.util.ArrayList;

public class QuanLi {
    private ArrayList<SinhVien> danhSach;

    public QuanLi() {
        this.danhSach=new ArrayList<SinhVien>();
    }

    public QuanLi(ArrayList<SinhVien> danhSach) {
        this.danhSach = danhSach;
    }
    public void AddStudent(SinhVien sv){
        this.danhSach.add(sv);
    }
    public boolean DeleteStudent(SinhVien sv){
        return this.danhSach.remove(sv);
    }
    public void SearchStudent(String msv){
        for(SinhVien sv : danhSach){
            if(sv.getFullName().indexOf(msv)>=0) System.out.println(msv);
        }
    }
}