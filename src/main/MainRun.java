package main;

import entity.Student;
import entity.Subject;
import entity.Transcript;
import logic.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainRun {
    public static Student[] students = new Student[100];
    public static Subject[] subjects = new Subject[100];
    public static Transcript[] transcripts = new Transcript[100];

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        SubjectService subjectService = new SubjectService();
        TranscriptService transcriptService = new TranscriptService();
        Sort sort = new Sort();
        PointMedium pointMedium = new PointMedium();


        while (true) {
            System.out.println("nhập lựa chọn của bạn");
            System.out.println("1: nhập sinh viên");
            System.out.println("2: in sinh viên");
            System.out.println("3: nhập danh sách môn học");
            System.out.println("4: in danh sách môn học");
            System.out.println("5: cho điểm");
            System.out.println("6: sắp xếp");
            System.out.println("7: điểm trung bình");
            int n;
            do {
                try {
                    n = new Scanner(System.in).nextInt();
                    if (n > 0 && n <= 7) {
                        break;
                    }
                    System.out.println("không có lựa chọn của bạn");
                } catch (InputMismatchException e) {
                    System.out.println("không có lựa chọn của bạn");
                }
            } while (true);
            switch (n) {
                case 1:
                    studentService.input();
                    break;
                case 2:
                    studentService.show();
                    break;
                case 3:
                    subjectService.input();
                    break;
                case 4:
                    subjectService.show();
                    break;
                case 5:
                    transcriptService.input();
                    transcriptService.show();
                    break;
                case 6:
                    sort.sort();
                    break;
                case 7:
                    pointMedium.show();
                    break;
            }
        }


    }


}
