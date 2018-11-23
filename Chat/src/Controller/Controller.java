package Controller;

import Client.User;

public class Controller {

	private User user;
	
	public void setUser(String ID, String Pass, String IP, int Port) {
		user = new User(ID,Pass,IP,Port);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		
	}
	
}
