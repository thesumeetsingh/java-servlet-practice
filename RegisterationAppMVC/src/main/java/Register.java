

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userfirstname= request.getParameter("firstname");
		String userlastname= request.getParameter("lastname");
		String username= request.getParameter("username");
		String useremail= request.getParameter("email");
		String userphone= request.getParameter("phone");
		String usercity= request.getParameter("city");
		String userpassword= request.getParameter("password");
		
		Model model= new Model();
		model.setCity(usercity);
		model.setFirstname(userfirstname);
		model.setLastname(userlastname);
		model.setUsername(username);
		model.setEmail(useremail);
		model.setPassword(userpassword);
		model.setPhone(userphone);
		
		HttpSession session= request.getSession();
		session.setAttribute("firstname", userfirstname);
		session.setAttribute("lastname", userlastname);
		
		int row=model.register();
		if(row!=0) {
			System.out.println("successfully registered");
			response.sendRedirect("success.jsp");
		}else {
			System.out.println("registration failed");
			response.sendRedirect("failure.jsp");
		}
		
		
		
		
	}

}
