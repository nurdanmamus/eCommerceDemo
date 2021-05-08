package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.Customer;

public interface CustomerService {
	void signUp(Customer customer);
	
	void signUpWithGoogle(String email, String password);
	
	void signIn(String mail, String password);

}
