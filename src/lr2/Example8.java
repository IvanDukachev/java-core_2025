package lr2;

abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("The dog says woof");
    }

    public void breedInfo() {
        System.out.printf("The %s has a %s breed\n", name, breed);
    }
}

class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("The cat says meow");
    }

    public void colorInfo() {
        System.out.printf("The %s is %s\n", name, color);
    }
}

abstract class Shape1 {
    public abstract double area();
    public abstract double perimeter();
}

class Circle1 extends Shape1 {
    private double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square1 extends Shape1 {
    private int length;

    public Square1(int length) {
        this.length = length;
    }

    @Override
    public double area() {
        return length * length;
    }

    @Override
    public double perimeter() {
        return length * 4;
    }
}

public class Example8 {
    public static void main(String[] args) {
        System.out.println("Animals:");
        Dog dog = new Dog("Buddy", 5, "Labrador");
        Cat cat = new Cat("Whiskers", 3, "Black");

        dog.makeSound();
        dog.breedInfo();

        cat.makeSound();
        cat.colorInfo();

        System.out.println();
        System.out.println("Shapes:");

        Shape1 circle = new Circle1(5);
        Shape1 square = new Square1(4);

        System.out.printf("Circle area: %.2f\n", circle.area());
        System.out.printf("Circle perimeter: %.2f\n", circle.perimeter());

        System.out.printf("Square area: %.2f\n", square.area());
        System.out.printf("Square perimeter: %.2f\n", square.perimeter());
    }
}
