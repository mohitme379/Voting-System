import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VotingCandidate extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VotingCandidate frame = new VotingCandidate();
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
	public VotingCandidate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		
		JRadioButton r1 = new JRadioButton("Rahul Yadav");
		buttonGroup.add(r1);
		
		JRadioButton r2 = new JRadioButton("Pooja Meena");
		buttonGroup.add(r2);
		
		JRadioButton r3 = new JRadioButton("Vikas Choudhary");
		buttonGroup.add(r3);
		
		JRadioButton r4 = new JRadioButton("Tarunveer Singh Sekhawat");
		buttonGroup.add(r4);
		
		JRadioButton r5 = new JRadioButton("Lokesh Kumar");
		buttonGroup.add(r5);
		
		JRadioButton r6 = new JRadioButton("Priyanshu Sharma");
		buttonGroup.add(r6);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con=DBInfo.getConn();
				String query1 = "";
				
				if(r1.isSelected())
				{
				query1 = "update candidate set votes = votes+1 where Name = 'Rahul Yadav'";
				}
				if(r2.isSelected())
				{
				query1 = "update candidate set votes = votes+1 where Name = 'Pooja Meena'";
				}
				if(r3.isSelected())
				{
				query1 = "update candidate set votes = votes+1 where Name = 'Vikas Choudhary'";
				}
				if(r4.isSelected())
				{
				query1 = "update candidate set votes = votes+1 where Name = 'Tarunveer Singh Sekhawat'";
				}
				if(r5.isSelected())
				{
				query1 = "update candidate set votes = votes+1 where Name = 'Lokesh Kumar'";
				}
				if(r6.isSelected())
				{
				query1 = "update candidate set votes = votes+1 where Name = 'Priyanshu Sharma'";
				}
				
				
				
				try {
					PreparedStatement ps=con.prepareStatement(query1);
					
					ps.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
				JOptionPane.showMessageDialog(getParent(), "Thanks For Voting !! \n Every Vote Counts !!", "Thanks For Voting", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSubmit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(r4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(r3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(r6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(r2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(r1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(r5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addComponent(r1)
					.addGap(18)
					.addComponent(r2)
					.addGap(18)
					.addComponent(r3)
					.addGap(18)
					.addComponent(r4)
					.addGap(18)
					.addComponent(r5)
					.addGap(18)
					.addComponent(r6)
					.addGap(26)
					.addComponent(btnSubmit)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
