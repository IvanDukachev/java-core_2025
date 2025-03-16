package lr2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        int minNum, bound = 200;
        List<Integer> indexes = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int size = in.nextInt();
        int[] nums = new int[size];

        Random random = new Random();

        minNum = bound;
        for (int i = 0; i < size; i++) {
            nums[i] = random.nextInt(bound);
            System.out.printf("num[%d] = %d\n", i, nums[i]);
            if (nums[i] < minNum) {
                minNum = nums[i];
                indexes.clear();
                indexes.add(i);
            } else if (nums[i] == minNum) {
                indexes.add(i);
            }
        }

        System.out.printf("Minimum number: %d\n", minNum);
        System.out.println("Indexes where the minimum number is located: " + indexes);
        in.close();
    }
}
