package ticaretBackend.business.abstracts;

import ticaretBackend.entities.concretes.User;

public interface UserService {
	
	void register (User user);
	void login(String email,String password);
	void registerToGoogle(String firstName);
	
	
}
