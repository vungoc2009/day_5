package logic;

import entity.Student;
import entity.Subject;
import entity.Transcript;
import main.MainRun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sort {
    public  TranscriptService transcriptService = new TranscriptService();
    public void sort() {
        int n = 0;
        do{
            try{
                System.out.println("bạn muốn sắp xếp theo cách nào");
                System.out.println("1: họ tên");
                System.out.println("2: tên môn học");
                n = new Scanner(System.in).nextInt();
                if(n == 1 || n ==2){
                    break;
                }
                System.out.println("không có lựa chọn bạn cần mời bạn chọn lại");
            }catch (InputMismatchException e){
                System.out.println("nhập lại đi");
            }
        }while (true);
        switch (n){
            case 1:
                for (int i = 0; i < MainRun.transcripts.length; i++) {
                    if(MainRun.transcripts[i] == null){
                        continue;
                    }
                    for (int j = i+1; j < MainRun.transcripts.length; j++) {
                        if(MainRun.transcripts[j] == null){
                            continue;
                        }
                        if(MainRun.transcripts[i].getStudent().getName().compareTo(MainRun.transcripts[j].getStudent().getName())>0){
                            Transcript transcript = MainRun.transcripts[i];
                            MainRun.transcripts[i] = MainRun.transcripts[j];
                            MainRun.transcripts[j] = transcript;
                        }
                    }
                }
                transcriptService.show();
                break;

        }
    }

}
