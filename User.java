/// User ///

import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements HasMenu, Serializable {
	private String userName;
	private String PIN;

	public User(String userName, String PIN) {
		this.userName = userName;
		this.PIN = PIN;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String PIN) {
		this.PIN = PIN;
	}

	public boolean login(String userName, String PIN) {
		if (this.userName.equals(userName) && this.PIN.equals(PIN)) {
			return true;
		} else {
			return false;
		}
	}

	public abstract void start();
	public abstract String menu();

}
