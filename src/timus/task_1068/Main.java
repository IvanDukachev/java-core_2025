package timus.task_1068;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int res = 1;

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        if (n < 0) {
            for (int i = -1; i >= n; i--){
                res += i;
            }
        } else if (n > 0) {
            for (int i = 2; i <= n; i++){
                res += i;
            }
        }

        System.out.println(res);

        in.close();
    }
}
