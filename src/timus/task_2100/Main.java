package timus.task_2100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int guests = 2;
        String guest;
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            guest = in.nextLine();
            if (guest.contains("+one")) {
                guests += 2;
            } else {
                guests++;
            }
        }
        System.out.println(guests == 13 ? 1400 : guests * 100);
    }
}
