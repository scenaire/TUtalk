package Controller;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import Client.HBThread;
import Client.User;
import GUI.LoginPanel;
import GUI.chatDisplay;

public class Controller {

	private User user; 
	private HBThread  HB;
	private LoginPanel loginPanel;
	private Thread hbThread;
	private chatDisplay chatDis;
	
	public Controller() {
		loginPanel = new LoginPanel();
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}
	
	public void StartHB() throws UnknownHostException, IOException {
		hbThread = new Thread(new HBThread(user));
		hbThread.start();
	}
	
	public void logIn() {
		loginPanel.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = null;
				String id = loginPanel.getUser_ID();
				String pass = loginPanel.getUser_pass();
				System.out.println(id);
				System.out.println(pass);
				try {
					ip = InetAddress.getLocalHost().getHostAddress();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
				int port = 28000;
				User user = new User(id,pass,ip,port);
				setUser(user);
				
				try {
					StartHB();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	public  void showChat() {
		
	}

	
	
}
