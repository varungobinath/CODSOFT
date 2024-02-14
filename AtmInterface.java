package org.example;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
    }

    public void processTransaction(int option, double amount) {
        switch (option) {
            case 1:
                withdraw(amount);
                break;
            case 2:
                deposit(amount);
                break;
            case 3:
                checkBalance();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
        }
    }

    private void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Updated balance: " + userAccount.getBalance());
    }

    private void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        // Example usage
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        Scanner in = new Scanner(System.in);

        while (true) {
            atm.displayOptions();
            System.out.print("Enter option (1-3): ");
            int option = in.nextInt();

            if (option == 3) {
                atm.processTransaction(option, 0); // Check balance doesn't require an amount
            } else {
                System.out.print("Enter amount: ");
                double amount = in.nextDouble();
                atm.processTransaction(option, amount);
            }

            System.out.print("Do you want to perform another transaction? (yes/no): ");
            String continueTransaction = in.next().toLowerCase();

            if (!continueTransaction.equals("yes")) {
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            }
        }

        in.close();
    }
}
