package eCommerceDemo.core;

import eCommerceDemo.googleAuthenticator.GoogleAuthenticatorManager;

public class AuthenticatorAdapter implements AuthenticatorService{

	@Override
	public boolean signUpToSystem(String email, String password) {
		GoogleAuthenticatorManager googleAuthenticatorManager = new GoogleAuthenticatorManager();
		googleAuthenticatorManager.signUp(email, password);
		return true;
	}

}
