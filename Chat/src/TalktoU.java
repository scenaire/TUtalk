import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JPanel;

import Client.HBThread;
import Client.User;
import Controller.Controller;
import GUI.LoginPanel;
import GUI.MainFrame;

public class TalktoU {

	private static final String SERVER_IP = "128.199.83.36";
	private static final int SERVER_PORT = 34261;

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Controller c = new Controller();
		c.setSocket(SERVER_IP, SERVER_PORT);
		c.run();
		
		
	}

}
