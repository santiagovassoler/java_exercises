 package part4Step7;



public class Test {

	public Test() {
		// Part 1 Step 1 creating 3 objects
		//Vehicle vehicle = new Vehicle("A3", "JY-5623", "GF09RTY", "Ford");
		//Vehicle vehicle2 = new Vehicle("A2", "JY-5624", "GF09UYH", "Fiat");
		//Vehicle vehicle3 = new Vehicle("A1", "JY-8976", "GF09PPP", "Honda");
		
		// displaying details from each object
		//vehicle.displayDetails();
		//vehicle2.displayDetails();
		//vehicle3.displayDetails();
		
		
		
		//  Part 1 Step 2,3,4 creating ReservationSystem object
		ReservationSystem res = new ReservationSystem("");
		//  reading file vehicle_data_1.txt for step 2,3 and vehicle_data_2.txt for step 4
		//res.readVehicleData();
		
		// Part 2 Step 4 printing all data from Car, Van and Truck object
		//res.displayAllVehicles();
		
		//  Part 3 Step 1 Creating customer object
		//Customer customer = new Customer("Roberts", "John" , "T" , "Mr");
		//  adding to the list of customers
		//res.storeCustomer(customer);
		//  displaying the single customer
		//res.displayAllCustomers();
		//  reading data from file customer_data.txt
		//res.readCustomerData();
		//  displaying all 5 customers
		//res.displayAllCustomers();
		
		
	    //  Part 3 Step 2 read customer data from the file customer_data.txt
	    //res.readCustomerData();
		//  add a new Customer 
		//res.storeCustomer(new Customer("Vassoler", "Santiago" , "D" , "Mr"));
		//   write the new Customer to a new file new_customer_data.txt
		//res.writeCustomerData();
		//   create a new ReservationSystem object
		//ReservationSystem res2 = new ReservationSystem();
		//   read customer data from the file new_customer_data.txt
		//res2.readCustomerData();
		//   display all the five customers
		//res2.displayAllCustomers();
			
			
		 //  Part 3 Step 3 allocating customer id numbers
		//  store new customer using 4 parameters then display it 
		//res.displayAllCustomers();
		//res.displayAllCustomers();
			
		
		//  Part 3 Step 4 generating unique id numbers using a private method 
		//  display id generated and stored at customer id list
		//System.out.println(res.getCustomerIDList());
		
		
		//  Part 3 Step 5 read file line 39, re-start the system & create customer line 41
		//  then display all customer 
		//  uncomment line 53
		
		
		
		//  Part 3 Step 6 returning customer and vehicle passing ID as a parameter
		// new_customer_data.tx
		//res.readCustomerData();
		//vehicle_data_2.txt
		//res.readVehicleData();
		
		//System.out.println("--- Customer ----");
		//res.getCustomer("AB-650739").displayDetails();
		//System.out.println();
		//System.out.println("--- Vehicle ---");
		//res.getVehicle("GH-68135").displayDetails();
		
		// Part 4 Step 1   print out the number of days between two dates
		//Date date1 = DateUtil.convertStringToDate("04-05-2016");
		//Date date2 = DateUtil.incrementDate(date1, 15);
		//System.out.println(DateUtil.convertDateToLongString(date2));
		
		// Part 4 Step 2  read vehicle data, make 3 reservations, 
		//write to a file, read this file and display all reservations
		//res.makeVehicleReservation("AB-068544", "JK-60163", "05-05-2016", 10);
		//res.makeVehicleReservation("AB-530521", "GH-68135", "07-10-2016", 20);
		//res.makeVehicleReservation("AB-387507", "TF-61854", "09-12-2016", 40);
		//res.writeVehicleReservationData();
		//res.readVehicleReservationData();
		//res.printAllVehicleReservations();
		
		// Part 4 Step 3 test if is possible to make a reservation if the vehicle is already reserved for 
		// all or part of the reservation period.
		// first same day
		//res.makeVehicleReservation("AB-387507", "JK-60163", "10-09-2016", 10);
		// then part of
		//res.makeVehicleReservation("AB-387507", "JK-60163", "15-09-2016", 4);
		//res.writeVehicleReservationData();
		//res.printAllVehicleReservations();
		
		
		//  Part 4 Step 4
		//  system loads automatically data from vehicle_data_2.txt
		//  save customer and make reservation without having to choose a file name
		//res.reloadSystem();
		//res.storeCustomer(new Customer("Ford", "Bill", "WH", "Mr"));
		//res.writeCustomerData("new_customer_data.txt");
		//res.makeVehicleReservation("AB-602343", "TF-61854", "09-02-2016", 11);
		//res.writeVehicleReservationData("vehicle_reservation_data.txt");
		//res.closeDownSystem();
		//   display customers and reservations after reloading the system
		res.reloadSystem();
		res.printAllCustomers();
		res.printAllVehicleReservations();
	}
} 
