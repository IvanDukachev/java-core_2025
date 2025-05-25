package lr7;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Example9 {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("src/lr7/input.txt");
            FileWriter writer = new FileWriter("src/lr7/output.txt");

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            reader.close();
            writer.close();
            System.out.println("Файл скопирован успешно!");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
