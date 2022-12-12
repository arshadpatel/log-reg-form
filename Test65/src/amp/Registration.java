package amp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Registration {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JPasswordField tf5;
	private JPasswordField tf6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 0, 496, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(59, 102, 150, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(59, 132, 150, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Create Username");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(59, 252, 150, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Create Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(59, 282, 150, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Confirm Password");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(59, 312, 150, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(59, 162, 150, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Contact No.");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2.setBounds(59, 192, 150, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Programming Lang.");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(59, 222, 150, 20);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		tf1 = new JTextField();
		tf1.setBounds(259, 102, 180, 20);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(259, 135, 180, 20);
		frame.getContentPane().add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(259, 195, 180, 20);
		frame.getContentPane().add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(259, 255, 180, 20);
		frame.getContentPane().add(tf4);
		
		JRadioButton rb1 = new JRadioButton("Male");
		rb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rb1.setBounds(259, 164, 80, 21);
		frame.getContentPane().add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Female");
		rb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rb2.setBounds(341, 164, 98, 21);
		frame.getContentPane().add(rb2);
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"C", "C++", "Java", "Python", "Javascript"}));
		cb.setBounds(259, 224, 180, 21);
		frame.getContentPane().add(cb);
		
		tf5 = new JPasswordField();
		tf5.setBounds(259, 285, 180, 20);
		frame.getContentPane().add(tf5);
		
		tf6 = new JPasswordField();
		tf6.setBounds(259, 315, 180, 20);
		frame.getContentPane().add(tf6);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= tf1.getText();
				String email = tf2.getText();
				String gender = "";
				if(rb1.isSelected())
					gender="Male";
				else if(rb2.isSelected())
					gender = "Female";
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Select Gender", "Gender Error",2);
					return;
				}
					
				String contact = tf3.getText();
				String lang = (String)cb.getSelectedItem();
				String uname = tf4.getText();
				String pw = tf5.getText();
				String cpw = tf6.getText();
				if(!pw.equals(cpw))
					JOptionPane.showMessageDialog(btnNewButton, "Password Do not match\nTry Again!!!", "Password Error",2);
				else {
					try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test65","root","arshad");
					String query = "insert into registration values('"+name+"','"+email+"','"+gender+"','"+contact+"','"+lang+"','"+uname+"','"+pw+"')";
					Statement st = con.createStatement();
					st.executeUpdate(query);
					JOptionPane.showMessageDialog(btnNewButton, "Registration Successful!!");
				}catch(Exception e1) {
					System.out.println("Code fattgaya");
				}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(199, 357, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
	}
}
