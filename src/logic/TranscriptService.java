package logic;

import entity.Student;
import entity.Subject;
import entity.Transcript;
import entity.TranscriptDetail;
import main.MainRun;
import File.FileUtil;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TranscriptService implements GeneralMethod {
    public static final String file = "src/transcrip.dat";
    public static FileUtil fileUtil = new FileUtil();
    public static Student inputStudent(int n) {
        System.out.println("nhập mã sinh viên thứ " + (n + 1));
        int id = 0;
        Student student = null;
        do {
            try {
                System.out.print("nhập mã sinh viên ");
                id = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("mã sinh viên phải là số nguyên dương");
            }
            for (int i = 0; i < MainRun.students.length; i++) {
                if (MainRun.students[i] != null && MainRun.students[i].getId() == id) {
                    student = MainRun.students[i];
                    break;
                }
            }
            if (student != null) {
                break;
            }
            System.out.println("không có sinh viên này");
        } while (true);
        return student;
    }


    public static TranscriptDetail[] transcriptDetails() {
        int n = 0;
        do {
            try {
                System.out.print("nhập số lượng môn học ");
                n = new Scanner(System.in).nextInt();
                if (n > 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("nhập lại đi");
            }
        } while (true);
        TranscriptDetail[] transcriptDetails = new TranscriptDetail[n];
        for (int i = 0; i < n; i++) {
            TranscriptDetail transcriptDetail = new TranscriptDetail();
            int idSuject = 0;
            Subject subject = null;
            do {
                try {
                    System.out.print("nhập mã môn học thứ " + (i + 1) + " để cho điểm ");
                    idSuject = new Scanner(System.in).nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("nhập lại đi");

                }
                if (check(transcriptDetails , idSuject) == false ){
                    System.out.println("đã có mã môn học này");
                    continue;
                }
                for (int j = 0; j < MainRun.subjects.length; j++) {
                    if (MainRun.subjects[j] != null && MainRun.subjects[j].getId() == idSuject) {
                        subject = MainRun.subjects[j];
                    }
                }
                if (subject != null) {
                    break;
                }
                System.out.println("không có mã môn học này");
            } while (true);
            transcriptDetail.setSubject(subject);
            double point ;
            do{
                try{
                    System.out.print("nhập điểm sinh viên ");
                    point = new Scanner(System.in).nextDouble();
                    if(point >0 && point <=10){
                        break;
                    }
                    System.out.println("điểm phải là số dương nhỏ hơn 10");
                }catch (InputMismatchException e){
                    System.out.println("điểm phải là số dương nhỏ hơn 10");
                }
            }while (true);
            transcriptDetail.setPoint(point);
            for (int j = 0; j < transcriptDetails.length; j++) {
                if(transcriptDetails[j] == null){
                    transcriptDetails[j]  = transcriptDetail;
                    break;
                }
            }
        }
        fileUtil.writeData(MainRun.transcripts,file);
        return transcriptDetails;

    }

    public static void save(Transcript transcript) {
        for (int i = 0; i < MainRun.transcripts.length; i++) {
            if (MainRun.transcripts[i] == null) {
                MainRun.transcripts[i] = transcript;
                break;
            }
        }
    }

    @Override
    public void input() {
        int quantity = 0;
        StudentService studentService = new StudentService();
        SubjectService subjectService = new SubjectService();
        if (studentService.checkImpty() == false && subjectService.checkImpty() == false) {
            System.out.println("cần nhập sinh viên và môn học trước khi cho điểm");
        } else {
            do {
                try {
                    System.out.print("nhập số lượng sinh viên muốn cho điểm ");
                    quantity = new Scanner(System.in).nextInt();
                    if (quantity > 0) {
                        break;
                    }
                    System.out.println("phải là số dương");
                } catch (InputMismatchException e) {
                    System.out.println("nhập lại đi");
                }
            } while (true);

            for (int i = 0; i < quantity; i++) {
                Student student = inputStudent(i);
                TranscriptDetail[] transcriptDetails = transcriptDetails();
                Transcript transcript = new Transcript(student, transcriptDetails);
                save(transcript);
            }
        }

    }

    @Override
    public void show() {
        for (int i = 0; i < MainRun.transcripts.length; i++) {
            if (MainRun.transcripts[i] == null) {
                continue;
            }
            System.out.println(MainRun.transcripts[i]);
        }
    }

    public static boolean checkImpty(){
        for (int i = 0; i < MainRun.transcripts.length; i++) {
            if(MainRun.transcripts[i] == null){
                return true;
            }
        }
        return false;
    }
    public static  boolean check (TranscriptDetail[] transcriptDetails, int id) {
        for (int i = 0; i < transcriptDetails.length; i++) {
            if (transcriptDetails[i]!= null){
                if(transcriptDetails[i].getSubject().getId() == id){
                    return false;
                }
            }
        }
        return true;
    }
}
