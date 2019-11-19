import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBInfo {

	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public static Connection getConn()
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	
}
