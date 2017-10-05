package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal {
    int baseVariable = 10;

    Animal() {
        baseVariable = 20;
    }

}

class Cat extends Animal implements Serializable {
    int catVarOne = 100;
    int catVarTwo = 200;

    Cat() {
        baseVariable = 30;
    }
}

public class InheritanceSerialization {

    public static void main(String[] args) {
        Cat catObject = new Cat();
        catObject.baseVariable = 1000;
        serializeCat(catObject);
        deSerializeCat();
    }

    /**
     * @param catObject
     */
    private static void serializeCat(Cat catObject) {
        try {
            FileOutputStream fos = new FileOutputStream("data.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(catObject);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    private static void deSerializeCat() {
        try {
            FileInputStream fis = new FileInputStream("data.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Cat catAfterDeser = (Cat) ois.readObject();
            System.out.println("Base: " + catAfterDeser.baseVariable); // 1000
                                                                       // or 10 or 20 or 30
                                                                       // ??
            System.out.println("cat var one: " + catAfterDeser.catVarOne);
            System.out.println("cat var two: " + catAfterDeser.catVarTwo);
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
