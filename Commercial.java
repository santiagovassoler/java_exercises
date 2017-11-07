package part4Step7;
import java.util.Scanner;


public abstract class Commercial extends Vehicle{
	private int payload;
	
	public Commercial()
	{
		super();
		payload = 0;
	}

	public int getPayload() {
		return payload;
	}
	public void displayDetails()
	{
		super.printDetails();
		System.out.println("load in Kg: " + payload);
	}
	
	public void readData(Scanner scanner2)
	{
		super.readData(scanner2);
		payload = scanner2.nextInt();
	}
	
}
