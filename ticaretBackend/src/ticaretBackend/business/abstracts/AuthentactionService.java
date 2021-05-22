package ticaretBackend.business.abstracts;

public interface AuthentactionService {
	
	boolean emailCheck(String email);
	boolean nameCheck(String firstName,String lastName);
	boolean passwordCheck(String password);
	
}
