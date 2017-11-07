package part4Step7;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;

public class ReservationSystem {

	private Map<String,Vehicle> vehicleMap;
	private JFrame mainWindow;
	private Map<String,Customer> customerMap;
	private Random randomGenerator;
	private ArrayList<String> customerIDList;
	// The name of the file containing customer id only
    private static final String FILE_OF_CUSTOMER_ID = "customerID_data.txt";
    
    private Map<String,VehicleReservation> vehicleReservationMap;
	private boolean firstCallToGenerateReservationNo;
	private int lastReservationNumber;
	private String lastNumberGeneratedFileName;
	private Diary diary;
	private String dumpCustomerDataFileName;
	private String dumpVehicleReservationDataFileName;
	private String name;
	
	public ReservationSystem(String name)
	{
		this.name = name;
		vehicleMap = new HashMap<String,Vehicle>();
		customerMap = new HashMap<String,Customer>();
		mainWindow = new JFrame ("Reservation System Project");
		randomGenerator = new Random();
		customerIDList = new ArrayList<String>();
		readCustomerIdData();  // load all customer id 
		vehicleReservationMap = new HashMap<String,VehicleReservation>();
		firstCallToGenerateReservationNo = true;
		lastReservationNumber = 0;
		lastNumberGeneratedFileName = "LastNumberGenerated.txt";
		diary = new Diary();
		readVehicleData("vehicle_data_2.txt");
		dumpCustomerDataFileName = "dumpCustomerDataFile.txt";
		dumpVehicleReservationDataFileName = "dumpVehicleReservationData.txt";
	}
	
	public Diary getDiary() {
		return diary;
	}
	public String getDumpCustomerDataFileName() {
		return dumpCustomerDataFileName;
	}
	public String getDumpVehicleReservationDataFileName() {
		return dumpVehicleReservationDataFileName;
	}
	
	public Map<String, VehicleReservation> getVehicleReservationMap() {
		return vehicleReservationMap;
	}

	public boolean isFirstCallToGenerateReservationNo() {
		return firstCallToGenerateReservationNo;
	}

	public int getLastReservationNumber() {
		return lastReservationNumber;
	}

	public String getLastNumberGeneratedFileName() {
		return lastNumberGeneratedFileName;
	}
	/*
	 * @return a list of customer IDs
	 */
	public ArrayList<String> getCustomerIDList() {
		return customerIDList;
	}

	/*
	 * @return a vehicle map, vehicle id as key
	 */
	public Map<String, Vehicle> getVehicleMap() {
		return vehicleMap;
	}

	/*
	 * @return a Customer map, customer id as key
	 */
	public Map<String, Customer> getCustomerMap() {
		return customerMap;
	}
	/* if the map is not empty then search for a customer passing its id
	 * @param id customer's id
	 * @return customer or null if there is no corresponding customer 
	 */
	public Customer getCustomer(String id){
		if(!customerMap.isEmpty()){
			Customer customer = customerMap.get(id);
			if (customer != null){
				return customer;
			}else{
				return null;
			}
		}else{
			return null;	
		}
	}
	
	/* if the map is not empty then search for a vehicle passing its id
	 * @param id vehicle's id
	 * @return vehicle or null if there is no corresponding vehicle 
	 */
	public Vehicle getVehicle(String id){
		if(!vehicleMap.isEmpty()){
			Vehicle vehicle = vehicleMap.get(id);
			if (vehicle != null){
				return vehicle;
			}else{
				return null;
		    }
		}else{
				return null;
			}
	    }
	/*
	 * 
	 * add a new vehicle to the map
	 * @param vehicle new vehicle
	 */
	public void storeVehicle(Vehicle vehicle)
	{
		if(vehicleMap.containsKey(vehicle.getVehID())){
			System.out.println("cannot store vehicle, id already taken...");
		}
		else{
		vehicleMap.put(vehicle.getVehID(), vehicle);
		}
	}
	
	/*
	 * add a new customer to the map, if the 
	 * id is "unknown" then generates one unique
	 * and save it to the map
	 * @param customer new customer
	 */
	public void storeCustomer(Customer customer)
	{ 	
		if(customer.getCustomerID().equals("unknown")){
			customer.setCustomerID(generateCustomerID("AB", 6));
		}
		customerMap.put(customer.getCustomerID(), customer);
		writeCustomerID();
	}
	/*
	 * generate a unique id number
	 * @param prefix prefix of the ID
	 * @param qty number of digits
	 * @return returns string with random numbers
	 */
	private String generateID(String prefix, int qty)
	{
		String id=null;
		String noToString = "";
		 for(int a=0; a<qty; a++){
			  noToString = noToString + randomGenerator.nextInt(10);
		  }
		 id = prefix + "-" + noToString; 
		 return id;
	}
	
	/*
	 * generate an id, if it already exists
	 * then try to generate again
	 * and save it to the list
	 * @param prefix prefix of the ID
	 * @param qty number of digits
	 * @return a unique random id number
	 */
	private String generateCustomerID(String prefix, int qty)
	{
		String id = generateID(prefix, qty);
		while(customerIDList.contains(id)){
			id = generateID(prefix, qty);
		}
		 customerIDList.add(id);
		 return id;
	}
	
	/*
	 * display all customers from the customerMap
	 * if is empty show message
	 */
	public void printAllCustomers()
	{
		if(!customerMap.isEmpty()){
			for (Customer customer : customerMap.values()) {
	          customer.printDetails();
	   }
		}else{
			System.out.println("No data to show");
		}
	}

	/*
	 * display all vehicles from the customerMap
	 * if is empty show message
	 */
	public void printAllVehicles()
	{
		if (!vehicleMap.isEmpty()){
			for(Vehicle vehicle: vehicleMap.values()){
				vehicle.printDetails();
				System.out.println();
			}
		}
		else{
			System.out.println("No data to show");
		}
	}

	/*
	 * read vehicle data from a file, if the string 
	 * typeOfData is not unknown then store the 
	 * vehicle to the Map
	 */
	public void readVehicleData()
	{
		FileDialog fileDialogBox = new FileDialog(mainWindow, "open", FileDialog.LOAD);
		fileDialogBox.setDirectory(".");
		fileDialogBox.setVisible(true);
		String filePath = fileDialogBox.getDirectory();
		String fileName = fileDialogBox.getFile();
		
		if(fileName !=null){
			filePath = filePath + fileName;
			readVehicleData(filePath);
		}	
	}

	public void readVehicleData(String fileName)
	{
		String typeOfData = null;
		Scanner scanner = null;
		File inFile = new File(fileName);
		try {
			scanner = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("cancelled by the user, file not found " + e);
		}

		while (scanner.hasNextLine()){
			String lineOfText = scanner.nextLine().trim();

			if(lineOfText.startsWith("//")){}
			else if (lineOfText.isEmpty()){}

			else if (lineOfText.startsWith("[")){
				if (lineOfText.equalsIgnoreCase("[car data]")){
					typeOfData = "car data";
				}
				else if (lineOfText.equalsIgnoreCase("[van data]")){
					typeOfData = "van data";
				}
				else if (lineOfText.equalsIgnoreCase("[truck data]")){
					typeOfData = "truck data";
				}
				else{
					typeOfData = "unknown";
				}
			}
			else {
				Scanner sc = new Scanner(lineOfText);
				sc.useDelimiter(" *, *");
				Vehicle vehicle;

				if (typeOfData.equals("car data")){
					vehicle = new Car();
				}
				else if (typeOfData.equals("van data")){
					vehicle = new Van();			
				}
				else if (typeOfData.equals("truck data")){ 
					vehicle = new Truck();
				}
				else {
					vehicle = null;
				}
				if (!typeOfData.equals("unknown")){
					vehicle.readData(sc);
					storeVehicle(vehicle);
				}			
				else {
					System.out.println("unknown data");
				}

				sc.close();
			}
		}
		scanner.close();
	}
	/*
	 * read customer data from a file and store it
	 * to a Map
	 */
	public void readCustomerData()
	{
		FileDialog fileDialogBox = new FileDialog(mainWindow, "open", FileDialog.LOAD);
		fileDialogBox.setDirectory(".");
		fileDialogBox.setVisible(true);
		String filePath = fileDialogBox.getDirectory();
		String fileName = fileDialogBox.getFile();
		
		if(fileName !=null){
			filePath = filePath + fileName;
			readCustomerData(filePath);
		}	
	}
	
	public void readCustomerData(String fileName)
	{
		Scanner scanner = null;
		File inFile = new File(fileName);
		try {
			scanner = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("cancelled by the user, file not found " + e);
		}

		while (scanner.hasNextLine()){
			String lineOfText = scanner.nextLine().trim();
			if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
				Scanner sc = new Scanner(lineOfText);
				sc.useDelimiter(" *, *");
				Customer customer = new Customer();	
				customer.readData(sc);
				storeCustomer(customer);
				sc.close();
				}
		}
		scanner.close();
	}

	public void writeCustomerData(String fileName)
	{
		PrintWriter pWriter = null;
		File inFile = new File(fileName);
		try {
			pWriter = new PrintWriter(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("file not found " + e);
			e.printStackTrace();
		}
		pWriter.println("// this is a comment, any lines that start with //");
		pWriter.println("// (and blank lines) should be ignored");
		pWriter.println("");
		pWriter.println("// New customer data");
		pWriter.println("// data is customerID, surname, firstName, otherInitials, title");

		for(Customer customer: customerMap.values())
		{
			customer.writeData(pWriter);
		}
		pWriter.close();
	}
	/*
	 * write the content of the customerMap
	 * to a new file 
	 */
	public void writeCustomerData()
	{
		FileDialog fileDialogBox = new FileDialog(mainWindow, "open", FileDialog.LOAD);
		fileDialogBox.setDirectory(".");
		fileDialogBox.setVisible(true);
		String filePath = fileDialogBox.getDirectory();
		String fileName = fileDialogBox.getFile();
		
		if(fileName !=null){
			filePath = filePath + fileName;
			writeCustomerData(filePath);
		}	
	}
	
	
	
	/*
	 * read a file containing all customer id then 
	 * adds to the list 
	 */
	private void readCustomerIdData()
	{
		String path = System.getProperty("user.dir");
		Scanner scanner=null;
		try {
			 scanner = new Scanner(new File(path,FILE_OF_CUSTOMER_ID));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()){
			String lineOfText = scanner.nextLine();
			customerIDList.add(lineOfText);
			}
		scanner.close();
	}
	
	/*
	 * write all content of a customer list
	 * to a file
	 */
	private void writeCustomerID()
	{
		PrintWriter pWriter = null;
		try {
			pWriter = new PrintWriter(FILE_OF_CUSTOMER_ID);
		} catch (FileNotFoundException e) {
			System.out.println("file not found " + e);
			e.printStackTrace();
		}
		
		for(String s: customerIDList)
		{
			pWriter.write(s);
			pWriter.println();
		}
		pWriter.close();
	}
	private String generateReservationNo(int noOfDigits, String fileName)
	   {
	      
	      File reservationNoFile = new File(fileName);
	      String errorMessage = "*** Unexpected error in method generateReservationNo() ***";

	      if( firstCallToGenerateReservationNo )
	      {
	         // first call to the method since system started         
	         firstCallToGenerateReservationNo = false;      
	         if( !reservationNoFile.exists() )
	         {
	            // no action needed
	         }
	         else
	         {
	            // system has run before, retrieve lastReservationNumber from file
	            errorMessage += "\n    A null value will be returned"
	                          + "\n    Trying to read from file " + fileName;
	            try
	            {
	               Scanner scanner = new Scanner(reservationNoFile);
	               lastReservationNumber = scanner.nextInt();
	               scanner.close();
	            }
	            catch(FileNotFoundException ex)
	            {
	               errorMessage += "\n    File not found";        
	               System.err.println(errorMessage);
	               ex.printStackTrace();
	               return null;
	            }
	            catch(NoSuchElementException ex)
	            {
	               // this will also catch the subclass InputMismatchException
	               errorMessage += "\n    int value not found";        
	               System.err.println(errorMessage);
	               ex.printStackTrace();
	               return null;            
	            }
	         }
	      }

	      lastReservationNumber++;  // increment
	      
	      // write it back to the file ready for next start up of the reservation system
	      errorMessage += "\n    Trying to write to file " + fileName;
	      try
	      {
	         PrintWriter pWriter = new PrintWriter(reservationNoFile);
	         pWriter.println(lastReservationNumber);
	         pWriter.close();
	      }
	      catch(IOException ex)
	      {
	         System.err.println(errorMessage);
	         ex.printStackTrace();
	      }      
	      
	      // generate next number and pad with "0" to get correct number of digits
	      String resNo = "" + lastReservationNumber;
	      while( resNo.length()<noOfDigits )
	         resNo = "0" + resNo;
	      return resNo;
	   }
	
	
	public void storeVehicleReservation(VehicleReservation vehicleReservation)
	{
		vehicleReservationMap.put(vehicleReservation.getReservationNo(), vehicleReservation);
		diary.addReservation(vehicleReservation);
	}
	
	// return vehicle reserved by its id number
	public VehicleReservation getVehicleReservation(String resNo)
	{
		if(!vehicleReservationMap.isEmpty()){
			VehicleReservation vehicleReservation = vehicleReservationMap.get(resNo);
			if (vehicleReservation != null){
				return vehicleReservation;
			}else{
				return null;
			}
		}else{
			return null;	
		}
	}
	
	public boolean makeVehicleReservation(String customerID, String vehID, String startDate, int noOfDays)
	{
		boolean success;
		if(!customerIDList.contains(customerID)){
			System.out.println("Sorry, customer ID not found...");
			success = false;
		}
		else if (!vehicleMap.containsKey(vehID)){
			System.out.println("Sorry, vehicle id not found...");
			success = false;
		}
		else if(!DateUtil.isValidDateString(startDate)) {
			System.out.println("Plese insert a valid date (dd-MM-YYYY)");
			success = false;
		}
		else if(noOfDays < 0){
			System.out.println("Number of days should be more then 0...");
			success = false;
		}
		else if(diary.getReservations(DateUtil.convertStringToDate(startDate)) != null){
			System.out.println("Sorry, vehicle already reserved for this date...");
			success = false;
		}
		else {
			String reservationNo = generateReservationNo(6, lastNumberGeneratedFileName);
			VehicleReservation vehicleReservation = new VehicleReservation(reservationNo, vehID, customerID, startDate, noOfDays);
			storeVehicleReservation(vehicleReservation);
			success = true;
		}
		return success;
}
		
		
	/*	if(customerIDList.contains(customerID) 
				
				
				&& vehicleMap.containsKey(vehID) 
				&& DateUtil.isValidDateString(startDate) && noOfDays > 0){
			
			if (diary.getReservations(DateUtil.convertStringToDate(startDate)) == null) {
				String reservationNo = generateReservationNo(6, lastNumberGeneratedFileName);
				VehicleReservation vehicleReservation = new VehicleReservation(reservationNo, vehID, customerID, startDate, noOfDays);
				storeVehicleReservation(vehicleReservation);
			
				return true;
			}
		}
		
		System.out.println("Sorry, something went wrong. We couldn't make your reservation, please try again...");
		return false;
		*/
	
	
	public void printAllVehicleReservations(){
		if (!vehicleReservationMap.isEmpty()){
			for(VehicleReservation vehicleReservation: vehicleReservationMap.values()){
				vehicleReservation.printDetails();
			}
		}
		else{
			System.out.println("No data to show");
		}
	}
	public void writeVehicleReservationData(String fileName)
	{
		PrintWriter pWriter = null;
		File inFile = new File(fileName);
		try {
			pWriter = new PrintWriter(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("file not found " + e);
			e.printStackTrace();
		}
		pWriter.println("// this is a comment, any lines that start with //");
		pWriter.println("// (and blank lines) should be ignored");
		pWriter.println("");
		pWriter.println("// New vehicle reservation data");
		pWriter.println("// data is reservationNo, vehID , customerID , startDate, noOfDays)");

		for(VehicleReservation veh: vehicleReservationMap.values())
		{
			veh.writeData(pWriter);
		}
		pWriter.close();
	}
	public void writeVehicleReservationData()
	{
		FileDialog fileDialogBox = new FileDialog(mainWindow, "open", FileDialog.LOAD);
		fileDialogBox.setDirectory(".");
		fileDialogBox.setVisible(true);
		String filePath = fileDialogBox.getDirectory();
		String fileName = fileDialogBox.getFile();
		
		if(fileName !=null){
			filePath = filePath + fileName;
			writeVehicleReservationData(filePath);
		}	
	}
	
	public void readVehicleReservationData()
	{
		
		FileDialog fileDialogBox = new FileDialog(mainWindow, "open", FileDialog.LOAD);
		fileDialogBox.setDirectory(".");
		fileDialogBox.setVisible(true);
		String filePath = fileDialogBox.getDirectory();
		String fileName = fileDialogBox.getFile();
		
		if(fileName !=null){
			filePath = filePath + fileName;
			readVehicleReservationData(filePath);
		}	
	}
	
	
	public void readVehicleReservationData(String fileName)
	{
		Scanner scanner = null;
		File inFile = new File(fileName);
		try {
			scanner = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("cancelled by the user, file not found " + e);
		}

		while (scanner.hasNextLine()){
			String lineOfText = scanner.nextLine().trim();
			if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
				Scanner sc = new Scanner(lineOfText);
				sc.useDelimiter(" *, *");
				VehicleReservation vehicleReservation = new VehicleReservation();	
				vehicleReservation.readData(sc);
				storeVehicleReservation(vehicleReservation);
				sc.close();
				}
		}
		scanner.close();
	}
	
	
	public void printDiaryEntries(Date startDate, Date endDate)
	{
		diary.printEntries(startDate,endDate);
	}
	
	public void deleteVehicleReservation(String reservationNo)
	{
		if(!vehicleReservationMap.isEmpty() && vehicleReservationMap.containsKey(reservationNo)){
			vehicleReservationMap.remove(reservationNo);
		}
		else{
			System.out.println("Reservation number not found...");
		}
	}
	
	public void closeDownSystem()
	{
		writeCustomerData(dumpCustomerDataFileName);
		writeVehicleReservationData(dumpVehicleReservationDataFileName);
	}
	
	public void reloadSystem()
	{
		readCustomerData(dumpCustomerDataFileName);
		readVehicleReservationData(dumpVehicleReservationDataFileName);
	}
	
	public int getNumberOfVehicles()
	{
		return vehicleMap.size();
	}
	public int getNumberOfCustomers()
	{
		return customerMap.size();
	}
	
	public int getNumberOfVehicleReservations()
	{
		return vehicleReservationMap.size();
	}
}

	
