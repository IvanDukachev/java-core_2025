package timus.task_1319;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int first = 1, cur, diagonal = 1;

        for (int i = 1; i < n; i++) {
            first += i;
        }
        for (int i = n + 1; i > 1; i--) {
            if (i != n + 1) {
                first += i;
            }
            cur = first;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    System.out.printf("%d ", cur);
                    continue;
                }

                if (j == diagonal) {
                    cur -= n - 1;
                    System.out.printf("%d ", cur);
                    continue;
                }
                if (i == n + 1 || i == 2) {
                    if (j > diagonal) {
                        cur -= n - j;
                    } else {
                        cur -= j;
                    }
                } else {
                    if (j == diagonal - 1) {
                        cur -= n - 1;
                    } else if (j > diagonal) {
                        cur -= n - 1 - j + diagonal;
                    } else {
                        cur -= n - (diagonal - j);
                    }
                }
                System.out.printf("%d ", cur);
            }
            diagonal++;
            System.out.println();
        }

        in.close();
    }
}
