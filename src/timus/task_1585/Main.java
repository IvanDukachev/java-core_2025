package timus.task_1585;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        short a = 0, b = 0, c = 0;
        short n = in.nextShort();
        String pinguin;
        in.nextLine();
        for (short i = 0; i < n; i++) {
            pinguin = in.nextLine();
            if (Objects.equals(pinguin, "Emperor Penguin")) {
                a++;
            } else if (Objects.equals(pinguin, "Macaroni Penguin")) {
                b++;
            } else {
                c++;
            }
        }

        if (a > b) {
            if (a > c) {
                System.out.println("Emperor Penguin");
            } else {
                System.out.println("Little Penguin");
            }
        } else if (b > c) {
            System.out.println("Macaroni Penguin");
        } else {
            System.out.println("Little Penguin");
        }

        in.close();
    }
}
