package GUI;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	public MainFrame(JPanel p) {
		this.setTitle("Talk to you");
		this.add(p);
		this.setSize(p.getWidth(), p.getHeight());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
	}
	
	public void setPanel(JPanel p) {
		this.removeAll();
		this.add(p);
		this.setSize(p.getWidth(), p.getHeight());
		this.revalidate();
	}

}
