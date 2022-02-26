package todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import signupform.DB;
import signupform.signup;
import java.awt.event.*;
import java.awt.*;

public class signup extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public void close() {
		this.setVisible(false);
		this.dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	Connection con=null;
	private JPasswordField passwordField;
	public signup() {
		con=(Connection) DB.dbconnect();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 779);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TO DO LIST - HEALTH");
		lblNewLabel.setFont(new Font("Quicksand", Font.BOLD, 40));
		lblNewLabel.setBounds(63, 24, 437, 117);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN - UP FORM");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 30));
		lblNewLabel_1.setBounds(139, 122, 281, 58);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_2.setBounds(84, 222, 161, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LAST NAME");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_3.setBounds(100, 297, 133, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PHONE");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_4.setBounds(100, 361, 145, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-MAIL");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_5.setBounds(100, 431, 133, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("USER ID");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_6.setBounds(100, 500, 133, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PASSWORD");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblNewLabel_7.setBounds(100, 562, 133, 27);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(324, 222, 145, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(324, 297, 145, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(324, 361, 145, 30);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(324, 428, 145, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(324, 503, 145, 30);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("SIGN - UP");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String first = textField.getText();
				String last = textField_1.getText();
				String phone = textField_2.getText();
				String email = textField_3.getText();
				String user = textField_4.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				PreparedStatement pst=(PreparedStatement) con.prepareStatement("insert into signup(firstname,lastname,phone,email,userid,password) values(?,?,?,?,?,?)");
				pst.setString(1, first);
				pst.setString(2, last);
				pst.setString(3, phone);
				pst.setString(4, email);
				pst.setString(5, user);
				pst.setString(6, password);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"data added");
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				passwordField.setText("");
				}
				catch(Exception e1 ) {
					e1.printStackTrace();
				}
			}});
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		btnNewButton.setBounds(84, 652, 173, 48);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(324, 562, 145, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_8 = new JLabel("if you have already signed up, then click on login");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(84, 615, 385, 27);
		contentPane.add(lblNewLabel_8);
		
		JButton btnLogIn = new JButton("LOG - IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				login l = new login();
				l.setVisible(true);
			}
		});
		btnLogIn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		btnLogIn.setBackground(Color.WHITE);
		btnLogIn.setBounds(310, 652, 173, 48);
		contentPane.add(btnLogIn);
	}
}

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
/*	public signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}*/
