package GUI;

import javax.swing.*;

import Client.ClientChat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class LoginPanel extends JPanel implements ActionListener{
	private String User_IP, User_Pass, User_ID ;
	private int User_Port;
	static boolean re=false;
JButton blogin;
  JPanel loginpanel;
  JTextField txuser = new JTextField(20);
  JTextField pass = new JTextField(20);
  JTextField ip = new JTextField(20);
  JTextField port = new JTextField(20);
  JLabel usernameLabel = new JLabel("Username :");
  JLabel passwordLabel= new JLabel("Password :");
  JLabel ipLabel = new JLabel("IP              :");
  JLabel portLabel= new JLabel("Port          :");
  JButton loginBtn;
 chatDisplay cD = new chatDisplay();
  
  	public LoginPanel() {
  		ClientChat chat = new ClientChat();
  		txuser.setText("5909610262");
  		pass.setText("0262");
  		ip.setText("173.25.114.135");
  		port.setText("2800");
  		JPanel panelAll = new JPanel();
  		JPanel p1 = new JPanel();
  		JPanel p2 = new JPanel();
  		JPanel p3 = new JPanel();
  		JPanel p4 = new JPanel();
  		usernameLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
  		passwordLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
  		ipLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
  		portLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
  		panelAll.setLayout(new BorderLayout());
  		p1.setLayout(new java.awt.FlowLayout());
  		p2.setLayout(new java.awt.FlowLayout());
  		p3.setLayout(new java.awt.FlowLayout());
  		p4.setLayout(new java.awt.FlowLayout());
  		
  		p1.add(usernameLabel);
  		p1.add(txuser);
  		p2.add(passwordLabel);
  		p2.add(pass);
  		p3.add(ipLabel);
  		p3.add(ip);
  		p4.add(portLabel);
  		p4.add(port);
  		JPanel set1 = new JPanel();
  		set1.setLayout(new BorderLayout());
  		JPanel set2 = new JPanel();
  		set2.setLayout(new BorderLayout());
  		JPanel set3 = new JPanel();
  		set3.setLayout(new BorderLayout());
  		JPanel set4 = new JPanel();
  		set4.setLayout(new BorderLayout());
  		JLabel welcome = new JLabel("Welcome to Talk to you <TU>");
  		welcome.setFont(new Font("Agency FB", Font.BOLD, 32));
  		set1.add(welcome,BorderLayout.NORTH);
  		set1.add(p1,BorderLayout.WEST);
  		set2.add(p2,BorderLayout.WEST);
  		set3.add(p3,BorderLayout.WEST);
  		set4.add(p4,BorderLayout.WEST);
  		JPanel a = new JPanel();
  		a.setLayout(new BorderLayout());
  		a.add(set1,BorderLayout.NORTH);
  		a.add(set2,BorderLayout.SOUTH);
  		JPanel a1 = new JPanel();
  		a1.setLayout(new BorderLayout());
  		a1.add(set3 ,BorderLayout.NORTH);
  		a1.add(set4 ,BorderLayout.SOUTH);
  		panelAll.add(a,BorderLayout.NORTH);
  		panelAll.add(a1,BorderLayout.CENTER);
  		loginBtn = new JButton("Login"); 
  		panelAll.add(loginBtn,BorderLayout.SOUTH);
  	this.add(panelAll);
  	
  		loginBtn.setFont(new Font("Agency FB", Font.BOLD, 15));
  		loginBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	chat.setUsername(txuser.getText());
            	chat.setIP(ip.getText());
            	chat.setpass(pass.getText());
            	chat.setport(Integer.parseInt(port.getText()));
            	System.out.println("USER:"+txuser.getText());
            	System.out.println("PASS:"+pass.getText());
            	System.out.println("IP:"+ip.getText());
            	System.out.println("PORT:"+port.getText());
            	chat.connect();
            	cD.show();
            }

        });
  		
  		this.add(panelAll);
  	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Talk To You (TU)");
		LoginPanel l = new LoginPanel();
		
		f.add(l);
		
	//	f.setSize(420,250);
		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		
	}


}