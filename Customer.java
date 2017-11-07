package part4Step7;
import java.io.PrintWriter;
import java.util.Scanner;


public class Customer {
	private String customerID;
	private String surname;
	private String firstName;
	private String otherInitials;
	private String title;
	
	public Customer(String surname, String firstName, String otherInitials, String title )
	{
		this.customerID = "unknown";
		this.surname = surname;
		this.firstName = firstName;
		this.otherInitials = otherInitials;
		this.title = title;
	}
	
	public Customer()
	{
		customerID = null;
		surname = null;
		firstName = null;
		otherInitials = null;
		title = null;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getSurname() {
		return surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getOtherInitials() {
		return otherInitials;
	}

	public String getTitle() {
		return title;
	}
	
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public void printDetails()
	{
		System.out.println(customerID +", "+ title + " " + surname + ", " + firstName + ", " + otherInitials);
	}
	
	public void readData(Scanner scanner)
	{
		customerID = scanner.next();
		surname = scanner.next();
		firstName = scanner.next();
		otherInitials = scanner.next();
		title = scanner.next();
	}
	
	public void writeData(PrintWriter writer)
	{
		writer.println(customerID + ", "+ surname +  ", " + firstName + ", " + otherInitials + ", " + title);
	}
}
