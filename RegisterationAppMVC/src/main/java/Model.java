import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {

	private Connection connect=null;
	private PreparedStatement pstmt=null;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String city;
	private String phone;
	private String password;

	public void setCity(String city) {
		this.city = city;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int register() {
		int rowAffected=0;
		try {
			connect= JDBCUtil.getDBConnection();
			String sqlQuery="INSERT INTO USERS(firstname, lastname, username, email, city, phone, password) VALUES(?,?,?,?,?,?,?)";
			pstmt= connect.prepareStatement(sqlQuery);
			pstmt.setString(1,  firstname);
			pstmt.setString(2,  lastname);
			pstmt.setString(3,  username);
			pstmt.setString(4,  email);
			pstmt.setString(5,  city);
			pstmt.setString(6,  phone);
			pstmt.setString(7,  password);
			
			rowAffected= pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JDBCUtil.closeResource(connect, pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rowAffected;
		
	}
	
}
