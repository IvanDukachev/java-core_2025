package timus.task_1083;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int res = 1;
        String s = in.nextLine().trim();
        int k = s.length();
        int end = n % k == 0 ? k : n % k;
        while (n > end) {
            res *= n;
            n -= k;
        }
        System.out.println(res * end);
        in.close();
    }
}
