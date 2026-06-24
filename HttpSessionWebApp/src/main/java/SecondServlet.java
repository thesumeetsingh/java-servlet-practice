

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("control in second servlet");
			HttpSession session =request.getSession(false);
			
			String fname=(String)session.getAttribute("firstname");
			String lname=(String)session.getAttribute("lastname");
			String uname=(String)session.getAttribute("username");
			String city=(String)session.getAttribute("city");
			PrintWriter pw= response.getWriter();
			pw.println("<h1>Hello!! "+fname+" "+lname+"</h1><br><p>[username:"+uname+"</p><br><p>from "+city+"</p>");
			pw.close();
	}

}
