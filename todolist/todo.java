package todolist;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextArea;
import java.awt.event.*;
import java.awt.*;
public class todo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					todo frame = new todo();
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
	Connection con=null;
	public todo() {
		con=(Connection) DB.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 1048);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TO - DO LIST - HEALTH");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 60));
		lblNewLabel.setBounds(311, 22, 807, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("HEALTH GOALS");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_1.setBounds(96, 144, 240, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(370, 144, 217, 128);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(370, 366, 217, 146);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(367, 541, 220, 157);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel_2 = new JLabel("IMPORTANT TASKS");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_2.setBounds(23, 342, 313, 60);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("OTHER TASKS");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.MAGENTA);
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 25));
		lblNewLabel_4.setBounds(96, 517, 234, 60);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String health = textField.getText();
				String imp = textArea.getText();		
				String other = textArea_1.getText();
				PreparedStatement pst =(PreparedStatement)con.prepareStatement("insert into todo(health,important,others) values(?,?,?)");
				pst.setString(1, health);
				pst.setString(2,imp);
				pst.setString(3, other);
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "task added");
				textField.setText("");
				textArea.setText("");
				textArea_1.setText("");
				int a;
				PreparedStatement pst1=(PreparedStatement)con.prepareStatement("select * from todo");
				ResultSet rs=pst1.executeQuery();
				ResultSetMetaData rd=(ResultSetMetaData) rs.getMetaData();
				a=rd.getColumnCount();
				DefaultTableModel df=(DefaultTableModel)table_2.getModel();
				df.setRowCount(0);
				while(rs.next())
				{
					Vector v2 = new Vector();
					for(int i=1;i<=a;i++)
					{
						v2.add(rs.getString("id"));
						v2.add(rs.getString("health"));
						v2.add(rs.getString("important"));
						v2.add(rs.getString("others"));
						//df.addRow(v2);
					}
					df.addRow(v2);
				}
				}
				catch(Exception e1 ) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(208, 761, 103, 33);
		contentPane.add(btnNewButton);
		
		JButton btnDone = new JButton("CLOSE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDone.setBounds(370, 761, 103, 33);
		contentPane.add(btnDone);
		
		table = new JTable();
		table.setBounds(709, 455, 390, -298);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(835, 319, 1, 1);
		contentPane.add(table_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(677, 144, 577, 517);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter(){
			//@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel df=(DefaultTableModel)table_2.getModel();
				int selected=table_2.getSelectedRow();
				int id=Integer.parseInt(df.getValueAt(selected, 0).toString());
				textField.setText(df.getValueAt(selected, 1).toString());
				textArea.setText(df.getValueAt(selected, 2).toString());
				textArea_1.setText(df.getValueAt(selected, 3).toString());
				btnNewButton.setEnabled(false);
				
			}

		});
		scrollPane.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "HEALTH", "IMPORTANT", "OTHERS"
			}
		));
		
		JButton btnNewButton_2 = new JButton("TASK OVER");
		btnNewButton_2.setFont(new Font("Quicksand", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table_2.getSelectedRow();
				String cell = table_2.getModel().getValueAt(row, 0).toString();
				String sql = "DELETE FROM todo where id = " + cell;
				try {
					PreparedStatement pst = con.prepareStatement(sql);
					pst.execute();
					if(table_2.getSelectedRow() != -1) {
						DefaultTableModel df2 =(DefaultTableModel)table_2.getModel();
						df2.removeRow(row);}
					JOptionPane.showMessageDialog(null, "task completed!");
				}
				catch(Exception e5) {
					JOptionPane.showMessageDialog(null, e5);				}
			}
		});
		btnNewButton_2.setBounds(884, 714, 160, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Front_page fp = new Front_page();
				fp.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(0, 0, 108, 26);
		contentPane.add(btnNewButton_1);
		table_2.getColumnModel().getColumn(1).setMinWidth(20);
	}
}
