package lr3;

import java.util.ArrayList;
import java.util.Scanner;

public class Example7 {
    private static int size;
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива: ");
        size = in.nextInt();

        enter_array(0, in);
        print_array(0);
        in.close();
    }

    public static void enter_array(int n, Scanner in) {
        if (n == size) {
            return;
        } else {
            System.out.printf("Введите элемент %d: ", n);
            list.add(in.nextInt());
            enter_array(++n, in);
        }
    }

    public static void print_array(int n) {
        if (n == size) {
            return;
        }
        System.out.printf("Элемент с индексом %d = %d\n", n, list.get(n));
        print_array(++n);
    }
}
