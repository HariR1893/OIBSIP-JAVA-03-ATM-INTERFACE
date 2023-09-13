package ATM_Interface;

public class BalanceEnquiry extends Transaction{
	public BalanceEnquiry(int userAccountNumber, Screen atmScreen,BankDB atmdb) {
		super(userAccountNumber,atmScreen,atmdb);
	}
	
	@Override
	public void execute() {
		BankDB bankdb = getBankDB();
		Screen screen = getScreen();
		
		
		double totalBalance = bankdb.getTotalBalance(getAccountNumber());
		
		screen.displayMessageLine("\nBalance Information");
		
		screen.displayMessage(" - Total balance : ");
		screen.displayAmount(totalBalance);
		screen.displayMessageLine("");
		
		
	}
}
