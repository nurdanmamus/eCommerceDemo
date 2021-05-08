package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.CustomerService;
import eCommerceDemo.core.AuthenticatorService;
import eCommerceDemo.core.MailService;
import eCommerceDemo.dataAccess.abstracts.CustomerDao;
import eCommerceDemo.entities.concretes.Customer;

public class CustomerManager implements CustomerService {

	private AuthenticatorService authenticatorService;
	private MailService mailService;
	private CustomerDao customerDao;

	public CustomerManager(MailService mailService, CustomerDao customerDao) {
		super();
		this.mailService = mailService;
		this.customerDao = customerDao;
	}

	public CustomerManager(AuthenticatorService authenticatorService, MailService mailService,
			CustomerDao customerDao) {
		super();
		this.authenticatorService = authenticatorService;
		this.mailService = mailService;
		this.customerDao = customerDao;
	}

	@Override
	public void signUp(Customer customer) {

		if (customer.getFirstName() != null && customer.getLastName() != null && customer.geteMail() != null
				&& customer.getPassword() != null) {

			if (PublicValidator.isValidName(customer.getFirstName())
					&& PublicValidator.isValidName(customer.getLastName())
					&& PublicValidator.isValidPassword(customer.getPassword())
					&& PublicValidator.isValidMail(customer.geteMail())) {
				
				
				Customer result = customerDao.getCustomer(customer.geteMail());
				
				if (result == null) {
					
					if (mailService.sendMail(customer.geteMail())) {
						if (mailService.verifySignUp()) {
							customerDao.add(customer);
						}
					} else {
						System.out.println("�yelik i�lemi tamamlanamam��t�r.");
					}
					
				} else {
					System.out.println("Sisteme kay�tl� olmayan bir mail adresi giriniz.");
				}
				
			}

		} else {
			System.out.println("T�m zorunlu alanlar� girmelisiniz.");
		}
	}

	public void signUpWithGoogle(String email, String password) {
		
		if (email != null && password != null ) {
			
			if (PublicValidator.isValidMail(email) && PublicValidator.isValidPassword(password)) {
				// Google authenticator ile �yelik yap�l�yor.
				if (authenticatorService.signUpToSystem(email, password)) {
					if (mailService.sendMail(email)) {
						mailService.verifySignUp();
					} else {
						System.out.println("�yelik i�lemi tamamlanamam��t�r.");
					}
				} else {
					System.out.println("Kullan�c� bilgileri hatal�d�r.");
					return;
				}
			} 
			
		} else {
			System.out.println("T�m zorunlu alanlar� girmelisiniz.");
		}

	}

	@Override
	public void signIn(String mail, String password) {
		
		Customer customer = customerDao.getCustomer(mail, password);
		
		if (customer != null) {
			System.out.println("Sisteme giri� yap�lm��t�r.");
		} else {
			System.out.println("Eksik veya yanl�� bilgi girdiniz.");
		}
				
	}

}
