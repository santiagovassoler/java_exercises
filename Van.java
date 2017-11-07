package part4Step7;
import java.util.Scanner;


public class Van extends Commercial{
	private double loadVolume;
	private boolean slidingSideDoor;
	
	public Van()
	{
		super();
		loadVolume = 0;
		slidingSideDoor = false ;
	}

	public double getLoadVolume() {
		return loadVolume;
	}

	public boolean isSlidingSideDoor() {
		return slidingSideDoor;
	}
	
	private String toStringYesNo(boolean boo)
	{
		return boo ? "Yes" : "No";
	}
	
	public void displayDetails()
	{
		super.displayDetails();
		System.out.println("load Volume: " + loadVolume + "   Sliding door: " + toStringYesNo(slidingSideDoor));
		System.out.println();
	}
	
	public void readData(Scanner scanner2)
	{
		super.readData(scanner2);
		loadVolume = scanner2.nextDouble();
		String yesNo = scanner2.next();
		slidingSideDoor = yesNo.toLowerCase().equals("yes");
	}

}
