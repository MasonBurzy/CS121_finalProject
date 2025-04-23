/// Customer ///

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User implements Serializable {
	private List<Car> rentedCars;

	public Customer(String userName, String PIN) {
		super(userName, PIN);
		rentedCars = new ArrayList<>();
	}

	public String menu() {
		System.out.println("0) Exit Menu\n1) Rent A Car\n2) Return A Car\n 3) Change PIN");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public void start() {
		System.out.println("Successful Customer Log In.");

		while (true) {
                        String choice = menu();
                        if (choice.equals("0")) {
                                System.out.println("Exiting Customer Menu...");
                                break;
                        } else if (choice.equals("1")) {
                                rentCar();
                        } else if (choice.equals("2")) {
                                returnCar();
                        } else if (choice.equals("3")) {
                                changePIN();
                        } else {
                                System.out.println("Invalid option, please try again.");
                        }
                }
	}

	public void rentCar() {
		List<Car> availableCars = new ArrayList<>();
		for (Car car : CarRental.availableCars) {
			if (car.getCurrentOwner().equals("lot")) {
				availableCars.add(car);
			}
		}


		if (availableCars.isEmpty()) {
			System.out.println("There are no cars available to rent.");
			return;
		}
		
		System.out.println("Available Cars To Rent:");
		for (int i = 0; i < availableCars.size(); i++) {
			System.out.println((i + 1) + ") " + availableCars.get(i).getCarName());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of the car you'd like to rent:");
		
		if (!scanner.hasNextInt()) {
			System.out.println("Invalid input. Please enter a number.");
			return;
		}
		
		int choice = scanner.nextInt();
		
		if (choice < 1 || choice > availableCars.size()) {
			System.out.println("Invalid choice. Please try again.");
			return;
		}


		Car selectedCar = availableCars.get(choice - 1);
		selectedCar.rentCar(this.getUserName());
		rentedCars.add(selectedCar);
		System.out.println("You have successfully rented the " + selectedCar.getCarName());
	}

	public void returnCar() {
		Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the name of the car you'd like to return:");

                String carName = scanner.nextLine();

                boolean foundCar = false;
                for (Car car : rentedCars) {
			if (car.getCarName().equals(carName) && car.getCurrentOwner().equals(this.getUserName())) {
                        	car.returnCar();
				rentedCars.remove(car);
                                foundCar = true;
                                break;
                        }
                }

                if (!foundCar) {
                        System.out.println("You have not rented this car or the car is not available for return.");
		} else {
			System.out.println("Car successfully returned.");
		}
	}

	public void changePIN() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter new PIN: ");
		String newPIN = scanner.nextLine();
		setPIN(newPIN);
		System.out.println("PIN changed successfully.");
	
		CarRental.saveCustomers();
	}

	public List<Car> getRentedCars() {
		return rentedCars;
	}
}
