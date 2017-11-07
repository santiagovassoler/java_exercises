package part4Step7;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class VehicleReservation {
	
	private String reservationNo;
	private String vehID;
	private String customerID;
	private Date startDate;
	private int noOfDays;
	
	
	public VehicleReservation(String reservationNo, String vehID, String customerID, String startDate, int noOfDays)
	{
		this.reservationNo = reservationNo;
		this.vehID = vehID;
		this.customerID = customerID;
		this.startDate = DateUtil.convertStringToDate(startDate);
		this.noOfDays = noOfDays;
	}
	public VehicleReservation(){
	}

	public String getReservationNo() {
		return reservationNo;
	}

	public String getVehID() {
		return vehID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public int getNoOfDays() {
		return noOfDays;
	}
	
	public void printDetails()
	{
		System.out.println(reservationNo + ", "+ vehID + ", " + customerID + ", " + DateUtil.convertDateToShortString(startDate) + ", " + noOfDays);
	}
	
	public void readData(Scanner scanner)
	{
		reservationNo = scanner.next();
		vehID = scanner.next();
		customerID = scanner.next();
		startDate = DateUtil.convertStringToDate(scanner.next());
		noOfDays =  scanner.nextInt();
		
	}
	public void writeData(PrintWriter writer)
	{
		writer.println(reservationNo + ", "+ vehID + ", " + customerID + ", " + DateUtil.convertDateToShortString(startDate) + ", " + noOfDays);
	}
	@Override
	public String toString() {
		return "reservationNo= " + reservationNo + ", vehID= " + vehID + ", customerID= " + customerID
				+ ", startDate= " + startDate + ", noOfDays= " + noOfDays;
	}
	
	
}
