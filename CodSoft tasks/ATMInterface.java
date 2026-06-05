import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        }
        else if (amount > balance) {
            System.out.println("Insufficient Balance!");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(5000);

        int choice;

        do {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.println(
                            "Current Balance: ₹"
                                    + account.getBalance());
                    break;

                case 2:
                    System.out.print(
                            "Enter Deposit Amount: ₹");
                    double deposit =
                            sc.nextDouble();

                    account.deposit(deposit);

                    System.out.println(
                            "Balance: ₹"
                                    + account.getBalance());
                    break;

                case 3:
                    System.out.print(
                            "Enter Withdrawal Amount: ₹");
                    double withdraw =
                            sc.nextDouble();

                    account.withdraw(withdraw);

                    System.out.println(
                            "Balance: ₹"
                                    + account.getBalance());
                    break;

                case 4:
                    System.out.println(
                            "Thank You For Using ATM!");
                    break;

                default:
                    System.out.println(
                            "Invalid Choice!");
            }

        } while(choice != 4);

        sc.close();
    }
}