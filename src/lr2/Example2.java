package lr2;

import java.util.Arrays;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        int m, n, k, l = 1;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the height of the matrix: ");
        m = in.nextInt();

        System.out.println("Enter the width of the matrix: ");
        n = in.nextInt();

        int[][] nums = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                k = n - 1;
            } else {
                k = 0;
            }
            for (int j = n - 1; j >= 0; j--) {
                nums[i][Math.abs(k - j)] = l++;
            }
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
