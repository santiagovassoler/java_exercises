package part4Step7;
import java.util.Scanner;


public class Car extends Vehicle {
	
	private String bodyType;
	private int noOfDoors;
	private int noOfSeats;
	
	public Car()
	{
		super();
	}

	public String getBodyType() {
		return bodyType;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}
	
	public void displayDetails()
	{
		super.printDetails();
		System.out.println("Body type: " + bodyType + "   Doors: " + noOfDoors + "   Seats: " + noOfSeats);
		System.out.println();
	}
	
	public void readData(Scanner scanner)
	{
		super.readData(scanner);
		bodyType = scanner.next();
		noOfDoors = scanner.nextInt();
		noOfSeats = scanner.nextInt();
	}

}
