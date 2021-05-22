package ticaretBackend;

import ticaretBackend.business.abstracts.UserService;
import ticaretBackend.business.concretes.AuthentactionManager;
import ticaretBackend.business.concretes.UserManager;
import ticaretBackend.core.RegisterManagerAdapter;
import ticaretBackend.dataAcess.concretes.HibernateUserDao;
import ticaretBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao(), new AuthentactionManager(),new RegisterManagerAdapter());
		
		User user1 =new User(1,"a","karýs","ksa54546@gmail.com","125467");
		userService.register(user1);
		System.out.println("---------------------------");
		
		User user2 =new User(2,"ali vefa","karýs","es888@gmail.com","125467");
		userService.register(user2);
		System.out.println("---------------------------");
		
		User user3 =new User(3,"alihan","karýs","sgsd46@gmail.com","1245447");
		userService.register(user3);
		userService.login(user3.getEmail(),user3.getPassword());
		
		System.out.println("---------------------------");
		System.out.println("Google simulator");
		User user4 =new User(4,"ahmet","karýs","ssdfs4@gmail.com","12adsa7");
		userService.registerToGoogle(user4.getFirstName());
		
		System.out.println("---------------------------");
		
		User user5 =new User(3,"alihan","karýs","sgsd46@gmail.com","1245447");
		userService.register(user5);
		
		
		
		
		
		
		
	}

}
