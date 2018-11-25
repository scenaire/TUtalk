package GUI;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ChatDisplay extends JPanel{
	private String contact;
	private String messIn;
	private String messOut;
	private String text = "";
	JTextArea boxchat = new JTextArea(10,30);
	JTextArea boxSend= new JTextArea(4,30);
	JTextArea boxShowFriend = new JTextArea(13,15);
	JScrollPane box1 = new JScrollPane(boxchat);
	JScrollPane box2 = new JScrollPane(boxSend);
	JScrollPane contacts = new JScrollPane(boxShowFriend);
	JButton bSend = new JButton("send");
	JLabel connectTo ;
	JTextField connectfield;
	JButton connect;
	public  ChatDisplay() {
		connectTo = new JLabel("Connect To:");
		connectTo.setFont(new Font("Agency FB", 0, 18));
		connectfield= new JTextField(15);
		connect = new JButton("Start conncet!!");
		connect.setFont(new Font("Agency FB", 0, 18));
		JPanel connectPanel = new JPanel();
		connectPanel.setLayout(new FlowLayout());
		connectPanel.add(connectTo);
		connectPanel.add(connectfield);
		connectPanel.add(connect);
		this.setSize(new Dimension(600,300));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel panelAll2 = new JPanel();
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

	
		boxchat.setEditable(false);
		boxShowFriend.setEditable(false);
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
		panelAll2.setLayout(new BorderLayout());
		panelAll2.add(panelAll,BorderLayout.NORTH);
		panelAll2.add(connectPanel,BorderLayout.SOUTH);
		this.add(panelAll2);
	}
	public JButton getConncetBtn() {
		return connect;
	}
	public String getIDConnect() {
		return connectfield.getText();
	}
	
	public JTextArea getBoxShowFriennd() {
		return boxShowFriend;
	}
	public JButton getMsgBtn() {
		return bSend;
	}
	public String getMsgSay() {
		return boxSend.getText();
	}
	
	public void contactList(String cn) {
		contact=cn;
	}
	
	public void sendMassage(String mi) {
		messIn+=mi;
	}
	
	public String getMessage() {
		return messOut;
	}
	public void setboxSend() {
		boxSend.setText("");
	}
	
}
