package lr2;

import java.util.Scanner;

class Rectangle {
    private int length, width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int area() {
        return length * width;
    }

    public int perimeter() {
        return length * 2 + width * 2;
    }
}

public class Example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Rectangle rectangle = new Rectangle(10, 7);

        System.out.printf("Length: %d\n", rectangle.getLength());
        System.out.printf("Width: %d\n", rectangle.getWidth());
        System.out.printf("Square: %d\n", rectangle.area());
        System.out.printf("Perimeter: %d\n", rectangle.perimeter());

        System.out.print("Input length: ");
        rectangle.setLength(in.nextInt());

        System.out.print("Input width: ");
        rectangle.setWidth(in.nextInt());

        System.out.printf("Length: %d\n", rectangle.getLength());
        System.out.printf("Width: %d\n", rectangle.getWidth());
        System.out.printf("Square: %d\n", rectangle.area());
        System.out.printf("Perimeter: %d\n", rectangle.perimeter());

        in.close();
    }
}
