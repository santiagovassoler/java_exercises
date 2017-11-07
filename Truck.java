package part4Step7;
import java.util.ArrayList;
import java.util.Scanner;


public class Truck extends Commercial {
	private ArrayList<String> attributes;
	
	public Truck()
	{
		super();
		attributes = new ArrayList<String>();
	}

	public ArrayList<String> getAttributes() {
		return attributes;
	}
	
	public void storeAttributes(String attribute)
	{
	    attributes.add(attribute);
	}
	
	public void displayAttributes()
	{
		if (!attributes.isEmpty()){
			for(String a: attributes){
				System.out.println("Features: "+ a);
			}
		}
	}
	
	public void displayDetails()
	{
		super.displayDetails();
		displayAttributes();
		System.out.println();
	}
	
	public void readData(Scanner scanner2)
	{
		super.readData(scanner2);
		while (scanner2.hasNext()){
			String att = scanner2.nextLine();
			storeAttributes(att);
		}
		
	}
}
