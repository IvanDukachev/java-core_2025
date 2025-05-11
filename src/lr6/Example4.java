package lr6;

public class Example4 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 11; i++) {
            final int n = i;
            Thread thread = new Thread(() -> {
                System.out.printf("Поток №%d\n", n);
            });
            thread.start();
            thread.join();
        }
    }
}
