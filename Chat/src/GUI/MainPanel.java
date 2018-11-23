package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class MainPanel extends JPanel {
	
	private JTextField userField, passField, portField;
	private JPanel LoginPanel;
	
	public MainPanel() {
		this.add(LoginPanel());
		this.setSize(LoginPanel().getSize());
	}

	public JPanel LoginPanel() {
		
		LoginPanel = new JPanel();
		JLabel header = new JLabel("Talk TO U");
		header.setFont(new Font("Segoe UI Semibold", Font.BOLD, 45));
		
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");
		JLabel portLabel = new JLabel("Port");
		
		LoginPanel.setSize(new Dimension(370,600));
		LoginPanel.add(header,BorderLayout.NORTH);
		
		JPanel log = new JPanel();
		log.add(userLabel);
		log.add(passLabel);
		log.add(portLabel);
		
		LoginPanel.add(log,BorderLayout.SOUTH);
		
		return LoginPanel;
		
	}
	
}
