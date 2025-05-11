package lr6;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Example5 {
    public static final Object SHARED_LOCK = new Object();
    private static int maxVal = Integer.MIN_VALUE;

    public static void processArray(int[] data) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        if (cores > data.length) cores = data.length;

        int chunk = (int) Math.ceil((double) data.length / cores);
        CountDownLatch gate = new CountDownLatch(cores);
        Thread[] workers = new Thread[cores];

        for (int idx = 0; idx < cores; idx++) {
            int begin = idx * chunk;
            final int n = idx;
            int finish = Math.min(begin + chunk, data.length);

            workers[idx] = new Thread(() -> {
                int currentMax = Integer.MIN_VALUE;
                System.out.println("Поток №" + n + " начал работу");

                for (int pos = begin; pos < finish; pos++) {
                    if (data[pos] > currentMax) {
                        currentMax = data[pos];
                    }
                }

                System.out.println("Поток №" + n + " завершил работу");

                synchronized (SHARED_LOCK) {
                    if (currentMax > maxVal) {
                        maxVal = currentMax;
                    }
                }

                gate.countDown();
            });

            workers[idx].start();
        }

        gate.await();
    }

    public static int retrieveMax() {
        return maxVal;
    }

    public static void main(String[] args) throws InterruptedException {
        Random generator = new Random();
        int[] array = new int[16];

        System.out.println("Исходный массив:");
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        processArray(array);

        System.out.println("Максимальный элемент: " + retrieveMax());
    }
}