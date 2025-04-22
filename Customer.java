/// Customer ///

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
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
		if (CarRental.availableCars.isEmpty()) {
			System.out.println("There are no cars available to rent.");
			return;
		}
		
		System.out.println("Available Cars To Rent:");
		for (int i = 0; i < CarRental.availableCars.size(); i++) {
			Car car = CarRental.availableCars.get(i);
			if (car.getCurrentOwner().equals("lot")) {
				System.out.println((i + 1) + ") " + car.getCarName());
			}
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the car you'd like to rent:");
		int choice = scanner.nextInt();
		
		if (choice < 1 || choice > CarRental.availableCars.size()) {
			System.out.println("Invalid choice. Please try again.");
			return;
		}
		
		Car selectedCar = CarRental.availableCars.get(choice - 1);
		if (selectedCar.getCurrentOwner().equals("lot")) {
			selectedCar.rentCar(this.getUserName());
			rentedCars.add(selectedCar);
			System.out.println("You have successfully rented the " + selectedCar.getCarName());
		} else {
			System.out.println("This car is not available for rent.");
		}
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
				CarRental.availableCars.add(car);
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
	}

	public List<Car> getRentedCars() {
		return rentedCars;
	}
}
