package lr7;

import java.io.*;

class Person1 implements Serializable {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Example13 {
    public static void main(String[] args) {
        String filename = "person.ser";

        Person1 person = new Person1("Иван", 25);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
            System.out.println("Объект успешно записан в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person1 restoredPerson = (Person1) ois.readObject();

            System.out.println("Объект восстановлен из файла:");
            System.out.println("Имя: " + restoredPerson.getName());
            System.out.println("Возраст: " + restoredPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
