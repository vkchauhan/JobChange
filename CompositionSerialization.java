package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Collar {
    int collarVariable = 10;

    Collar() {
        collarVariable = 20;
    }

}

class Pig implements Serializable {
    int pigVarOne = 100;
    int pigVarTwo = 200;
    Collar collar;

    Pig() {
        collar = new Collar(); // serializable containing not serializable
                               // object
    }

}

public class CompositionSerialization {

    public static void main(String[] args) {
        Pig pigObject = new Pig();

        serializePig(pigObject);
        deSerializePig();
    }

    /**
     * @param pigObject
     */
    private static void serializePig(Pig pigObject) {
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pigObject);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    private static void deSerializePig() {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Pig pigAfterDeser = (Pig) ois.readObject();
            System.out.println("pig var one: " + pigAfterDeser.pigVarOne);
            System.out.println("pig var two: " + pigAfterDeser.pigVarTwo);
            System.out.println("collar.collarVariable: " + pigAfterDeser.collar.collarVariable);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
