package Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HBThread implements Runnable{
	
	public static final String Server_IP = "128.199.83.36";
	public static final int Server_Port = 34261;
	
	private Socket socket = null;
	private User user = null;
	private ClientList cl = null;
	private boolean canLogin = false;
	
	String checkCon;
	OutputStream output = null;
	InputStream input = null;
	PrintWriter writer = null;
    BufferedReader reader = null;
    DataInputStream is = null;
	
	public HBThread(User user) throws UnknownHostException, IOException {
		socket = new Socket(Server_IP,Server_Port);
		this.user = user;
		
		cl = new ClientList();
		
		checkCon = "Hello "+this.user.getUser_ID();
		
		try {
			output = socket.getOutputStream();
			input = socket.getInputStream();
			is = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	    writer = new PrintWriter(output, true);
	    reader = new BufferedReader(new InputStreamReader(input));
	    
	}

	@Override
	public void run() {
		
		 writer.println("USER:"+user.getUser_ID());
	     writer.println("PASS:"+user.getUser_Pass());
	     writer.println("IP:"+user.getUser_IP());
	     writer.println("PORT:"+user.getUser_Port());

	     try {
			addFriendList();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(true) {
			byte[] msg_fromserver = new byte[16];
			try {
				is.read(msg_fromserver);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String str = new String(msg_fromserver);
			
			if (str.equals(checkCon)) {
				writer.println("Hello Server");
				
				try {
					addFriendList();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} 
			
		}
		
	}
	
	private void addFriendList() throws IOException {
		String[] split;
		String line = null;
		Client c;
		cl.removeAll();

	    while ((line = reader.readLine()) != null) {
	        //System.out.println(line);
	        if (line.equals("END")) {
	            break;
	        } else if (line.matches("(\\d)+:(\\d)+.(\\d)+.(\\d)+.(\\d)+:(\\d)+") || line.matches("(\\d)+:-1:-1")) {
	        	split = line.split(":");
	        	if (split[1].equals("-1")) {
	        		c = new Client(split[0],null,-1,false);
	        	} else {
	        		c = new Client(split[0],split[1],Integer.parseInt(split[2]),true);
	        	}
	        	cl.addClient(c);
	        }
	    }
	    System.out.println(cl.getClientAtIndex(0).getID() +": "+cl.getClientAtIndex(0).isStatus());   
	}
	
	public ClientList getClientList() {
		return cl;
	}
	
	public boolean canLogin() {
		return canLogin;
	}
	
	

}
