package lr3;

import java.util.*;

public class Example13 {
    private static final int SIZE = 8_000_000;

    public static void main(String[] args) {
        addElement();
        deleteElement();
        findElement();
    }

    private static Set<Integer> fillHashSet(long size) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        return set;
    }

    private static SortedSet<Integer> fillSortedSet(long size) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        return set;
    }

    private static List<Integer> fillArrayList(long size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static void addElement() {
        System.out.println("\n1. Время добавления элемента:");

        // HashSet (только добавление без позиции)
        Set<Integer> hashSet = fillHashSet(SIZE);
        long start = System.nanoTime();
        hashSet.add(SIZE);
        long end = System.nanoTime();
        System.out.println("HashSet (добавление элемента): " + (end - start) + " нс");
        hashSet.clear();
        System.gc();

        // SortedSet (TreeSet)
        SortedSet<Integer> sortedSet = fillSortedSet(SIZE);
        start = System.nanoTime();
        sortedSet.add(SIZE);
        end = System.nanoTime();
        System.out.println("SortedSet (добавление элемента): " + (end - start) + " нс");
        sortedSet.clear();
        System.gc();

        // ArrayList (в начало, середину, конец)
        List<Integer> arrayList = fillArrayList(SIZE);

        start = System.nanoTime();
        arrayList.add(0, SIZE);
        end = System.nanoTime();
        System.out.println("ArrayList (вставка в начало): " + (end - start) + " нс");

        start = System.nanoTime();
        arrayList.add(arrayList.size() / 2, SIZE);
        end = System.nanoTime();
        System.out.println("ArrayList (вставка в середину): " + (end - start) + " нс");

        start = System.nanoTime();
        arrayList.add(SIZE);
        end = System.nanoTime();
        System.out.println("ArrayList (вставка в конец): " + (end - start) + " нс");

        arrayList.clear();
        System.gc();
    }

    private static void deleteElement() {
        System.out.println("\n2. Время удаления элемента:");

        // HashSet
        Set<Integer> hashSet = fillHashSet(SIZE);
        long start = System.nanoTime();
        hashSet.remove(SIZE / 2);
        long end = System.nanoTime();
        System.out.println("HashSet (удаление элемента): " + (end - start) + " нс");
        hashSet.clear();
        System.gc();

        // SortedSet (TreeSet)
        SortedSet<Integer> sortedSet = fillSortedSet(SIZE);
        start = System.nanoTime();
        sortedSet.remove(SIZE / 2);
        end = System.nanoTime();
        System.out.println("SortedSet (удаление элемента): " + (end - start) + " нс");
        sortedSet.clear();
        System.gc();

        // ArrayList (удаление из начала, середины, конца)
        List<Integer> arrayList = fillArrayList(SIZE);

        start = System.nanoTime();
        arrayList.remove(0);
        end = System.nanoTime();
        System.out.println("ArrayList (удаление из начала): " + (end - start) + " нс");

        start = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        end = System.nanoTime();
        System.out.println("ArrayList (удаление из середины): " + (end - start) + " нс");

        start = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        end = System.nanoTime();
        System.out.println("ArrayList (удаление из конца): " + (end - start) + " нс");

        arrayList.clear();
        System.gc();
    }

    public static void findElement() {
        System.out.println("\n3. Время поиска элемента:");

        // HashSet
        Set<Integer> hashSet = fillHashSet(SIZE);
        long start = System.nanoTime();
        hashSet.contains(SIZE / 2);
        long end = System.nanoTime();
        System.out.println("HashSet (поиск элемента): " + (end - start) + " нс");
        hashSet.clear();
        System.gc();

        // SortedSet (TreeSet)
        SortedSet<Integer> sortedSet = fillSortedSet(SIZE);
        start = System.nanoTime();
        sortedSet.contains(SIZE / 2);
        end = System.nanoTime();
        System.out.println("SortedSet (поиск элемента): " + (end - start) + " нс");
        sortedSet.clear();
        System.gc();

        // ArrayList
        List<Integer> arrayList = fillArrayList(SIZE);
        start = System.nanoTime();
        arrayList.get(SIZE / 2);
        end = System.nanoTime();
        System.out.println("ArrayList (доступ по индексу): " + (end - start) + " нс");
        arrayList.clear();
        System.gc();
    }
}
