package logic;

import entity.Student;
import main.MainRun;

import File.FileUtil;
import java.util.Scanner;

public class StudentService implements GeneralMethod {
    public static final String  file = "src/student.dat";
    public static FileUtil a = new FileUtil();

    public static void save(Student student) {
        for (int i = 0; i < MainRun.students.length; i++) {
            if (MainRun.students[i] == null) {
                MainRun.students[i] = student;
                return;
            }
        }
    }

    @Override
    public void input() {
        System.out.println("nhập số lượng sinh viên");
        int n = 0;
        do {
            try {
                n = new Scanner(System.in).nextInt();
                if (n > 0) {
                    break;
                }
                System.out.println("số sinh viên phải là số nguyên dương");
            } catch (Exception e) {
                System.out.println("số sinh viên phải là số nguyên dương");
            }
        } while (true);
        for (int i = 0; i < n; i++) {
            System.out.println("nhập sinh viên thứ " + (i + 1));
            Student student = new Student();
            student.inputStudent();
            save(student);
        }
        a.writeData(MainRun.students , file);
    }

    @Override
    public void show() {
        for (int i = 0; i < MainRun.students.length; i++) {
            if (MainRun.students[i] == null) {
                continue;
            }
            System.out.println(MainRun.students[i]);
        }
    }

    public boolean checkImpty() {
        for (int i = 0; i < MainRun.students.length; i++) {
            if (MainRun.students[i] != null) {
                return true;
            }
        }
        return false;
    }
}
