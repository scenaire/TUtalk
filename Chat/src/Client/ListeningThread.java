package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ListeningThread implements Runnable {
	
	private ServerSocket listener;
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;
	private String reMsg, seMsg;

	public ListeningThread(User user) {
		try {
			listener = new ServerSocket(user.getUser_Port());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Waiting for Client...");
				socket = listener.accept();
				System.out.println("Client Accept");
				writer = new PrintWriter(socket.getOutputStream(), true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sendMsg(String msg) {
		writer.println(msg);
	}
	
	public void receiveMsg() {
		String line = null;
		
		try {
			if ((line = reader.readLine()) != null) {
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
