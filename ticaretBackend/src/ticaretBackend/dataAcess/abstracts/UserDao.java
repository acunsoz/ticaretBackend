package ticaretBackend.dataAcess.abstracts;

import java.util.List;

import ticaretBackend.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void update(User user);
	void delete(User user);
	User get(String email);
	List<User> getAll();
	
}
