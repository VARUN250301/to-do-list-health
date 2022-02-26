package todolist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import signupform.DB;
import signupform.login;
import signupform.successpage;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class login extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
					login frame = new login();
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
	public login() {
		con=(Connection) DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 484);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TO DO LIST - HEALTH");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Quicksand", Font.PLAIN, 40));
		lblNewLabel.setBounds(77, 46, 411, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SIGN IN");
		lblNewLabel_1.setFont(new Font("Quicksand Medium", Font.BOLD, 30));
		lblNewLabel_1.setBounds(227, 119, 118, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USER ID");
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(147, 216, 118, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("PASSWORD");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Georgia", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(124, 270, 167, 33);
		contentPane.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setBounds(338, 216, 139, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(338, 270, 139, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String user = textField.getText();
					String pwd = String.valueOf(passwordField.getPassword());
					PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from signup where userid=? and password=?");
					pst.setString(1, user);
					pst.setString(2, pwd);
					ResultSet r=pst.executeQuery();
					if(r.next())
					{
						close();
						todo s=new todo();
						s.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "incorrect userid or password.");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		btnNewButton.setBounds(227, 341, 127, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Front_page fp = new Front_page();
				fp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(0, 0, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sign-Up Page");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				signup sp = new signup();
				sp.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(77, 0, 118, 21);
		contentPane.add(btnNewButton_2);
	}
}
/*	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
/*	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}*/
