package ticaretBackend.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ticaretBackend.business.abstracts.AuthentactionService;

public class AuthentactionManager implements AuthentactionService{

	@Override
	public boolean emailCheck(String email) {
		
		String regex="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher =pattern.matcher(email);
		
		if(matcher.matches()) {
			return true;
		}
		else if(email.isEmpty()) {
			System.out.println("Email bo� b�rak�lamaz");
			return false;
		}
		else {
			System.out.println("Gecersiz email adresi");
			return false;
		}
		
	}

	@Override
	public boolean nameCheck(String firstName, String lastName) {
		if(firstName.length()<2) {
			System.out.println("Ad en az iki karakterden olu�mal�d�r");
			return false;
		}
		else if(lastName.length()<2) {
			System.out.println("Soyad en az iki karakterden olu�mal�d�r");
			return false;
		}
		return true;
		
	}

	@Override
	public boolean passwordCheck(String password) {
		if(password.length()<=6) {
			System.out.println("�ifre en az 6 karakterden olu�mal�d�r");
			return false;
			
		}
		return true;
		
	}

}
