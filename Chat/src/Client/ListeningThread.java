package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ListeningThread implements Runnable {
	
	private ServerSocket listener;
	private PrintWriter writer;

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
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
