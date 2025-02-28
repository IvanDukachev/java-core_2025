package lr1;

import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input number:");
        int num = in.nextInt();

        System.out.printf("%d; %d; %d; %d", num - 1, num, num + 1, (int)Math.pow(3 * num, 2));

        in.close();
    }
}
