package lr8;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Excel_update {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к Excel-файлу: ");
        String filePath = scanner.nextLine();

        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(inputStream);

            int numberOfSheets = workbook.getNumberOfSheets();
            System.out.println("\nДоступные листы:");
            for (int i = 0; i < numberOfSheets; i++) {
                System.out.println((i + 1) + ". " + workbook.getSheetName(i));
            }

            System.out.print("\nВведите название листа для чтения: ");
            String sheetName = scanner.nextLine();

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.err.println("Ошибка: Лист с именем '" + sheetName + "' не найден.");
                return;
            }

            System.out.println("\nСодержимое листа '" + sheetName + "':");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл не найден по указанному пути.");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: Возможно, файл поврежден или используется другой программой.");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
        }


        scanner.close();
        System.out.println("Программа завершена.");
    }
}