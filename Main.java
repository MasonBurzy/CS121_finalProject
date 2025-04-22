/// Main ///

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		while (true) {
			String choice = menu();
			if (choice.equals("1")) { 
				loginAsCustomer();
			} else if (choice.equals("2")) {
				loginAsAdmin();
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
		Customer customer = new Customer("customer1", "5678");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username:");
		String userName = scanner.nextLine();
		System.out.println("Enter PIN:");
		String PIN = scanner.nextLine();
		
		if (customer.login(userName, PIN)) {
			System.out.println("Customer logged in successfully!");
			customer.start();  // Or any other customer-specific logic
		} else {
			System.out.println("Invalid username or PIN.");
		}
	}
	
	
	private static void loginAsAdmin() {
		Admin admin = new Admin("admin1", "1234"); // Example username and PIN
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username:");
		String userName = scanner.nextLine();
		System.out.println("Enter PIN:");
		String PIN = scanner.nextLine();
		
		if (admin.login(userName, PIN)) {
			System.out.println("Admin logged in successfully!");
			admin.start();
		} else {
			System.out.println("Invalid username or PIN.");
		}
	}
}
		

/*

		Admin admin = new Admin("admin1", "1234");
		Customer customer = new Customer("customer1", "5678");
		
		if (admin.login("admin1", "1234")) {
			System.out.println("Admin logged in successfully!");
			System.out.println(admin.menu());
			System.out.println(admin.getReport());
		} else {
			System.out.println("Admin login failed.");
		}
		
		if (customer.login("customer1", "5678")) {
			System.out.println("Customer logged in successfully!");
			System.out.println(customer.menu());
		} else {
			System.out.println("Customer login failed.");
		}
	}
}

*/
