package lr1;

import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input first number:");
        float a = in.nextFloat();

        System.out.println("Input second number:");
        float b = in.nextFloat();

        System.out.printf("%.2f + %.2f = %.2f", a, b, a + b);

        in.close();
    }
}
