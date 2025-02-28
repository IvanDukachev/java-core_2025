package lr1;

import java.util.Scanner;
import java.util.Calendar;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input your year of birth:");
        int year_birth = in.nextInt();

        Calendar calendar = Calendar.getInstance();
        int cur_year = calendar.get(Calendar.YEAR);

        System.out.printf("You are %d years old", cur_year - year_birth);

        in.close();
    }
}
