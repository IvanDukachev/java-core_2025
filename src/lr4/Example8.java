package lr4;

public class Example8 {
    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (RuntimeException e) {
            System.out.println("2 " + e);
        } finally {
            System.out.println("1");
        }
        return 140950_08;
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
