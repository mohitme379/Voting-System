import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class RecordInserting extends JFrame {
	
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2;
	
	public RecordInserting()
	{
		setLayout(new GridLayout(5,2));
		setTitle("Registration");
		setSize(500, 300);
		setLocationRelativeTo(this);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		l1 = new JLabel("Name");
		l2 = new JLabel("Rollno");
		l3 = new JLabel("Id");
		
		t1 = new JTextField(20);
		t2 = new JTextField(20);
		t3 = new JTextField(20);
		
		b1 = new JButton("Save");
		b2 = new JButton("Reset");
		
		
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);		
		add(b1);
		add(b2);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i = 0;
				String s1 = t1.getText();
				String s2 = t2.getText();
				String s3 = t3.getText();
			
				
				Connection con=DBInfo.getConn();
				
				String query = "insert into registration values(?, ?, ?)";
				
				try
				{
			    PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, s3);
				
				i=ps.executeUpdate();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				if(i==1)
				{
					
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				}	
				if(i==0)
				{
					JOptionPane.showMessageDialog(getParent(), " Please fill the complete form !","Error",JOptionPane.ERROR_MESSAGE);	
					
				}
				
			  
		  }
				
			});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
			}
		});
		
	}

	public static void main(String[] args) {
		
		new RecordInserting().setVisible(true);
		
		
}

}
