package timus.task_2111;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long weight = 0, res = 0;

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        short[] cities = new short[n];

        for (int i = 0; i < n; i++) {
            cities[i] = in.nextShort();
            weight += cities[i];
        }
        Arrays.sort(cities);

        for (int i = 0; i < n; i++) {
            res += cities[i] * weight;
            weight -= cities[i];
            res += cities[i] * weight;
        }
        System.out.println(res);
        in.close();
    }
}
