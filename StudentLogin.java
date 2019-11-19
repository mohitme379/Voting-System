import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StudentLogin extends JFrame {

	
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Connection con = DBInfo.getConn();
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		
		JLabel lblStudentName = new JLabel("Student Name");
		
		JLabel lblRollNo = new JLabel("Roll No.");
		
		JLabel lblVotingId = new JLabel("Voting Id");
		
		t1 = new JTextField();
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					String s1 = t1.getText();
					String s2 = t2.getText();
					String s3 = t3.getText();
					String str1 = "";
					String str2 = "";
					
					String query = "select * from registration where Name = ? and Rollno = ?";
					String query2 = "select * from voters";
					String query3 = "INSERT INTO voters VALUES (?,?)";
					String a = "";
					String b = "";
					String c = "";
					
					
					PreparedStatement ps = DBInfo.getConn().prepareStatement(query);
					PreparedStatement ps2 = DBInfo.getConn().prepareStatement(query2);
					PreparedStatement ps3 = DBInfo.getConn().prepareStatement(query3);
					ps.setString(1, s1);
					ps.setString(2, s2);
					ps3.setString(1, s1);
					ps3.setString(2, s2);
					
					ResultSet res = ps.executeQuery();
					ResultSet res2 = ps2.executeQuery();
					
					while(res2.next())
					{
					str1 = res2.getString("Name");
					str2 = res2.getString("Id");
					break;
					}
				
					if(str1.equalsIgnoreCase(s1) && str2.equalsIgnoreCase(s2))
					{
						JOptionPane.showMessageDialog(getParent(), "You have already voted !!", "Error !", JOptionPane.ERROR_MESSAGE);
						t1.setText(null);
						t2.setText(null);
						t3.setText(null);
					}
					else
					{
					while(res.next())
					{
						a = res.getString("Name");
						b = res.getString("Rollno");
						c = res.getString("Id");
						
						if(a.equalsIgnoreCase(s1) && b.equalsIgnoreCase(s2))
						{
							if(c.equalsIgnoreCase(s3))
							{
								ps3.executeUpdate()	;
								new VotingCandidate().setVisible(true);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(getParent(), "Id does not match", "Error !", JOptionPane.ERROR_MESSAGE);
								t3.setText(null);
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(getParent(), "Wrong Input", "Error !", JOptionPane.ERROR_MESSAGE);
							t1.setText(null);
							t2.setText(null);
							t3.setText(null);
						}
					
					}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblStudentName, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addComponent(lblRollNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblVotingId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSubmit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(t1, Alignment.TRAILING)
						.addComponent(t2, Alignment.TRAILING)
						.addComponent(t3, Alignment.TRAILING))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRollNo)
						.addComponent(t2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVotingId)
						.addComponent(t3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(btnSubmit)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
