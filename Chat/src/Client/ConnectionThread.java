package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

public class ConnectionThread implements Runnable {
	
	private Socket s;
	private BufferedReader reader;
	private String reMsg,seMsg;
	private PrintWriter writer;
	
	public ConnectionThread(Client c, User user) {
		try {
			System.out.println("try to ask them to talk with me...");
			System.out.println(c.getIP()+": "+c.getPort());
			s = new Socket(c.getIP(),c.getPort());
			writer = new PrintWriter(s.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		String line="";
		try {
			if ((line = reader.readLine()) != null) {
				System.out.println("Server say : "+line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMsg(String msg) {
		writer.println(msg);
	}
	
	public void receiveMsg() {
		String line = null;
		
		try {
			if ((line = reader.readLine()) != null) {
				reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
				reMsg = line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getReMsg() {
		return reMsg;
	}
	

	

}
