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
	
	public void setUser(String ID, String Pass, String IP, int Port) throws UnknownHostException, IOException, InterruptedException {
		user =  new User(ID,Pass,IP,Port);
		System.out.println(ID);
		System.out.println(Pass);	
		
	}
	
	public String getUserID() {
		return user.getUser_ID();
	}
	public String getUserPass() {
		return user.getUser_Pass();
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
