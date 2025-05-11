package timus.task_1581;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        short n = in.nextShort();
        short a = in.nextShort(), b;
        short count = 1;
        for (short i = 0; i < n - 1; i++) {
            b = in.nextShort();
            if (a == b) {
                count++;
            } else {
                System.out.printf("%d %d ", count, a);
                a = b;
                count = 1;
            }
        }

        System.out.printf("%d %d", count, a);

        in.close();
    }
}
