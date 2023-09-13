package ATM_Interface;

public class Account {
	private int accountNumber;
	private int pin;
	
	private double totalBalance;
	
	public Account(int theAccountNumber,int thePIN,double theTotalBalance) {
		accountNumber = theAccountNumber;
		pin = thePIN;
		
		totalBalance = theTotalBalance;
	}
	
	public boolean validatePin (int userPIN) {
		if(userPIN==pin) {
			return true;
		}
		else
			return false;
	}
	
	
	
	public double getTotalBalance() {
		return totalBalance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void credit(double amount) {
		totalBalance += amount;
	}
	
	public void debit(double amount) {
		totalBalance -= amount;
	}
	
}
