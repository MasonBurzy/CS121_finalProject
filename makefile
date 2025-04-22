CarRental.class: CarRental.java Admin.class Customer.class User.class Car.class HasMenu.class
	javac -g CarRental.java

Admin.class: Admin.java User.class
	javac -g Admin.java

Customer.class: Customer.java User.class
	javac -g Customer.java

User.class: User.java HasMenu.class
	javac -g User.java

Car.class: Car.java
	javac -g Car.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

Main.class: Main.java Admin.class Customer.class User.class Car.class HasMenu.class
	javac -g Main.java

run: Main.class
	java Main

clean:
	rm *.class
