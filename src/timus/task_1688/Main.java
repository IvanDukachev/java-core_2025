package timus.task_1688;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, exit = 0;
        long n;
        Scanner in = new Scanner(System.in);

        n = in.nextLong() * 3L;
        m = in.nextInt();

        for (int i = 0; i < m; i++) {
            n -= in.nextLong();
            if (n < 0 && exit == 0) {
                exit = i + 1;
            }
        }
        if (exit == 0) {
            System.out.println("Team.GOV!");
        } else {
            System.out.printf("Free after %d times.", exit);
        }
    }
}
