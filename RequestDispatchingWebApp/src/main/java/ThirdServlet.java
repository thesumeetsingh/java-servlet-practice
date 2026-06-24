

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/Servlet3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("control in third servlet");
		RequestDispatcher reqDis= request.getRequestDispatcher("/Servlet4");
		reqDis.include(request, response);
		
		
		System.out.println("control in third servlet after fourth servlet");
		PrintWriter pw= response.getWriter();
		pw.println("<h1> Response from THIRD servklet</h1>");
		pw.close();
	}

}
