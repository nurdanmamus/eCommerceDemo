package eCommerceDemo.jMail;

public class jMailManager {
	
	public void mailSend(String email) {
		System.out.println("Do�rulama maili ilgili mail adresine g�nderildi." + email);
	}
	
	public boolean verifySignUp() {
		System.out.println("�yelik i�leminiz tamamlanm��t�r.");
		return true;
	}

}
