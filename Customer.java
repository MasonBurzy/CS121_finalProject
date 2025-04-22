/// Customer ///

import java.util.Scanner;

public class Customer extends User {
	public Customer(String userName, String PIN) {
		super(userName, PIN);
	}

	public String menu() {
		System.out.println("0) Exit Menu\n1) Rent A Car\n3) Change PIN");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public void start() {
		System.out.println("Customer logged in.");
	}
	
	public void changePIN() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter new PIN: ");
		String newPIN = scanner.nextLine();
		setPIN(newPIN);
		System.out.println("PIN changed successfully.");
	}

}
