package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.stream.Collectors;

public class Example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        System.out.println("\n" + "Список до: " + "\n");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            System.out.println(integers.get(i));
        }

        System.out.print("Введите число для проверки делимости: ");
        int num = in.nextInt();

        List<Integer> result = filterDivisibleNumbers(integers, num);

        System.out.println("\nЧисла, делящиеся на " + num + " без остатка:");
        if (result.isEmpty()) {
            System.out.println("Таких чисел нет");
        } else {
            result.forEach(System.out::println);
        }
    }

    public static List<Integer> filterDivisibleNumbers(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(n -> n % num == 0)
                .collect(Collectors.toList());
    }
}
