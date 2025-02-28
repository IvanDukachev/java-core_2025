package timus.task_2138;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long a, b, c;

        Scanner in = new Scanner(System.in);

        String computer = in.nextLine();
        long n = in.nextLong();

        a = n / (256 * 256 * 256);
        n -= a * 256 * 256 * 256;
        b = n / (256 * 256);
        n -= b * 256 * 256;
        c = n / 256;
        n -= c * 256;

        System.out.println(n * 256 * 256 * 256 + c * 256 * 256 + b * 256 + a);
        in.close();
    }
}
