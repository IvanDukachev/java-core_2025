package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите размер массива: ");
            int size = in.nextInt();
            if (size <= 0) {
                throw new IllegalArgumentException("Размер массива должен быть больше нуля");
            }

            byte[] arr = new byte[size];
            System.out.println("Введите элементы массива");
            for (int i = 0; i < size; i++) {
                int num = in.nextInt();
                if (num < Byte.MIN_VALUE || num > Byte.MAX_VALUE) {
                    throw new IllegalArgumentException("Введенное число выходит за границы типа byte");
                }
                arr[i] = (byte) num;
            }

            byte sum = 0;
            for (byte num: arr) {
                if (num > 0 && sum > Byte.MAX_VALUE - num) {
                    throw new ArithmeticException("Положительное переполнение при суммировании.");
                }
                if (num < 0 && sum < Byte.MIN_VALUE - num) {
                    throw new ArithmeticException("Отрицательное переполнение при суммировании.");
                }
                sum += num;
            }
            System.out.println(sum);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e);
        }

        in.close();
    }
}
