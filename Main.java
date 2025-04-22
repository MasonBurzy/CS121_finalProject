/// Main ///

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Admin admin = new Admin("admin1", "1234");
		CarRental.customers.add(new Customer("customer1", "5678"));
		CarRental.customers.add(new Customer("customer2", "abcd"));
		CarRental.availableCars.add(new Car("Civic", "lot"));
		CarRental.availableCars.add(new Car("Accord", "lot"));

		while (true) {
			String choice = menu();
			if (choice.equals("1")) { 
				loginAsCustomer();
			} else if (choice.equals("2")) {
				loginAsAdmin(admin);
			} else if (choice.equals("0")) {
				System.out.println("Exiting System...");
				break;
			} else {
				System.out.println("Invalid choice, please try again.");
			}
		}
	}





	private static String menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0) Exit");
		System.out.println("1) Login as Customer");
		System.out.println("2) Login as Admin");
		return scanner.nextLine();
	}
	
	private static void loginAsCustomer() {	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username:");
		String userName = scanner.nextLine();
		System.out.println("Enter PIN:");
		String PIN = scanner.nextLine();
		
		for (Customer customer : CarRental.customers) {
			if (customer.getUserName().equals(userName) && customer.getPIN().equals(PIN)) {
				System.out.println("Customer logged in successfully!");
				customer.start();
				return;
			}
		}
	}
	
	private static void loginAsAdmin(Admin admin) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username:");
		String userName = scanner.nextLine();
		System.out.println("Enter PIN:");
		String PIN = scanner.nextLine();
		
		if (admin.getUserName().equals(userName) && admin.getPIN().equals(PIN)){
			System.out.println("Admin logged in successfully!");
			admin.start();
		} else {
			System.out.println("Invalid username or PIN.");
		}
	}
}
