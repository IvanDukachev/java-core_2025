package timus.task_1607;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        short a, b, c, d;

        Scanner in = new Scanner(System.in);

        a = in.nextShort();
        b = in.nextShort();
        c = in.nextShort();
        d = in.nextShort();
        if (a < c) {
            while (a != c) {
                a = (short) Math.min(a + b, c);
                c = (short) Math.max(a, c - d);
            }
        }

        System.out.println(a);
        in.close();
    }
}
