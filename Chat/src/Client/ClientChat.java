package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientChat {
	
	public static final String Server_IP = "128.199.83.36";
	public static final int Server_Port = 34261;
	
	
	public static void main(String[] agrs) throws UnknownHostException, IOException, InterruptedException{
		
		InetAddress IP = InetAddress.getLocalHost();
		
		Socket s = new Socket(Server_IP,Server_Port);
		User user = new User("5909610015","0015",IP.getHostAddress(),2546);
		
        Scanner sc = new Scanner(System.in);
        Thread t1 = new Thread(new HBThread(s,user));
        
        t1.start();
        
	}

}

