package ATM_Interface;

public class ATM_Class {
	private boolean userAuthenticated;
	private int currentAccountNumber;
	private Screen screen;
	private Keypad keypad;
	private DepositSlot depositSlot;
	private CashDispenser cashDispenser;
	private BankDB bankdb;
	
	private static final int BALANCE_ENQUIRY = 1;
	private static final int WITHDRAWL = 2;
	private static final int DEPOSIT = 3;
	private static final int EXIT = 4;
	
	public ATM_Class() {
		userAuthenticated = false;
		currentAccountNumber=0;
		screen = new Screen();
		keypad = new Keypad();
		cashDispenser = new CashDispenser();
		depositSlot = new DepositSlot();
		bankdb = new BankDB();
	}
	
	public void run() {
		while(true) {
			while(!userAuthenticated) {
				screen.displayMessageLine("\nWelcome!");
				authenticateUser();
			}
			performTransaction();
			userAuthenticated = false;
			currentAccountNumber = 0;
			screen.displayMessageLine("\nThank you! Come Again");
		}
	}
	
	private void authenticateUser() {
		screen.displayMessage("Please enter your account number: ");
		int accountNumber = keypad.getInput();
		screen.displayMessage("Enter your  PIN: ");
		int pin = keypad.getInput();
		
		userAuthenticated = bankdb.authenticateUser(accountNumber, pin);
		if(userAuthenticated) {
			currentAccountNumber = accountNumber;
		}
		else {
			screen.displayMessageLine("Invalid account number or PIN. Please Try again.");
		}		
	}
	
	private void performTransaction() {
		Transaction currentTransaction = null;
		boolean userExited = false;
		
		while(!userExited) {
			int mainMenuSelection = displayMainMenu();
			
			switch(mainMenuSelection) {
			case BALANCE_ENQUIRY:
			case WITHDRAWL:
			case DEPOSIT:
				currentTransaction = createTransaction(mainMenuSelection);
				currentTransaction.execute();
				break;
			case EXIT:
				screen.displayMessageLine("\nExiting the system..");
				userExited = true;
				break;
			default:
				screen.displayMessageLine("\nEnter a valid Selection!!");
				break;
			}
		}
	}
	
	private int displayMainMenu() {
		
		screen.displayMessageLine("\nMain Menu");
		screen.displayMessageLine("\n1. View Balance");
		screen.displayMessageLine("\n2. Cash WithDrawl");
		screen.displayMessageLine("\n3. Deposit Cash");
		screen.displayMessageLine("\n4. Exit");
		screen.displayMessage("\n Enter your choice:");
		return keypad.getInput();
	}
	
	private Transaction createTransaction(int type) {
		Transaction temp = null;
		switch(type) {
		case BALANCE_ENQUIRY:
			temp = new BalanceEnquiry(currentAccountNumber,screen,bankdb);
			break;
		case WITHDRAWL:
			temp = new Withdrawl(currentAccountNumber,screen,bankdb,cashDispenser,keypad);
			break;
		case DEPOSIT:
			temp = new Deposit(currentAccountNumber,screen,bankdb,keypad,depositSlot);
			break;
		}
		return temp;
	}
	
	
}
