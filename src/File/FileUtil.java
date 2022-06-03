package File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileUtil {
    public static boolean isNullOrEmpty(Object object){
        return object == null;
    }
    public static boolean isNullOrEmpyArray(Object [] objects){
        return objects== null && objects.length ==0;
    }
    public void writeData(Object [] objects , String file){
        if (isNullOrEmpyArray(objects)){
            return;
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(objects);
            oos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
