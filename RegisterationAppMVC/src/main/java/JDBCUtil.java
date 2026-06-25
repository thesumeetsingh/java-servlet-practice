import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCUtil {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Driver Registered successfully");
	}
	
	public static Connection getDBConnection() throws SQLException{
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String user="root";
		String password="root";
		
		Connection connect= DriverManager.getConnection(url, user, password);
		return connect;
	}
	
	public static void closeResource(Connection connect, Statement statement) throws SQLException{
		if(connect!=null) {
			connect.close();
		}if(statement!=null) {
			statement.close();
		}
	}
	
	
}
