package timus.task_1209;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        for (long i = 0; i < n; i++){
            long k = in.nextLong() - 1;

            long t = (long) Math.sqrt(8 * k + 1);

            if (t * t == (8 * k + 1)){
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
