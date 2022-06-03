package entity;

import java.io.Serializable;
import java.util.Arrays;
public class Transcript implements Serializable {
    private Student student;
    private TranscriptDetail[] transcriptDetail;

    @Override
    public String toString() {
        return "Transcript{" +
                "student=" + student +
                ", transcriptDetail=" + Arrays.toString(transcriptDetail) +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TranscriptDetail[] getTranscriptDetail() {
        return transcriptDetail;
    }

    public void setTranscriptDetail(TranscriptDetail[] transcriptDetail) {
        this.transcriptDetail = transcriptDetail;
    }

    public Transcript(Student student, TranscriptDetail[] transcriptDetail) {
        this.student = student;
        this.transcriptDetail = transcriptDetail;
    }

    public Transcript() {
    }
}
