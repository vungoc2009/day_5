package logic;

import entity.Transcript;
import main.MainRun;

public class PointMedium {
    public static double pointMedium (Transcript transcript){
        double sum = 0;
        int numberLesson =0;
        double point;
        for (int i = 0; i < transcript.getTranscriptDetail().length; i++) {
            sum += transcript.getTranscriptDetail()[i].getPoint() * transcript.getTranscriptDetail()[i].getSubject().getNumberLesson();
            numberLesson += transcript.getTranscriptDetail()[i].getSubject().getNumberLesson();
        }
        point = sum/ numberLesson;
        return point;
    }
    public void show() {
        for (int i = 0; i < MainRun.transcripts.length; i++) {
            if(MainRun.transcripts[i] == null){
                continue;
            }
            int id = MainRun.transcripts[i].getStudent().getId();
            String name = MainRun.transcripts[i].getStudent().getName();
            double point = pointMedium(MainRun.transcripts[i]);
            System.out.println(id + " " + name + " " + point);
        }
    }
}
