import java.util.List;
import java.util.Scanner;


public class ATM {
    private String userName;
    private String userPw;
    private String enteredPin;
    private BankAccount account;
    Scanner scanner = new Scanner(System.in);
    ATM() {
        userName ="Hari";
        userPw = "1234";
        System.out.println("\nEnter your pin: ");
        
        enteredPin = scanner.next();
        account = new BankAccount();
    }

    public boolean userAuth() {
        if (enteredPin.equals(userPw)) {
            System.out.println("Welcome "+userName+"!!!");
            return true;
        } else {
            System.out.println("Incorrect password..!!");
            return false;
        }
    }

    public void start() {
        

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nBalance: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("\nEnter the deposit amount: Rs. ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("\nDeposit successful.");
                    break;
                case 3:
                    System.out.print("\nEnter the withdrawal amount: Rs. ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    List<Transaction> transactions = account.getTransactionHistory();
                    System.out.println("\nTransaction History:");
                    for (Transaction transaction : transactions) {
                        System.out.println(
                                transaction.getType() + ": Rs. " + transaction.getAmount());
                    }
                    break;
                case 5:
                    System.out.println("\nExiting ATM. Have a nice day!\n\n");
                    
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        if (!atm.userAuth()) {
            return; // Exit if authentication fails
        }

        atm.start();
    }
    
}