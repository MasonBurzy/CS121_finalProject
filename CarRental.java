/// CarRental ///

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CarRental {
	private Admin admin;
	public static List<Car> availableCars = new ArrayList<>();
	public static List<Customer> customers = new ArrayList<>();

	public void start() {
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

	public String menu() {
		System.out.println("0) Exit\n1) Login as Customer\n2) Login as Admin");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void loginAsCustomer() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Username: ");
		String userName = scanner.nextLine();
		System.out.print("Enter PIN: ");
		String PIN = scanner.nextLine();

		for (Customer customer : customers) {
			if (customer.login(userName, PIN)) {
				customer.start();
				return;
			}
		}
		System.out.println("Invalid Credentials.");
	}

	public void loginAsAdmin() {
		Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Username: ");
                String userName = scanner.nextLine();
                System.out.print("Enter PIN: ");
                String PIN = scanner.nextLine();

		if (admin.login(userName, PIN)) {
			admin.start();
		} else {
			System.out.println("Invalid Admin Credentials.");
		}
	}
}
