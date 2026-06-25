

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control in first servlet");
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String city=request.getParameter("city");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String userpassword=request.getParameter("password");
		System.out.println("recieved all values (firstname, lastname, username, city, email, phone, password)");
		
		
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String user="root";
		String password="root";
		
		Connection connection;
		PreparedStatement pstmt;
		
		PrintWriter pw= response.getWriter();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");	
			connection= DriverManager.getConnection(url, user, password);
//			Statement statement= connection.createStatement();
			
			pstmt= connection.prepareStatement("INSERT INTO USERS( firstname, lastname, username, city, email, phone, password) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1,firstname);
			pstmt.setString(2,lastname);
			pstmt.setString(3,username);
			pstmt.setString(4,city);
			pstmt.setString(5,email);
			pstmt.setString(6,phone);
			pstmt.setString(7,userpassword);
			
			int rowAffected= pstmt.executeUpdate();
			if(rowAffected==0) {
				System.out.println("registration failed");
				pw.println("<h1> Registrationf failed</h1>");
			}else {
				System.out.println("registration successfull");
				pw.println("<h1> registration successfull!!!</h1>!!");
			}
			
			pstmt.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
	
			System.out.println("error loading driver class");
			
		} catch ( SQLException  e) {
			System.out.println("error geting connection");
		} finally{
			pw.close();
			
		}
		

	}

}
