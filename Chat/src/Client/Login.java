package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Login {
	
	private OutputStream os = null;
	private InputStream is = null;
	private PrintWriter writer = null;
	private BufferedReader reader = null;
	
	public boolean isLogin(Socket s, User user) throws IOException {
		
		try {
			os = s.getOutputStream();
			is = s.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer = new PrintWriter(os,true);
		reader = new BufferedReader(new InputStreamReader(is));
		
		System.out.println("yay");
		
		writer.println("USER:"+user.getUser_ID());
	    writer.println("PASS:"+user.getUser_Pass());
	    writer.println("IP:"+user.getUser_IP());
	    writer.println("PORT:"+user.getUser_Port());
	    
	    String line=null;
	    		
	    while ((line = reader.readLine()) != null) {
	    	if (line.equals("200 SUCCESS")) {
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    
		return false;
		
	}

}
