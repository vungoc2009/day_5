
package entity;
import java.util.InputMismatchException;
import java.util.Scanner;

public class People {

    private static int auto_id = -1;
    private int id ;
    private String name ;
    private String address;
    private int phone;

    public People() {
        if(auto_id == -1){
            auto_id = 10000;
            id = auto_id;
            return;
        }
        this.id = auto_id;
    }

    public People(int id, String name, String address, int phone) {
        this.id = People.auto_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    public void inputPeople(){
        this.id = auto_id++;
        System.out.print("nhập tên sinh viên ");
        this.name = new Scanner(System.in).nextLine();
        System.out.print("nhập địa chỉ sinh viên ");
        this.address = new Scanner(System.in).nextLine();
        System.out.print("nhập số điện thoại sinh viên ");
        this.phone =0;
        do{
           try{
               this.phone = new Scanner(System.in).nextInt();
               if(this.phone >0){
                   break;
               }
           }catch (InputMismatchException e){
               System.out.println("nhập lại số điện thoại đi");
           }
        }while (true);
    }

    @Override
    public String toString() {
        return "People{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
