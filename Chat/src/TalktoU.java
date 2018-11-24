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

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Controller c = new Controller();
		MainFrame f = new MainFrame(c.getLoginPanel());
		
		c.logIn();
		
		
	}

}
