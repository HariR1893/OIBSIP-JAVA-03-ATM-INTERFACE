package ATM_Interface;

public class Withdrawl extends Transaction {
	private int amount;
	private Keypad keypad;
	private CashDispenser cashDispenser;
	
	private final static int CANCELED = 6;
	
	public Withdrawl(int userAccountNumber,Screen atmScreen,BankDB atmdb,CashDispenser atmcashDispenser,Keypad atmkeypad) {
		super(userAccountNumber,atmScreen,atmdb);
		
		keypad = atmkeypad;
		cashDispenser = atmcashDispenser;
	}
	
	@Override
	 public void execute(){
		boolean cashDispensed = false;
		double totalBalance;
		
		BankDB bankdb = getBankDB();
		Screen screen = getScreen();
		
		do {
			amount = displayMenuOfAmounts();
			
			if(amount != CANCELED) {
				totalBalance = bankdb.getTotalBalance(getAccountNumber());
				if(amount <= totalBalance) {
					if(cashDispenser.isSufficientCashAvailable(amount)) {
						bankdb.debit(getAccountNumber(), amount);
						cashDispenser.dispenseCash(amount);
						cashDispensed = true;
						
						screen.displayMessageLine("\nYour cash has been dispensed. Please Take your case..");
					}else {
						screen.displayMessageLine("\nInsufficient Balance available..Please enter smaller amount.");
					}
				}else {
					screen.displayMessageLine("\nInsufficient Balance available..Please enter smaller amount.");
				}
			}else {
				screen.displayMessageLine("\nCancelling Transactions.");
				return;
			}
		}while(!cashDispensed);
	}
	
	private int displayMenuOfAmounts() {
		int userChoice =0;
		Screen screen = getScreen();
		int [] amounts = {0,100,200,500,2000};
		
		while(userChoice == 0) {
			screen.displayMessageLine("\nWithdrawl Menu");
			screen.displayMessageLine("1 - Rs. 100");
			screen.displayMessageLine("2 - Rs. 200");
			screen.displayMessageLine("3 - Rs. 500");
			screen.displayMessageLine("4 - Rs. 2000");
			screen.displayMessageLine("5 - Cancel Transaction");
			
			screen.displayMessage("Choose a withdrawl amount: ");
			
			int input = keypad.getInput();
			
			switch(input) {
			case 1:
			case 2:
			case 3:
			case 4:
				userChoice = amounts[input];
				break;
			case CANCELED:
				break;
			default:
				screen.displayMessageLine("Invalid Selection.. Try again");
			}
		}
	
	
	return userChoice;
	}
}
