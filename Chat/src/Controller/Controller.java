package Controller;

import java.awt.Color; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Client.Client;
import Client.ClientList;
import Client.ConnectionThread;
import Client.HBThread;
import Client.ListeningThread;
import Client.Login;
import Client.User;
import GUI.ChatDisplay;
import GUI.LoginPanel;
import GUI.MainFrame;

public class Controller {

	private User user; 
	private LoginPanel loginPanel;
	private ClientList cl;
	private Thread hbThread, listeningThread, connectionThread;
	private ChatDisplay chatDisplay;
	private Socket s;
	private Login login;
	private MainFrame f;
	private JFrame chatF;
	
	public Controller() {
		loginPanel = new LoginPanel();
		chatDisplay = new ChatDisplay();
		cl = new ClientList();
		user = new User();
		login = new Login();
	}
	
	public void run() {
		f = new MainFrame(loginPanel);
		logIn();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setSocket(String ip, int port) {
		try {
			s = new Socket(ip,port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Socket getSocket() {
		return s;
	}
	
	public void StartHB() throws UnknownHostException {
		try {
			hbThread = new Thread(new HBThread(s,user,cl));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hbThread.start();
	}
	
	public void startListening() {
		listeningThread = new Thread(new ListeningThread(user));
		listeningThread.start();
	}
	
	public void startConnect(Client c) {
		connectionThread = new Thread(new ConnectionThread(c, user));
		connectionThread.start();
	}
	
	public void logIn() {
		loginPanel.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = null;
				String id = loginPanel.getUser_ID();
				String pass = loginPanel.getUser_pass();
				try {
					ip = InetAddress.getLocalHost().getHostAddress();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
				int port = 11111;
				user.setUser_ID(id);
				user.setUser_Pass(pass);
				user.setUser_IP(ip);
				user.setUser_Port(port);
				try {
					if (login.isLogin(s, user)) {
						StartHB();
						startListening();
						chatF = new JFrame();
						chatF.add(chatDisplay);
						chatF.pack();
						chatF.setVisible(true);
						chatF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Timer t = new Timer();
					    t.schedule(new TimerTask() {
					        @Override public void run() {
					        	chatDisplay.getBoxShowFriennd().setText("");
					        	chatDisplay.getBoxShowFriennd().setForeground(new Color(11,104,35));
					        	String online;
								for (Client a: cl.getOnlineList()) {
									online = "online";
									chatDisplay.getBoxShowFriennd().append(a.getID()+": "+online+"\n");
								} 
					        }
					    }, 0L, 4000L);
					    chatDisplay.getConnectBtn().addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								startConnect(cl.getClientFromID(chatDisplay.getIDonnect()));
							}
					    });
					} else {
						JOptionPane.showMessageDialog(null, "Invalid username or password");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	
}
