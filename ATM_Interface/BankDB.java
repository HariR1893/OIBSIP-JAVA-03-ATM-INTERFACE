package ATM_Interface;

public class BankDB {
	private Account[] accounts;
	
	public BankDB() {
		// 2 accounts for testing
		accounts = new Account[2];
		accounts[0] = new Account(12345,1111,1000.0);
		accounts[1] = new Account(67890,2222,2000.0);		
	}
	
	private Account getAccount(int accountNumber) {
		for(Account currentAccount : accounts) {
			if(currentAccount.getAccountNumber()==accountNumber) {
				return currentAccount;
			}
		}
		return null;
	}
	
	public boolean authenticateUser(int userAccountNumber,int userPIN) {
		Account userAccount = getAccount(userAccountNumber);
		
		if(userAccount != null) {
			return userAccount.validatePin(userPIN);
		}
		else
			return false;
	}
	
	
	public double getTotalBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getTotalBalance();
	}
	
	public void credit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).credit(amount);
	}
	public void debit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).debit(amount);
	}
	
}
