package lr2;

interface Shape {
    double area();
    double perimeter();
}

class Square implements Shape {
    private int length;

    Square(int length) {
        this.length = length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
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

class Circle implements Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int r) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
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

class Triangle implements Shape {
    private int a, b, c;

    Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public double area() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}

public class Example6 {
    public static void main(String[] args) {
        Square square = new Square(4);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);

        System.out.printf("Square area: %.2f\n", square.area());
        System.out.printf("Circle area: %.2f\n", circle.area());
        System.out.printf("Triangle area: %.2f\n", triangle.area());
        System.out.printf("Square perimeter: %.2f\n", square.perimeter());
        System.out.printf("Circle perimeter: %.2f\n", circle.perimeter());
        System.out.printf("Triangle perimeter: %.2f\n", triangle.perimeter());
    }
}
