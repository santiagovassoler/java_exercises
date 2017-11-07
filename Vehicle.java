package part4Step7;
import java.util.Scanner;


public abstract class Vehicle {
	
	private String group;
	private String vehID;
	private String regNo;
	private String make;
	private String model;
	private boolean airCon;
	private double engineSize;
	private String fuelType;
	private String gearbox;
	private String transmission;
	private int mileage;
	private String dateFirstRegistered;
	
	public Vehicle()
	{
		group=null;
		vehID=null;
		regNo=null;
		make=null;
		model = null;
		airCon = false;
		engineSize = 0;
		fuelType = null;
		gearbox = null;
		transmission = null;
		mileage = 0;
	    dateFirstRegistered = null;
	}

	public String getGroup() {
		return group;
	}

	public String getVehID() {
		return vehID;
	}

	public String getRegNo() {
		return regNo;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public boolean isAirCon() {
		return airCon;
	}

	public double getEngineSize() {
		return engineSize;
	}

	public String getFuelType() {
		return fuelType;
	}

	public String getGearbox() {
		return gearbox;
	}

	public String getTransmission() {
		return transmission;
	}

	public int getMileage() {
		return mileage;
	}

	public String getDateFirstRegistered() {
		return dateFirstRegistered;
	}
	
	private String toStringYesNo(boolean boo)
	{
		return boo ? "Yes" : "No";
	}
	
	public void printDetails()
	{
		System.out.println(make + " " + model + "   Group: " + group + "   Vehicle Id: " + vehID );
		System.out.println("Air conditioning/Climate Control: " + toStringYesNo(airCon));
		System.out.println("Engine Size: " + engineSize + "   Fuel:" + fuelType);
		System.out.println("Gearbox: "+ gearbox + "   Transmission: " + transmission);
		System.out.println("Mileage: "+ mileage + "   Date first registered: " + dateFirstRegistered );
	}
		
	public void readData(Scanner scanner)
	{
	   group = scanner.next();
	   vehID = scanner.next();
	   regNo = scanner.next();
	   make = scanner.next();
	   model = scanner.next();  
	   String yesNo = scanner.next();
	   airCon = yesNo.toLowerCase().equals("yes");
	   engineSize = scanner.nextDouble();
	   fuelType = scanner.next();
	   gearbox = scanner.next();
	   transmission = scanner.next();
	   mileage = scanner.nextInt();
	   dateFirstRegistered = scanner.next();
	}

}
