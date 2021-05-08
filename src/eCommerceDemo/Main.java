package eCommerceDemo;

import eCommerceDemo.business.abstracts.CustomerService;
import eCommerceDemo.business.concretes.CustomerManager;
import eCommerceDemo.core.AuthenticatorAdapter;
import eCommerceDemo.core.MailManagerAdapter;
import eCommerceDemo.dataAccess.concretes.HibernateCustomerDao;
import eCommerceDemo.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomerService customerService = new  CustomerManager(new MailManagerAdapter(), new HibernateCustomerDao());
		customerService.signUp(new Customer(1,"Nurdan", "Mamuþ","nurdan@gmail.com","234k45"));
		
		CustomerService customerService1 = new  CustomerManager(new AuthenticatorAdapter(), new MailManagerAdapter(),new HibernateCustomerDao());
		customerService1.signUpWithGoogle("nurdan@gmail.com", "234k47");
		customerService1.signIn("nurdan@gmail.com", "234k47");


	}

}
