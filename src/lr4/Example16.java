package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите количество строк в матрице: ");
            int rows = in.nextInt();
            System.out.print("Введите количество столбцов в матрице: ");
            int cols = in.nextInt();

            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException("Размеры матрицы должны быть положительными числами");
            }

            int[][] matrix = new int[rows][cols];
            System.out.println("Введите элементы матрицы");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            System.out.print("Введите номер столбца для вывода: ");
            int col = in.nextInt();
            for (int i = 0; i < rows; i++) {
                if (col < 0 || col >= matrix[0].length) {
                    throw new ArrayIndexOutOfBoundsException("Введенного столбца не существует");
                }
                System.out.printf("matrix[%d][%d] = %d\n", i, col, matrix[i][col]);
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e);
        }

        in.close();
    }
}
