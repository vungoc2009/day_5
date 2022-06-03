package entity;

import java.io.Serializable;

public class TranscriptDetail implements Serializable {
    private Subject subject;
    private double point;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public TranscriptDetail() {
    }

    public TranscriptDetail(Subject subject, double point) {
        this.subject = subject;
        this.point = point;
    }

    @Override
    public String toString() {
        return "TranscriptDetail{" +
                "subject=" + subject +
                ", point=" + point +
                '}';
    }
}
