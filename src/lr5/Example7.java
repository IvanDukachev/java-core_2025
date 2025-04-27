package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        System.out.println("Введите строки для массива:");
        while (true) {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("")) {
                break;
            }
            strings.add(input);
        }

        System.out.print("Введите минимальную длину строки: ");
        int minLength = in.nextInt();

        List<String> result = filterStringsByLength(strings, minLength);

        System.out.println("\nСтроки длиной больше " + minLength + ":");
        if (result.isEmpty()) {
            System.out.println("Нет строк, удовлетворяющих условию");
        } else {
            result.forEach(System.out::println);
        }

        in.close();
    }

    public static List<String> filterStringsByLength(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}
