package eCommerceDemo.core;

import eCommerceDemo.jMail.jMailManager;

public class MailManagerAdapter implements MailService{

	@Override
	public boolean sendMail(String mail) {
		jMailManager mailManager = new jMailManager();
		mailManager.mailSend(mail);
		return true;
	}

	@Override
	public boolean verifySignUp() {
		jMailManager mailManager = new jMailManager();
		mailManager.verifySignUp();
		return true;
	}
	
	

}
