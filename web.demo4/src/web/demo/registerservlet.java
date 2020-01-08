package web.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.demo4.model.Student;
import web.demo4.model.StudentDao;

/**
 * Servlet implementation class registerservlet
 */
@WebServlet("/register")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("del")!=null) {
		String delete_row = request.getParameter("a");
		System.out.println("delete"+delete_row);
		StudentDao studDao_delete_row = new StudentDao();
		StudentDao.delete_table(delete_row);
		List<Student> students_delete = null;
		students_delete = StudentDao.Display();
		request.setAttribute("students", students_delete);
		request.getRequestDispatcher("register.jsp").forward(request, response);
		//StudentDao.shutdown();
		request.setAttribute("students", students_delete);
		request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		
		else if(request.getParameter("update")!=null) 
		{
		String update_row = request.getParameter("b");
		StudentDao studDao_update_row = new StudentDao();
		StudentDao.update_table(update_row);
		List<Student> students_update = null;
		students_update = StudentDao.Display();
		//StudentDao.shutdown();
		request.setAttribute("students", students_update);
		request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String phone = request.getParameter("phone").trim();
		String batch = request.getParameter("batch").trim();
		
		Student students = new Student(name,email,phone,batch);
		StudentDao studDao = new StudentDao();
		
		StudentDao.create(students);
		List<Student> students1 = null;
		students1 = StudentDao.Display();
		
		//StudentDao.shutdown();
		request.setAttribute("students", students1);
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

}
