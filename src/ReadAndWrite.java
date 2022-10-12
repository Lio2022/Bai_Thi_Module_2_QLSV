import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite <E>{
        public void write(File file, ArrayList<E> list) {
            try {
                FileOutputStream connect = new FileOutputStream(file);
                ObjectOutputStream pen = new ObjectOutputStream(connect);
                pen.writeObject(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public ArrayList<E> read(File file) {
            try {
                FileInputStream connect = new FileInputStream(file);
                ObjectInputStream pen = new ObjectInputStream(connect);
                return (ArrayList<E>) pen.readObject();
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }
    }

