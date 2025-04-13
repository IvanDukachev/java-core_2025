package timus.task_2001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        short a, b;
        Scanner in = new Scanner(System.in);

        a = in.nextShort();
        b = in.nextShort();

        in.nextShort();
        b -= in.nextShort();

        a -= in.nextShort();
        in.nextShort();

        System.out.printf("%d %d", a, b);
    }
}
