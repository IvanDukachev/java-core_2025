package lr1;

import java.util.Scanner;
import java.util.Calendar;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input age:");
        int age = in.nextInt();

        Calendar calendar = Calendar.getInstance();
        int cur_year = calendar.get(Calendar.YEAR);

        System.out.printf("Your year of birth is %d", cur_year - age);

        in.close();
    }
}
