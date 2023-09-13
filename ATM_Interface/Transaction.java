package ATM_Interface;

public abstract class Transaction {
	private int accountNumber;
	private Screen screen;
	private BankDB bankdb;
	
	public Transaction(int userAccountNumber,Screen atmScreen,BankDB atmdb) {
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankdb = atmdb;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public Screen getScreen() {
		return screen;
	}
	public BankDB getBankDB() {
		return bankdb;
	}
	
	abstract public void execute();
}
