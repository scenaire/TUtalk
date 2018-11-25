package Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListeningThread implements Runnable {
	
	ServerSocket listener;

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
				Socket socket = listener.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
