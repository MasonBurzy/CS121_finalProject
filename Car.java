/// Car ///

import java.io.Serializable;


public class Car implements Serializable {
	private String carName;
	private String currentOwner;

	public Car(String carName, String currentOwner) {
		this.carName = carName;
		this.currentOwner = "lot";
	}

	public String getCarName() {
		return carName;
	}

	public String getCurrentOwner() {
		return currentOwner;
	}

	public boolean rentCar(String customerName) {
		if (currentOwner.equals("lot")) {
			currentOwner = customerName;
			System.out.println(customerName + " has rented " + carName);
			return true;
		} else {
			System.out.println(carName + " is already rented by " + currentOwner);
			return false;
		}
	}

	public void returnCar() {
		if (!currentOwner.equals("lot")) {
			System.out.println(currentOwner + " has returned " + carName);
			currentOwner = "lot";
		} else {
			System.out.println(carName + " is already at the lot.");
		}
	}

	public void displayStatus() {
		System.out.println(carName + " is currently with " + currentOwner);
	}
}
