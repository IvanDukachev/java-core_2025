package lr6;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Example6 {
    public static final Object SHARED_LOCK = new Object();
    private static int total = 0;

    public static void calculateSum(int[] data) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        if (cores > data.length) cores = data.length;

        int chunk = (int) Math.ceil((double) data.length / cores);
        CountDownLatch barrier = new CountDownLatch(cores);
        Thread[] workers = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            int from = i * chunk;
            int to = Math.min(from + chunk, data.length);
            final int threadIndex = i;

            workers[i] = new Thread(() -> {
                int partial = 0;
                System.out.println("Поток №" + threadIndex + " начал работу");

                for (int pos = from; pos < to; pos++) {
                    partial += data[pos];
                }

                System.out.println("Поток №" + threadIndex + " завершил работу");

                synchronized (SHARED_LOCK) {
                    total += partial;
                }

                barrier.countDown();
            });

            workers[i].start();
        }

        barrier.await();
    }

    public static int getTotalSum() {
        return total;
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[] array = new int[16];

        System.out.println("Исходный массив:");
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        calculateSum(array);

        System.out.println("Сумма элементов: " + getTotalSum());
    }
}