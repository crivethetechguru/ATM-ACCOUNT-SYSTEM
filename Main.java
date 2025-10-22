import java.util.Scanner;

public class Main {
    static int storedPin = -1;
    static int balance = 0;
    static String fullName = "";

    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n=== ATM ACCOUNT===");
            System.out.println("1. Create an account");
            System.out.println("2. Log in with a PIN");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check Balance");
            System.out.println("5. Deposit money");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = inputs.nextInt();

            switch (choice) {
                case 1:
                    createAccount(inputs);
                    break;
                case 2:
                    loginSystem(inputs);
                    break;
                case 3:
                    withdraw(inputs);
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    deposit(inputs);
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!😒");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        inputs.close();
    }

    static void createAccount(Scanner inputs) {
        System.out.print("Enter Your First Name: ");
        String firstname = inputs.next();

        System.out.print("Enter Your Last Name: ");
        String lastname = inputs.next();

        System.out.print("Enter Your Age: ");
        int age = inputs.nextInt();

        System.out.print("Enter Your Sex: ");
        String sex = inputs.next();

        System.out.print("Enter Your New PIN: ");
        int pn1 = inputs.nextInt();

        System.out.print("Confirm Your PIN: ");
        int pn2 = inputs.nextInt();

        if (pn1 == pn2) {
            storedPin = pn1;
            fullName = firstname + " " + lastname;
            System.out.println("Your Account Successfully Created ✅");
        } else {
            System.out.println("PINs do not match 😒");
        }
    }

    static void loginSystem(Scanner inputs) {
        if (storedPin == -1) {
            System.out.println("No account found. Please create one first.");
            return;
        }

        System.out.print("Enter Your PIN: ");
        int pin = inputs.nextInt();

        if (pin == storedPin) {
            System.out.println("Welcome, " + fullName + "!");
        } else {
            System.out.println("Wrong PIN 😶");
        }
    }

    static void withdraw(Scanner inputs) {
        if (storedPin == -1) {
            System.out.println("No account found. Please create one first.");
            return;
        }

        System.out.print("Enter the Amount: ");
        int amount = inputs.nextInt();

        System.out.print("Enter the PIN: ");
        int withpin = inputs.nextInt();

        if (withpin == storedPin) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("You have withdrawn ✅ " + amount + "$");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Wrong PIN 😶");
        }
    }

    static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
    static void deposit(Scanner inputs) {
        if (storedPin == -1) {
            System.out.println("No account found. Please create one first.");
            return;
        }

        System.out.print("Enter the amount to deposit: ");
        int amount = inputs.nextInt();

        System.out.print("Enter your PIN: ");
        int pin = inputs.nextInt();

        if (pin == storedPin) {
            balance += amount;
            System.out.println("Deposit successful ✅. New balance: $" + balance);
        } else {
            System.out.println("Wrong PIN 😶");
        }
    }
}