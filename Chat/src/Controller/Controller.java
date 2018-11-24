package Controller;

import java.io.IOException;
import java.net.UnknownHostException;

import Client.ClientChat;
import Client.HBThread;
import Client.User;

public class Controller {

	
	private String ID ,Pass,IP;
	private int Port;
	private User user; 
	private HBThread  HB;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	

	
	
}
