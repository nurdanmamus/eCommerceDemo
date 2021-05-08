package eCommerceDemo.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class PublicValidator {
		
		static {
//			System.out.println("Statik Yap�c� blok �al��t�.");
		}
		
		public PublicValidator() {
//			System.out.println("Yap�c� blok �al��t�.");
		}

		public static boolean isValidPassword(String password) {
			if (password.length() >= 6) {
				return true;
			} else {
				System.out.println("Parola 6 haneden b�y�k olmal�d�r.");
				return false;
			}
		}

		public static boolean isValidName(String name) {
			if (name.length() > 2) {
				return true;
			} else {
				System.out.println("Ad ve soyad iki haneden b�y�k olmal�d�r.");
				return false;
			}

		}

		public static boolean isValidMail(String mail) {

			String regex = "^(.+)@(.+)$";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(mail);

			if (matcher.matches()) {
				return true;
			} else {
				System.out.println("Mail format� hatal�d�r.");
				return false;
			}
		}

	}

