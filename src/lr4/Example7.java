package lr4;

public class Example7 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1 " + e);
            try {
                throw new ArithmeticException("другая ошибка");
            } catch (ArithmeticException ex) {
                System.out.println("4 " + ex);
            }
        }
        System.out.println("3");
    }
}
