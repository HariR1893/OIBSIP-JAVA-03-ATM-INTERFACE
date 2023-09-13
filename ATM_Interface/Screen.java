package ATM_Interface;

public class Screen {
	public void displayMessage(String message) {
		System.out.print(message);
	}
	public void displayMessageLine(String message) {
		System.out.println(message);
	}
	public void displayAmount(double amount) {
		System.out.printf("Rs. %.2f",amount);
	}
}
