package eCommerceDemo.dataAccess.abstracts;

import java.util.List;

import eCommerceDemo.entities.concretes.Customer;

public interface CustomerDao {
	
	void add(Customer customer);
	
	List<Customer> getAll();
	
	boolean existsMail(String email);
	
	Customer getCustomer(String email,String password);
	
	Customer getCustomer(String email);
	
	
	

}
