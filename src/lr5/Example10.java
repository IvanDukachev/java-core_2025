package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        System.out.println("\n" + "Список до: " + "\n");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            System.out.println(integers.get(i));
        }

        System.out.print("Введите пороговое значение: ");
        int num = in.nextInt();

        List<Integer> result = filterNumbersGreaterThan(integers, num);

        System.out.println("\nЧисла меньше " + num + ":");
        if (result.isEmpty()) {
            System.out.println("Нет чисел, удовлетворяющих условию");
        } else {
            result.forEach(n -> System.out.print(n + " "));
        }

        in.close();
    }

    public static List<Integer> filterNumbersGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(n -> n < num)
                .collect(Collectors.toList());
    }
}
