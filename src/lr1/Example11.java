package lr1;

import java.util.Calendar;
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input name:");
        String name = in.nextLine();

        System.out.println("Input your year of birth:");
        int year_birth = in.nextInt();

        Calendar calendar = Calendar.getInstance();
        int cur_year = calendar.get(Calendar.YEAR);

        System.out.printf("Your name is %s and you are %d years old", name, cur_year - year_birth);

        in.close();
    }
}
