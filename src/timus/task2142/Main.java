package timus.task2142;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long a, b, c, x, y, z, k;
        Scanner in = new Scanner(System.in);

        a = in.nextLong();
        b = in.nextLong();
        c = in.nextLong();
        x = in.nextLong();
        y = in.nextLong();
        z = in.nextLong();

        in.close();
        c -= (Math.max(0, x - a) + Math.max(0, y - b));

        if (c < 0) {
            System.out.println("There are no miracles in life");
            return;
        }

        k = (a - x > 0 ? a - x : 0) + (b - y > 0 ? b - y : 0) + c;
        if (k >= z) {
            System.out.println("It is a kind of magic");
        } else {
            System.out.println("There are no miracles in life");
        }
    }
}
