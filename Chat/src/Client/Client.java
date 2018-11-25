package Client;

public class Client {
	
	private String ID;
	private String IP;
	private int port;
	private boolean status;
	
	public Client(String ID, String IP, int port, boolean status) {
		this.ID = ID;
		this.IP = IP;
		this.port = port;
		this.status = status;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}