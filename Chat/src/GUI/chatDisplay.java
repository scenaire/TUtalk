package GUI;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.Controller;

public class chatDisplay extends JPanel{
	private String contact;
	private String messIn;
	private String messOut;
	private String text = "";
	JTextArea boxchat = new JTextArea(10,30);
	JTextArea boxSend= new JTextArea(4,30);
	JTextArea boxShowFriennd = new JTextArea(13,15);
	JScrollPane box1 = new JScrollPane(boxchat);
	JScrollPane box2 = new JScrollPane(boxSend);
	JScrollPane contacts = new JScrollPane(boxShowFriennd);
	JButton bSend = new JButton("send");
	
	
	public void contactList(String cn) {
		contact=cn;
	}
	public void sendMassage(String mi) {
		messIn+=mi;
	}
	public String getMessage() {
		return messOut;
	}
	
	
	
	public  chatDisplay() {
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel chatSide = new JPanel();
		JPanel showUserSide = new JPanel();
		bSend.setFont(new Font("Agency FB", 0, 25));
		ImageIcon icon1 = new ImageIcon(new ImageIcon("pic1.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon icon2 = new ImageIcon(new ImageIcon("pic2.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		JLabel iconLabel1 = new JLabel(icon1);
		JLabel iconLabel2 = new JLabel(icon2);
		JLabel contactsLabel = new JLabel("Contacts");
		JLabel nameLabel = new JLabel("Name: ");
		contactsLabel.setFont(new Font("Agency FB", 0, 25));
		nameLabel.setFont(new Font("Agency FB", 0, 25));
		
		//display message from friend
		if(messIn != null) {
			boxchat.setText(boxchat.getText()+messIn);
		}
		
		
		//display contractlist

		
	
		bSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				messOut+=boxSend.getText();
				boxchat.setText(boxchat.getText()+"\n RockMan : "+boxSend.getText());
				boxSend.setText("");
			}
			
		});
	
		boxchat.setEditable(false);
		boxShowFriennd.setEditable(false);
		box1.getDefaultLocale();
		box2.getDefaultLocale();
		contacts.getDefaultLocale();
		bSend.getDefaultLocale();
		
		p1.setLayout(new BorderLayout());
		p1.add(iconLabel1 ,BorderLayout.NORTH);
		p2.setLayout(new BorderLayout());
		p2.add(p1 ,BorderLayout.LINE_START);
		p2.add(box1 ,BorderLayout.CENTER);
		
		p3.setLayout(new BorderLayout());
		p3.add(iconLabel2 ,BorderLayout.NORTH);
		p4.setLayout(new BorderLayout());
		p4.add(p3 ,BorderLayout.LINE_START);
		p4.add(box2 ,BorderLayout.CENTER);
		p4.add(bSend,BorderLayout.LINE_END);
		
		chatSide.setLayout(new BorderLayout());
		chatSide.add(nameLabel ,BorderLayout.NORTH);
		chatSide.add(p2 ,BorderLayout.CENTER);
		chatSide.add(p4 ,BorderLayout.SOUTH);
		
		showUserSide.setLayout(new BorderLayout());
		showUserSide.add(contactsLabel ,BorderLayout.NORTH);
		showUserSide.add(contacts ,BorderLayout.CENTER);
		
		JPanel panelAll = new JPanel();
		panelAll.setLayout(new BorderLayout());
		JLabel namePro = new JLabel("Talk To You <TU>");
		namePro.setFont(new Font("Agency FB", 0, 25));
		panelAll.add(namePro,BorderLayout.NORTH);
		panelAll.add(showUserSide,BorderLayout.CENTER);
		panelAll.add(chatSide ,BorderLayout.EAST);
		this.add(panelAll);
		
		
	}
public static void main(String[] args) throws UnknownHostException, IOException {
		
		JFrame f = new JFrame();
		chatDisplay c = new chatDisplay();
		
		f.add(c);
		f.pack();
		//f.setSize(c.getWidth(), c.getHeight());
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
