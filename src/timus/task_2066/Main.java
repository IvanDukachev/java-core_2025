package timus.task_2066;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        short a, b, c;
        Scanner in = new Scanner(System.in);

        a = in.nextShort();
        b = in.nextShort();
        c = in.nextShort();

        System.out.println(Math.min(a - b - c, a - b * c));
        in.close();
    }
}
