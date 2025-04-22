/// Admin ///

import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Admin extends User {
	private static final Scanner scanner = new Scanner(System.in);
	private static List<Customer> customers = new ArrayList<>();
	private static List<Car> cars = new ArrayList<>();


	public Admin(String userName, String PIN) {
		super(userName, PIN);
	}

	public String menu() {
		System.out.println("0) Exit This Menu\n 1) Full Customer Report\n 2) Add User\n 3) Add Car");
		return scanner.nextLine();
	}

	public void start() {
		System.out.println("Login Successful.");
	}

	public String getReport() {
		StringBuilder report = new StringBuilder("Customer Report:\n");
		for (Customer customer : customers) {
			report.append("Username: ").append(customer.getUserName()).append(", PIN: ").append(customer.getPIN()).append("\n");
		}

		return report.toString();
	}

	public void addUser() {
		System.out.println("Enter New Username:");
		String newUserName = scanner.nextLine();
		System.out.println("Enter new PIN:");
		String newPIN = scanner.nextLine();
		Customer newCustomer = new Customer(newUserName, newPIN);
		customers.add(newCustomer);
		System.out.println("New User Added: " + newUserName);
	}

	public void addCar() {
		System.out.println("Enter New Car Name:");
		String carName = scanner.nextLine();
		Car newCar = new Car(carName);
		cars.add(newCar);
		System.out.println("Car added: " + carName);
	}



}
