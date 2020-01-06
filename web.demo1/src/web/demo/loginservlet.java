package web.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import oracle.jdbc.driver.OracleDriver;
/**
 * Servlet implementation class loginservlet
 */
@WebServlet(urlPatterns = "/loginservlet", initParams= {
@WebInitParam(name = "batches", value=("Java, Java Testing, Informatica "))})
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		String option = config.getInitParameter("batches");
		System.out.println("Options :"+option);
		String[]optionArr = option.split(",");

		PrintWriter outPrintWriter = response.getWriter();

		outPrintWriter.println("<html><body>");
		outPrintWriter.println("<form name='studentdata' action='loginservlet' "
		+ "method='post'>");
		outPrintWriter.println("Name <input type='text' name='name'/>");
		outPrintWriter.println("Batch Type :<select name='Batch'>");


		 for(String str:optionArr) {
		 outPrintWriter.println("<option value='"+str.trim()+"'>"+str.trim()+"</option>");
		 }

		outPrintWriter.println("</select>");

		outPrintWriter.println("<button type='submit'>Submit</button>");
		outPrintWriter.println("</form>");
		outPrintWriter.println("</body></html>");
		
		String username = request.getParameter("name");
		String batch = request.getParameter("Batch");
		System.out.println(username+batch);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//

		String Name = request.getParameter("name");
		String Batch = request.getParameter("Batch");

		response.setContentType("text/html");


		try {
		Driver d = new OracleDriver();
		DriverManager.registerDriver(d);

		String url = "jdbc:oracle:thin:@192.168.1.57:1522:xe";
		String userName = "hr";
		String password = "hr";
		Connection conn = DriverManager.getConnection(url,userName,password);
		System.out.println("Connection to Oracle Done");

		String query = "select * from students";
		PreparedStatement pstmt = conn.prepareStatement(query);

		pstmt.setString(1, Name);
		pstmt.setString(2, Batch);
		int rows = pstmt.executeUpdate();
		System.out.println(rows);

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		response.sendRedirect("displayservlet");
		}

		}