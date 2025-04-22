/// Admin ///

import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Admin extends User {
	private static final Scanner scanner = new Scanner(System.in);

	public Admin(String userName, String PIN) {
		super(userName, PIN);
	}

	public String menu() {
		System.out.println("0) Exit This Menu\n 1) Full Customer Report\n 2) Add User\n 3) Add Car\n 4) Remove Car");
		return scanner.nextLine();
	}

	public void start() {
		System.out.println("Login Successful.");
		while (true) {
			String choice = menu();
			if (choice.equals("0")) {
				System.out.println("Exiting Admin Menu...");
				break;
			} else if (choice.equals("1")) {
				System.out.println(getReport());
			} else if (choice.equals("2")) {
				addUser();
			} else if (choice.equals("3")) {
				addCar();
			} else if (choice.equals("4")) {
				removeCar();
			} else {
				System.out.println("Invalid option, please try again.");
			}
		}
	}

	public String getReport() {
		StringBuilder report = new StringBuilder("Customer Report:\n");
		
		for (Customer customer : CarRental.customers) {
			report.append("Username: ").append(customer.getUserName()).append(", PIN: ").append(customer.getPIN()).append("\n");

			List<Car> rented = customer.getRentedCars();

			if (rented.size() > 0) {
				report.append("Rented Cars: ");
				for (Car car : rented) {
					report.append(car.getCarName()).append(" ");
				}
				report.append("\n");
			} else {
				report.append("No cars rented. \n");
			}
		}

		return report.toString();
	}

	public void addUser() {
		System.out.println("Enter New Username:");
		String newUserName = scanner.nextLine();
		System.out.println("Enter new PIN:");
		String newPIN = scanner.nextLine();
		Customer newCustomer = new Customer(newUserName, newPIN);
		CarRental.customers.add(newCustomer);
		System.out.println("New User Added: " + newUserName);
	}

	public void addCar() {
		System.out.println("Enter New Car Name:");
		String carName = scanner.nextLine();
		Car newCar = new Car(carName);
		CarRental.availableCars.add(newCar);
		System.out.println("Car added: " + carName);
	}

	public void removeCar() {
		if (CarRental.availableCars.isEmpty()) {
			System.out.println("No cars available to remove.");
			return;
		}

		System.out.println("Enter the name of the car to remove:");
		String carName = scanner.nextLine();

		for (Car car : CarRental.availableCars) {
			if (car.getCarName().equals(carName)) {
				CarRental.availableCars.remove(car);
				System.out.println("Car removed: " + carName);
				return;
			}
		}

		System.out.println("Car not found: " + carName);
	}

}
