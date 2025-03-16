package lr2;

import java.util.Arrays;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        int liter, new_liter;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text to encrypt:");
        char[] text = in.nextLine().toCharArray();
        System.out.println("Enter the key");
        int key = in.nextInt() % 26;
        in.nextLine();
        for (int i = 0; i < text.length; i++) {
            liter = text[i];
            if (65 <= liter && liter <= 90) {
                if (liter + key > 90) {
                    liter = 64 + liter + key - 90;
                } else {
                    liter += key;
                }
            } else if (97 <= liter && liter <= 122) {
                if (liter + key > 122) {
                    liter = 96 + liter + key - 122;
                } else {
                    liter += key;
                }
            }
            text[i] = (char) liter;
        }
        System.out.print("Text after conversion: ");
        System.out.println(text);
        while (true) {
            System.out.println("Perform the reverse transformation? (y/n)");
            String answer = in.nextLine().trim();
            if (answer.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                break;
            } else if (answer.equalsIgnoreCase("y")) {
                for (int i = 0; i < text.length; i++) {
                    liter = text[i];
                    if (65 <= liter && liter <= 90) {
                        if (liter - key < 65) {
                            liter = 91 - (65 - (liter - key));
                        } else {
                            liter -= key;
                        }
                    } else if (97 <= liter && liter <= 122) {
                        if (liter - key < 97) {
                            liter = 123 - (97 - (liter - key));
                        } else {
                            liter -= key;
                        }
                    }
                    text[i] = (char) liter;
                }
                System.out.print("The original message: ");
                System.out.println(text);
                break;
            } else {
                System.out.println("Enter the correct answer!");
            }
        }
        in.close();
    }
}
