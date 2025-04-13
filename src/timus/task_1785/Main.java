package timus.task_1785;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        short n = in.nextShort();

        if (n >= 1000) {
            System.out.println("legion");
        } else if (n >= 500){
            System.out.println("zounds");
        } else if (n >= 250) {
            System.out.println("swarm");
        } else if (n >= 100) {
            System.out.println("throng");
        } else if (n >= 50) {
            System.out.println("horde");
        } else if (n >= 20) {
            System.out.println("lots");
        } else if (n >= 10) {
            System.out.println("pack");
        } else if (n >= 5) {
            System.out.println("several");
        } else {
            System.out.println("few");
        }

        in.close();
    }
}
