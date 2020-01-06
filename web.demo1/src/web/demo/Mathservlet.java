package web.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Mathservlet
 */
//@WebServlet("/Mathservlet")
public class Mathservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mathservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String first_str = request.getParameter("first");
		String second_str = request.getParameter("second");
		int num1 = Integer.parseInt(first_str);
		int num2 = Integer.parseInt(second_str);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Result:");
		//System.out.println("Username is" + username);
		if(request.getParameter("add")!=null)
		{
			
			out.println(num1+num2);
		}
		if(request.getParameter("sub")!=null)
		{
			//PrintWriter out = response.getWriter();
			out.println(num1-num2);
		}
		out.println("</body>");
		out.print("</html>");
			
		//PrintWriter out = response.getWriter();
		//out.println("hello"+username);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
