package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Connections;
import dao.CourseDao;
import dao.TeacherDao;
import model.Teacher;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//addCourse(String name, String major, int hours, int teacherId)
		try {
			
			Connection c = Connections.getConnection();
			
			CourseDao cd = new CourseDao(c);
			TeacherDao td = new TeacherDao(c);
			
			ArrayList<Teacher> teachers = td.getTeachers(); 
			
			cd.addCourse(request.getParameter("name"),
						 request.getParameter("major"), 
						 Integer.parseInt(request.getParameter("hours")), 
						 Integer.parseInt(request.getParameter("teacherId")));
			
			request.setAttribute("teachers", teachers);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListTeachers.jsp");
			
			rd.forward(request, response);
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
