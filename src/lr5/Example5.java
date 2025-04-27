package lr5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> inputStrings = new ArrayList<>();

        System.out.println("Введите строки для массива:");
        while (true) {
            String input = in.nextLine();
            if (input.equalsIgnoreCase("")) {
                break;
            }
            inputStrings.add(input);
        }

        System.out.print("Введите подстроку для фильтрации: ");
        String substring = in.nextLine();

        List<String> result = filterStrings(inputStrings, substring);

        System.out.println("\nРезультат фильтрации:");
        if (result.isEmpty()) {
            System.out.println("Нет строк, содержащих подстроку \"" + substring + "\"");
        } else {
            result.forEach(System.out::println);
        }

        in.close();
    }
    public static List<String> filterStrings(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}
