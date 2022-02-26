package todolist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.event.*;
//import java.awt.*;
public class Front_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front_page frame = new Front_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close() {
		this.setVisible(false);
		this.dispose();
	}
	/**
	 * Create the frame.
	 */
	public Front_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 860);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("I:\\SEMESTER 3\\java mini project\\logo.png"));
		lblNewLabel.setBounds(149, 101, 507, 498);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TO - DO LIST - HEALTH");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sigmar One", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(130, 10, 539, 67);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SIGN - UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				signup s = new signup();
				s.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setBounds(149, 679, 179, 42);
		contentPane.add(btnNewButton);
		
		JButton btnLogIn = new JButton("LOG - IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				login l = new login();
				l.setVisible(true);
				
			}
		});
		btnLogIn.setForeground(Color.BLACK);
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLogIn.setBackground(Color.YELLOW);
		btnLogIn.setBounds(477, 679, 179, 42);
		contentPane.add(btnLogIn);
	}

}
