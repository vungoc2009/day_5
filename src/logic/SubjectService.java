package logic;

import entity.Subject;
import main.MainRun;

import File.FileUtil;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubjectService implements GeneralMethod {
    public static final String file = "src/subject.dat";
    public static FileUtil fileUtil = new FileUtil();
    public static void save(Subject subject) {
        for (int i = 0; i < MainRun.subjects.length; i++) {
            if (MainRun.subjects[i] == null) {
                MainRun.subjects[i] = subject;
                break;
            }
        }
    }

    @Override
    public void input() {
        int n = 0;
        do {
            try {
                System.out.println("nhập số lượng môn học");
                n = new Scanner(System.in).nextInt();
                if (n > 0) {
                    break;
                }
                System.out.println("nhập lại đi phải là số nguyên dương");
            } catch (InputMismatchException e) {
                System.out.println("nhập lại đi phải là số nguyên dương");
            }
        } while (true);
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin môn học thứ " + (i + 1));
            Subject subject = new Subject();
            subject.inputSubject();
            save(subject);
        }
        fileUtil.writeData(MainRun.subjects,file);
    }

    @Override
    public void show() {

        for (int i = 0; i < MainRun.subjects.length; i++) {
            if (MainRun.subjects[i] == null) {
                continue;
            }
            System.out.println(MainRun.subjects[i]);
        }


    }

    public boolean checkImpty() {
        for (int i = 0; i < MainRun.subjects.length; i++) {
            if (MainRun.subjects[i] != null) {
                return true;
            }
        }
        return false;
    }
}
