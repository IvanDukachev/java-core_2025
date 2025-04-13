package timus.task_1197;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s;
        char l, r;
        short n;
        Scanner in = new Scanner(System.in);
        n = in.nextShort();
        in.nextLine();
        for (short i = 0; i < n; i ++) {
            s = in.nextLine();
            l = s.charAt(0);
            r = s.charAt(1);
            if (l == 'a' || l == 'h') {
                if (r == '1' || r == '8') {
                    System.out.println(2);
                } else if (r == '2' || r == '7') {
                    System.out.println(3);
                } else {
                    System.out.println(4);
                }
            } else if (l == 'b' || l == 'g') {
                if (r == '1' || r == '8') {
                    System.out.println(3);
                } else if (r == '2' || r == '7') {
                    System.out.println(4);
                } else {
                    System.out.println(6);
                }
            } else {
                if (r == '1' || r == '8') {
                    System.out.println(4);
                } else if (r == '2' || r == '7') {
                    System.out.println(6);
                } else {
                    System.out.println(8);
                }
            }
        }
        in.close();
    }
}
