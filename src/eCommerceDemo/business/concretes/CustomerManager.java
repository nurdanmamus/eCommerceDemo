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
						System.out.println("Üyelik iþlemi tamamlanamamýþtýr.");
					}
					
				} else {
					System.out.println("Sisteme kayýtlý olmayan bir mail adresi giriniz.");
				}
				
			}

		} else {
			System.out.println("Tüm zorunlu alanlarý girmelisiniz.");
		}
	}

	public void signUpWithGoogle(String email, String password) {
		
		if (email != null && password != null ) {
			
			if (PublicValidator.isValidMail(email) && PublicValidator.isValidPassword(password)) {
				// Google authenticator ile üyelik yapýlýyor.
				if (authenticatorService.signUpToSystem(email, password)) {
					if (mailService.sendMail(email)) {
						mailService.verifySignUp();
					} else {
						System.out.println("Üyelik iþlemi tamamlanamamýþtýr.");
					}
				} else {
					System.out.println("Kullanýcý bilgileri hatalýdýr.");
					return;
				}
			} 
			
		} else {
			System.out.println("Tüm zorunlu alanlarý girmelisiniz.");
		}

	}

	@Override
	public void signIn(String mail, String password) {
		
		Customer customer = customerDao.getCustomer(mail, password);
		
		if (customer != null) {
			System.out.println("Sisteme giriþ yapýlmýþtýr.");
		} else {
			System.out.println("Eksik veya yanlýþ bilgi girdiniz.");
		}
				
	}

}
