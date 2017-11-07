package part4Step7;
import static org.junit.Assert.*;
import org.junit.Test;

	public class ReservationSystemTest {
		ReservationSystem r;

	public ReservationSystemTest() {
		r = new ReservationSystem("");
		r.readCustomerData("dumpCustomerDataFile.txt");
		r.writeCustomerData("new_customer_data.txt");
	}
	
	@Test
	public void getCustomer()
	{
		assertNotNull(r.getCustomer("AB-436671"));
	}
	@Test
	public void testStoreCustomer()
	{
		Customer c = new Customer("A","A","A","A");
		c.setCustomerID("AB-111111");
		r.storeCustomer(c);
		assertEquals(r.getCustomer("AB-111111"), c);
	}

	@Test
	public void testGetNumberOfCustomers()
	{
		assertEquals(3,r.getNumberOfCustomers());
	}
	
	@Test
	public void testReadCustomerData()
	{
		r.readCustomerData("new_customer_data.txt");
		ReservationSystem re = new ReservationSystem("");
		re.readCustomerData("new_customer_data.txt");
		assertEquals(re.getNumberOfCustomers(), r.getNumberOfCustomers());
	}
	
	@Test
	public void testWriteCustomerData()
	{
		
		r.writeCustomerData("new_customer_data.txt");
		ReservationSystem re = new ReservationSystem("");
		re.readCustomerData("new_customer_data.txt");
		re.writeCustomerData("new_customer_data.txt");
		assertEquals(re.getNumberOfCustomers(),r.getNumberOfCustomers());
	}
}
