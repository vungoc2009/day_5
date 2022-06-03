package entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Serializable {
    final static String Dai_Cuong = "Đại cương";
    final static String Co_So_Nganh = "Cơ sở ngành";
    final static String Chuyen_Nganh = "Chuyên ngành";


    private static int autoId = -1;
    private int id;
    private String nameSubject;
    private int numberLesson;
    private String typeSubject;

    public Subject(){
        if(autoId == -1){
            autoId=100;
            id = autoId;
            return;
        }
        this.id = Subject.autoId;
    }

    public Subject(int id, String nameSubject, int numberLesson, String typeSubject) {
        this.id = id;
        this.nameSubject = nameSubject;
        this.numberLesson = numberLesson;
        this.typeSubject = typeSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(int numberLesson) {
        this.numberLesson = numberLesson;
    }

    public String getTypeSubject() {
        return typeSubject;
    }

    public void setTypeSubject(String typeSubject) {
        this.typeSubject = typeSubject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", nameSubject='" + nameSubject + '\'' +
                ", numberLesson=" + numberLesson +
                ", typeSubject='" + typeSubject + '\'' +
                '}';
    }

    public void inputSubject() {
        this.id = autoId++;
        System.out.print("nhập tên môn học ");
        this.nameSubject = new Scanner(System.in).nextLine();
        this.numberLesson =0;
        do{
            try{
                System.out.print("nhập số đơn vị học trình ");
                this.numberLesson = new Scanner(System.in).nextInt();
                if(this.numberLesson > 0){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.print("nhap lại đi ");
            }

        }while (true);
        int type =0;
        do{
            try {
                System.out.println("Môn học này thuộc thể loại nào");
                System.out.println("1: Đại Cương");
                System.out.println("2: Cơ Sở Ngành");
                System.out.println("3: Chuyên Ngành");
                type = new Scanner(System.in).nextInt();
                if(type>0 && type <4){
                    if(type == 1){
                        this.typeSubject = Subject.Dai_Cuong;
                    } else if (type == 2) {
                        this.typeSubject = Subject.Co_So_Nganh;
                    } else if (type == 3) {
                        this.typeSubject = Subject.Chuyen_Nganh;
                    }
                    break;
                }
                System.out.print("nhập lại đi ");
            }catch (InputMismatchException e){
                System.out.print("nhập lại đi ");
            }
        }while (true);
    }
}
