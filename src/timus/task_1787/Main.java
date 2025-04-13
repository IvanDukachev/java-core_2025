package timus.task_1787;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        short res = 0;

        Scanner in = new Scanner(System.in);

        short k = in.nextShort();
        short n = in.nextShort();

        for (short i = 0; i < n; i++) {
            res += in.nextShort();
            if (res <= k) {
                res = 0;
                continue;
            }
            res -= k;
        }

        System.out.println(res);

        in.close();
    }
}
