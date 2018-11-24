package GUI;

import javax.swing.*;

import Client.ClientChat;
import Client.HBThread;
import Controller.Controller;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

public class LoginPanel extends JPanel{
	JTextField txuser = new JTextField(20);
	JTextField pass = new JTextField(20);
	JLabel usernameLabel = new JLabel("Username :");
	JLabel passwordLabel= new JLabel("Password :");
	JButton loginBtn;
	chatDisplay cD = new chatDisplay();
  
  	public LoginPanel() {
  		JPanel panelAll = new JPanel();
  		JPanel p1 = new JPanel();
  		JPanel p2 = new JPanel();
  		JPanel p3 = new JPanel();
  		JPanel p4 = new JPanel();
  		usernameLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
  		passwordLabel.setFont(new Font("Agency FB", Font.PLAIN, 20));
  		panelAll.setLayout(new BorderLayout());
  		p1.setLayout(new java.awt.FlowLayout());
  		p2.setLayout(new java.awt.FlowLayout());
  		p3.setLayout(new java.awt.FlowLayout());
  		p4.setLayout(new java.awt.FlowLayout());
  		
  		p1.add(usernameLabel);
  		p1.add(txuser);
  		p2.add(passwordLabel);
  		p2.add(pass);
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
  		//panelAll.add(a1,BorderLayout.CENTER);
  		loginBtn = new JButton("Login"); 
  		panelAll.add(loginBtn,BorderLayout.SOUTH);
  		loginBtn.setFont(new Font("Agency FB", Font.BOLD, 15));
  		this.setSize(new Dimension(420,200));
  		this.add(panelAll);
  	}
	

}