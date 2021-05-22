package ticaretBackend.business.concretes;



import ticaretBackend.business.abstracts.AuthentactionService;
import ticaretBackend.business.abstracts.EmailValidtyService;
import ticaretBackend.business.abstracts.UserService;
import ticaretBackend.core.RegisterService;
import ticaretBackend.dataAcess.abstracts.UserDao;
import ticaretBackend.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private AuthentactionService authentactionService;
	private RegisterService registerService;

	public UserManager(UserDao userDao,AuthentactionService authentactionService,RegisterService registerService) {
		super();
		this.userDao = userDao;
		this.authentactionService = authentactionService;
		this.registerService=registerService;
	}

	@Override
	public void register(User user) {
		EmailValidtyService emaiValid = new EmailValidtyManager(userDao);
		if(emaiValid.isValid(user.getEmail()) && 
				authentactionService.nameCheck(user.getFirstName(), user.getLastName()) &&
				authentactionService.emailCheck(user.getEmail()) &&
				authentactionService.passwordCheck(user.getPassword())){
			userDao.add(user);
			
			System.out.println("Üyeligi tamalamak icin dogrulama linkine týklayýn.");
			this.registerService.registerSystem("Üye olundu");
			System.out.println("Tebrikler üyelik basarýyla gerceklesmistir");
			System.out.println("");
			
		}
		else
		{
			System.out.println("Ýslem gerceklestirilemedi");
		}
		
	}

	@Override
	public void login(String email, String password) {
		// TODO Auto-generated method stub
		for(User user :userDao.getAll()) {
			if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
				System.out.println("Giris bararýyla gerceklesmistir");
				return;
			}
		}
		System.out.println("Email ya da password yanlýs");
	}

	@Override
	public void registerToGoogle(String firstName) {
		registerService.registerGoogle(" google ile üye olundu");
		
	}

	

}
