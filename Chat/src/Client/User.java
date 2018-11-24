package Client;

public class User {
	
	private String User_IP, User_Pass, User_ID;
	private int User_Port;
	
	public User() {
		
	}
	
	public User(String id, String pass, String ip, int port) {
		this.User_ID = id;
		this.User_Pass = pass;
		this.User_IP = ip;
		this.User_Port = port;
		
	}
	
	public String getUser_IP() {
		return User_IP;
	}
	public void setUser_IP(String user_IP) {
		User_IP = user_IP;
	}
	public String getUser_Pass() {
		System.out.println("get pass");
		return User_Pass;
	}
	public void setUser_Pass(String user_Pass) {
		
		User_Pass = user_Pass;
	}
	public String getUser_ID() {
		System.out.println("get id");
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public int getUser_Port() {
		return User_Port;
	}
	public void setUser_Port(int user_Port) {
		User_Port = user_Port;
	}

	@Override
	public String toString() {
		return "USER:" + User_ID + "\nPASS" + User_Pass + "\nIP" + User_IP + "\nPORT"
				+ User_Port + "\n";
	}
	
	
	

}
