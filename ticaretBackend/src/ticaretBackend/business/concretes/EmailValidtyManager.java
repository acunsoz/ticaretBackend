package ticaretBackend.business.concretes;

import ticaretBackend.business.abstracts.EmailValidtyService;
import ticaretBackend.dataAcess.abstracts.UserDao;
import ticaretBackend.entities.concretes.User;

public class EmailValidtyManager implements EmailValidtyService{
	
	private UserDao userDao;
	
	public EmailValidtyManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public boolean isValid(String email) {
		
		for(User user : userDao.getAll()) {
			if(email.equals(user.getEmail())) {
				System.out.println("Sistemde zaten bu e posta var");
				return false;
			}
		}
		return true;
		
	}

}
