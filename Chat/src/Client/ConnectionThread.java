package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

public class ConnectionThread implements Runnable {
	
	private Socket s;
	private BufferedReader reader;
	
	public ConnectionThread(Client c, User user) {
		try {
			s = new Socket(c.getIP(),c.getPort());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		String line;
		try {
			reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			if ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
