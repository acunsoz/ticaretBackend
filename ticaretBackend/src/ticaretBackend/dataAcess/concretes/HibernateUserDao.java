package ticaretBackend.dataAcess.concretes;

import java.util.ArrayList;
import java.util.List;

import ticaretBackend.dataAcess.abstracts.UserDao;
import ticaretBackend.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	private List<User> users;
	
	public HibernateUserDao() {
		this.users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		this.users.add(user);
		System.out.println("Hibernate ile eklendi : "+user.getFirstName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile güncellendi : " + user.getFirstName());
		
	}

	@Override
	public void delete(User user) {
		this.users.remove(user);
		System.out.println(user.getFirstName() +" adlý kullanýcý Hibarnate silindi");
		
	}

	@Override
	public User get(String email) {
		for(User user1:users) {
			if(user1.getEmail()==email) {
				return user1;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return this.users;
	}

}
