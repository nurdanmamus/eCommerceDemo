package eCommerceDemo.jMail;

public class jMailManager {
	
	public void mailSend(String email) {
		System.out.println("Doðrulama maili ilgili mail adresine gönderildi." + email);
	}
	
	public boolean verifySignUp() {
		System.out.println("Üyelik iþleminiz tamamlanmýþtýr.");
		return true;
	}

}
