package lr2;

class Bank {
    private int balance;

    Bank(int balance) {
        if (balance < 0) {
            System.out.println("Initial balance cannot be negative.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void putMoney(int money) {
        if (money > 0) {
            balance += money;
        } else {
            System.out.println("The entered number must be greater than zero");
        }
    }

    public void getMoney(int money) {
        if (money <= 0) {
            System.out.println("The entered number must be greater than zero");
        } else if (balance - money < 0) {
            System.out.println("There are not enough funds in the balance");
        } else {
            balance -= money;
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class Example7 {
    public static void main(String[] args) {
        Bank bank = new Bank(100);
        bank.putMoney(-100);
        System.out.printf("Your balance is: %d\n", bank.getBalance());

        bank.putMoney(100);
        System.out.printf("Your balance is: %d\n", bank.getBalance());

        bank.getMoney(-100);
        System.out.printf("Your balance is: %d\n", bank.getBalance());

        bank.getMoney(400);
        System.out.printf("Your balance is: %d\n", bank.getBalance());

        bank.getMoney(100);
        System.out.printf("Your balance is: %d\n", bank.getBalance());
    }
}
