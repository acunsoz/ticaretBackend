package ticaretBackend.core;

import ticaretBackend.GoogleService.GoogleServiceManager;
import ticaretBackend.RegisterManager.registerManager;

public class RegisterManagerAdapter implements RegisterService{

	@Override
	public void registerGoogle(String message) {
		GoogleServiceManager manager = new GoogleServiceManager();
		manager.log(message);
		
	}
	public void registerSystem(String message) {
		registerManager manager = new registerManager();
		manager.log(message);
		
	}
}
