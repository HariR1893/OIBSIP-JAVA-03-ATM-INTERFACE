import java.util.ArrayList;
import java.util.List;

// Define a Java class named BankAccount to model a simple bank account.
class BankAccount {
    // Declare a private instance variable to store the account balance.
    private double balance;
    
    // Declare a private instance variable to store the transaction history as a list of Transaction objects.
    private List<Transaction> transactionHistory;

    // Constructor: Initialize the account with a balance of 0.0 and an empty transaction history list.
    public BankAccount() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to retrieve the current balance of the account.
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account, updating the balance and recording the transaction.
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Credit", amount));
    }

    // Method to withdraw money from the account, if sufficient funds are available.
    // Records the transaction as a debit if successful; otherwise, prints "Insufficient funds."
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Debit", amount));
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Method to retrieve the transaction history as a list of Transaction objects.
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}


