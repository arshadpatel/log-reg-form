package amp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField tf1;
	JLabel lblNewLabel_1_2 = new JLabel("Name");
	JLabel lblNewLabel_2 = new JLabel("Email");
	JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Gender");
	JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Contact No.");
	JLabel lblYourDetails = new JLabel("Your Details");
	JLabel lblNewLabel_1_1_2 = new JLabel("Programming Lang.");
	private JPasswordField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
			}
		});
		frame.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
			}
		});
		frame.setBounds(100, 100, 446, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(0, 10, 436, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(42, 70, 150, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
			}
		});
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(42, 100, 150, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tf1 = new JTextField();
		tf1.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
			}
		});
		tf1.setColumns(10);
		tf1.setBounds(202, 73, 180, 20);
		frame.getContentPane().add(tf1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorResized(HierarchyEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String uname = tf1.getText();
				String pw = tf2.getText();
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test65","root","arshad");
					String query = "SELECT password FROM registration where username = "+"'"+uname+"'";
					Statement st = con.createStatement();
					ResultSet rs=st.executeQuery(query);
					String ppw ="";

				      while(rs.next()){
				    	  ppw =rs.getString("password");
				      }
					
					if(!pw.equals(ppw)) {
						JOptionPane.showMessageDialog(btnNewButton, "Username not found\nTry Again!!!", "Username Error",2);
						return;
					}
						
				}catch(Exception e1) {
					System.out.println("Code fattgaya");
				}
				
				lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1_2.setBounds(42, 256, 150, 20);
					
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_2.setBounds(42, 286, 150, 20);
						
				lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1_1_1_1_1.setBounds(42, 316, 150, 20);
						

				lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1_1_1_1_2.setBounds(42, 346, 150, 20);
				
				lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblNewLabel_1_1_2.setBounds(42, 376, 150, 20);
				
				JLabel namelb = new JLabel("");
				JLabel emaillb = new JLabel("");
				JLabel genderlb = new JLabel("");
				JLabel contactlb = new JLabel("");
				JLabel langlb = new JLabel("");
				
				namelb.setFont(new Font("Tahoma", Font.PLAIN, 16));
				namelb.setBounds(202, 256, 250, 20);
				frame.getContentPane().add(namelb);
						
				emaillb.setFont(new Font("Tahoma", Font.PLAIN, 16));
				emaillb.setBounds(202, 286, 250, 20);
				frame.getContentPane().add(emaillb);
						
				genderlb.setFont(new Font("Tahoma", Font.PLAIN, 16));
				genderlb.setBounds(202, 316, 250, 20);
				frame.getContentPane().add(genderlb);
						
				contactlb.setFont(new Font("Tahoma", Font.PLAIN, 16));
				contactlb.setBounds(202, 346, 250, 20);
				frame.getContentPane().add(contactlb);
					
				langlb.setFont(new Font("Tahoma", Font.PLAIN, 16));
				langlb.setBounds(202, 376, 250, 20);
				frame.getContentPane().add(langlb);
						
				lblYourDetails.setHorizontalAlignment(SwingConstants.CENTER);
				lblYourDetails.setFont(new Font("Tahoma", Font.PLAIN, 24));
				lblYourDetails.setBounds(0, 208, 438, 38);
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test65","root","arshad");
					Statement st = con.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM registration where username = "+"'"+uname+"'");

					String name= "";
					String email = "";
					String gender = "";
					String contact = "";
					String lang = "";
					
					 while(rs.next()){
		
						name= ": "+rs.getString("name");
						email = ": "+rs.getString("email");
						gender = ": "+rs.getString("gender");
						contact = ": "+rs.getString("contact");
						lang = ": "+rs.getString("language");
						
				     }
					 	 
					namelb.setText(name);
					emaillb.setText(email);
					genderlb.setText(gender);
					contactlb.setText(contact);
					langlb.setText(lang);
					
				}catch(Exception e1) {
					System.out.println("Code fattgaya2");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(164, 148, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		frame.getContentPane().add(lblNewLabel_1_2);
		frame.getContentPane().add(lblNewLabel_2);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_2);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		frame.getContentPane().add(lblYourDetails);
		
		tf2 = new JPasswordField();
		tf2.setBounds(202, 103, 180, 20);
		frame.getContentPane().add(tf2);
		
	}
}
