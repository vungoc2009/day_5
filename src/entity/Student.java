package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends People implements Serializable {
    private String classs;

    public Student(int id, String name, String address, int phone, String classs) {
        super(id, name, address, phone);
        this.classs = classs;
    }

    public Student(String classs) {
        this.classs = classs;
    }

    public Student() {

    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public void inputStudent() {
        super.inputPeople();
        System.out.print("nhap lop cua sinh vien ");
        classs = new Scanner(System.in).nextLine();
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" +
                "classs='" + classs + '\'' +
                '}';
    }
}
