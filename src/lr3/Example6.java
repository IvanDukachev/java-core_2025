package lr3;

import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        binary_num(in.nextInt());
        in.close();
    }

    public static void binary_num(int n) {
        if (n == 1) {
            System.out.print(1);
        } else if (n == 0) {
            System.out.print(0);
        } else {
            binary_num(n / 2);
            System.out.print(n % 2);
        }
    }
}
