package lr2;

import java.util.Scanner;

class Person {
    private String name, gender;
    private int age;

    Person(String name, String gender, int age) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

public class Example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Person person = new Person("Ivan", "Male", 22);

        System.out.printf("Name: %s\n", person.getName());
        System.out.printf("Gender: %s\n", person.getGender());
        System.out.printf("Age: %d\n", person.getAge());

        System.out.print("Input your name: ");
        person.setName(in.nextLine());

        System.out.print("Input your gender: ");
        person.setGender(in.nextLine());

        System.out.print("Input your age: ");
        person.setAge(in.nextInt());

        System.out.printf("Name: %s\n", person.getName());
        System.out.printf("Gender: %s\n", person.getGender());
        System.out.printf("Age: %d\n", person.getAge());

        in.close();
    }
}
