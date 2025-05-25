package lr7;

import java.io.*;
import java.util.Scanner;

public class Example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = in.nextLine();

        System.out.print("Введите слово для поиска: ");
        String targetWord = in.nextLine();

        File file = new File("lr7/" + fileName);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Файл не найден.");
            in.close();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            boolean found = false;

            System.out.println("Строки, содержащие слово \"" + targetWord + "\":");

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.contains(targetWord)) {
                    System.out.printf("Строка %d: %s%n", lineNumber, line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Слово в файле не найдено.");
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        in.close();
    }
}
