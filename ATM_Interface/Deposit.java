package ATM_Interface;

public class Deposit extends Transaction{
	private double amount;
	private Keypad keypad;
	private DepositSlot depositSlot;
	private final static int CANCELED  = 0;
	
	public Deposit(int userAccountNumber,Screen atmscreen,BankDB atmdb,Keypad atmkeypad,DepositSlot atmdepositSlot) {
		super(userAccountNumber,atmscreen,atmdb);
		
		keypad = atmkeypad;
		depositSlot = atmdepositSlot;
	}
	
	@Override
	public void execute() {
		BankDB bankdb = getBankDB();
		Screen screen = getScreen();
		
		amount = promptForDepositAmount();
		
		if(amount != CANCELED) {
			screen.displayMessage("Please insert a deposit envolop containing: ");
			screen.displayAmount(amount);
			screen.displayMessageLine(".");
			
			boolean envolopeReceived = depositSlot.isEnvelopReceived();
			
			if(envolopeReceived) {
				screen.displayMessageLine("\nYour envelop has been "
						+ "recieved.\nNOTE: The money just deposited will not be available until we verify the amount"
						+ "of any enclosed cash and your checks clear.");
				bankdb.credit(getAccountNumber(), amount);
				
			}else {
				screen.displayMessageLine("\nYou did not insert an envelope, so the ATM has cancelled your transaction..");
			}
		}else {
			screen.displayMessageLine("\nCancelling Trannsaction");
		}
	}
	
	private double promptForDepositAmount() {
		Screen screen = getScreen();
		screen.displayMessage("Please Enter an deposit amount in rupees or 0 to cancel: ");
		int input = keypad.getInput();
		
		if(input==CANCELED) {
			return CANCELED;
		}else {
			return (double) input;
		}
	}
	
	
	
	
	
	
	
}
