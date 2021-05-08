package eCommerceDemo.dataAccess.concretes;

import java.util.List;

import eCommerceDemo.dataAccess.abstracts.CustomerDao;
import eCommerceDemo.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {

	@Override
	public void add(Customer customer) {
		System.out.println("Kullanýcý kayýt edildi. :" + customer.getFirstName() + customer.getLastName());

	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsMail(String email) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Customer getCustomer(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(String email) {
		// TODO Auto-generated method stub
		return null;
	}



}
