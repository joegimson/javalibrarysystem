import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//where user interface starts

public class Mainframe extends JFrame {
	static String postcode;
	static String userno;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainframe() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton user1Button = new JButton("Login as user1");
		user1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrame adf = new AdminFrame(); //as user 1 is an admin adminmenu opens
				adf.setVisible(true);
			}
		});
		user1Button.setBounds(22, 11, 147, 37);
		contentPane.add(user1Button);
		
		JButton user3Button = new JButton("Login as user3");
		user3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFramee cf = new CustomerFramee();
				cf.setVisible(true);
				postcode = "BN1 3XP";
				userno = "103"; //used when writing to activitylog
			}
		});
		user3Button.setBounds(22, 59, 147, 37);
		contentPane.add(user3Button);
		
		JButton user2Button = new JButton("Login as user2");
		user2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFramee cf = new CustomerFramee();
				cf.setVisible(true);
				postcode = "E20 3BS";
				userno = "102";
			}
		});
		user2Button.setBounds(265, 11, 140, 37);
		contentPane.add(user2Button);
		
		JButton user4Button = new JButton("Login as user4");
		user4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFramee cf = new CustomerFramee();
				cf.setVisible(true);
				postcode = "PA3 2SW";
				userno = "104";
			}
		});
		user4Button.setBounds(265, 59, 140, 37);
		contentPane.add(user4Button);
	}
}
