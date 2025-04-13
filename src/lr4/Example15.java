package lr4;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Example15 {
    public static double positive_avg(int[] arr) {
        int sum = 0;
        int count = 0;
        for (int num: arr) {
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) {
            throw new ArithmeticException("Нет положительных чисел в массиве");
        }
        return (double) sum / count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = in.nextInt();
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть больше нуля");
            }
            int[] arr = new int[size];
            System.out.println("Введите элементы массива:");
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }
            double res = positive_avg(arr);
            System.out.printf("Среднее значение среди положительных элементов массива = %.2f", res);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e);
        }

        in.close();
    }
}
