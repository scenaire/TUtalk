package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import Controller.Controller;

public class ClientChat {
	
	public static final String Server_IP = "128.199.83.36";
	public static final int Server_Port = 34261;
	private Controller c = new Controller() ;
	
	public  void connect() throws UnknownHostException, IOException, InterruptedException{
		
		InetAddress IP = InetAddress.getLocalHost();
		
		Socket s = new Socket(Server_IP,Server_Port);
		User user = new User("5909610262","0262",IP.getHostAddress(),2800);
		
        Scanner sc = new Scanner(System.in);
        Thread t1 = new Thread(new HBThread(s,user));
        
        t1.start();
        
	}
	public static void main(String[] agrs) {
		ClientChat c  = new ClientChat();
		try {
			c.connect();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

