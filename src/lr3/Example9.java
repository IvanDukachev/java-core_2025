package lr3;

import java.util.HashMap;
import java.util.Map;

public class Example9 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "sixsix");
        map.put(7, "sevenss");
        map.put(8, "eighttt");
        map.put(9, "nineeee");

        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        if (map.containsKey(0)) {
            System.out.println("Строка при ключе 0: " + String.join(", ", map.get(0)));
        }

        int product = 1;
        boolean hasLongStrings = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                hasLongStrings = true;
            }
        }

        if (hasLongStrings) {
            System.out.println("Произведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("Нет строк длиной больше 5 символов.");
        }
    }
}
