
import java.io.PrintWriter;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/Servlet1")
public class FirstServlet extends HttpServlet {
	static {
		System.out.println("First Servlet Loaded");
	}
	public FirstServlet(){
		System.out.println("OBJECT of first servlet created");
	}
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("control in first servlet");
		
		RequestDispatcher reqDis = request.getRequestDispatcher("/Servlet2");
		reqDis.forward(request, response);
		
		
		PrintWriter pw= response.getWriter();
		pw.println("<h1>response from FIRST servlet</h1>");
		pw.close();
	}
}
