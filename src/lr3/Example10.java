package lr3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Example10 {
    public static void timeArrayList(int n) {
        ArrayList<Integer> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
    }

    public static void timeLinkedList(int n) {
        LinkedList<Integer> people = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        while (people.size() > 1) {
            index = (index + 1) % people.size();
            people.remove(index);
        }
    }

    public static void main(String[] args) {
        int n = 100_000;

        long start = System.currentTimeMillis();
        timeArrayList(n);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList");
        System.out.println("Время выполнения: " + (end - start) + " миллисекунд");

        start = System.currentTimeMillis();
        timeLinkedList(n);
        end = System.currentTimeMillis();
        System.out.println("LinkedList");
        System.out.println("Время выполнения: " + (end - start) + " миллисекунд");
    }
}