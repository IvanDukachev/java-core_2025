package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example9 {
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

        List<String> result = filterLettersOnly(strings);

        System.out.println("\nСтроки, содержащие только буквы:");
        if (result.isEmpty()) {
            System.out.println("Таких строк нет");
        } else {
            result.forEach(System.out::println);
        }

        in.close();
    }

    public static List<String> filterLettersOnly(List<String> strings) {
        return strings.stream()
                .filter(s -> s.matches("[a-zA-Z]+"))
                .collect(Collectors.toList());
    }
}
