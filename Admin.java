/// Admin ///

import java.io.Serializable;
import java.util.Scanner;

public class Admin extends User {
	private static final Scanner scanner = new Scanner(System.in);

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
		return "Admin Report Data: ...";
	}

}
