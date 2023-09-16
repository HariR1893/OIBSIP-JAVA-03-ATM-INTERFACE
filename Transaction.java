public class Transaction {
  
    // Declare private instance variables to store the transaction type and amount.
    private String type;
    private double amount;

    // Constructor: Initialize a Transaction object with a given type and amount.
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    // Getter method to retrieve the transaction type.
    public String getType() {
        return type;
    }

    // Getter method to retrieve the transaction amount.
    public double getAmount() {
        return amount;
    }
}
