package web.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

/**
 * Servlet implementation class displayservlet
 */
@WebServlet("/displayservlet")
public class displayservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.println("<html><body>");
		outPrintWriter.println("hello");
		Driver d = new OracleDriver();
		try {
			DriverManager.registerDriver(d);
			String url = "jdbc:oracle:thin:@192.168.1.57:1522:xe";
			String userName = "hr";
			String password = "hr";
			Connection conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Connection to Oracle Done");
			String query = "select * from students";
			PreparedStatement stmt = conn.prepareStatement(query);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				//System.out.print("ID := "+rs.getInt("patient_id"));
				outPrintWriter.println("  Name := "+ rs.getString("names")+" "+rs.getString("batches"));
				outPrintWriter.println("<br>");
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
