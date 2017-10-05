package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable {
}

public class SerDemo {

    public static void main(String[] args) {
        Dog dogObject = new Dog();
        serializeDog(dogObject);
        deSerializeDog();

    }

    /**
     * 
     */
    private static void deSerializeDog() {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dog dogAfterDeser = (Dog) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param dogObject
     */
    private static void serializeDog(Dog dogObject) {
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dogObject);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
