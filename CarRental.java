/// CarRental ///

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CarRental {
	private Admin admin = new Admin("admin1", "1234");
	public static List<Car> availableCars = new ArrayList<>();
	public static List<Customer> customers = new ArrayList<>();

	public void start() {
		loadCustomers();

		while (true) {
			String choice = menu();
			if (choice.equals("1")) {
				loginAsCustomer();
			} else if (choice.equals("2")) {
				loginAsAdmin();
			} else if (choice.equals("0")) {
				System.out.println("Exiting System...");
				saveCustomers();
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
	
	
	
	public static void saveCustomers() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.dat"))) {
			oos.writeObject(customers);
			System.out.println("Customers saved.");
			for (Customer customer : customers) {
				System.out.println("Saved customer: " + customer.getUserName() + ", PIN: " + customer.getPIN());
			}
		} catch (IOException e) {
			System.out.println("Error saving customers: " + e.getMessage());
		}
	}
	
	public static void loadCustomers() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customers.dat"))) {
			customers = (List<Customer>) ois.readObject();
			System.out.println("Customers loaded.");
			for (Customer customer : customers) {
				System.out.println("Loaded customer: " + customer.getUserName() + ", PIN: " + customer.getPIN());
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("No saved customers found or error loading.");
			customers = new ArrayList<>();
		}
	}
}
