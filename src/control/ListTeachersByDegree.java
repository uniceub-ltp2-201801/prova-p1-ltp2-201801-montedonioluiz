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
import dao.TeacherDao;
import model.Course;
import model.Teacher;

/**
 * Servlet implementation class ListTeachersByDegree
 */
@WebServlet("/ListTeachersByDegree")
public class ListTeachersByDegree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTeachersByDegree() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Connection c = Connections.getConnection();
			
			TeacherDao td = new TeacherDao(c);
		    ArrayList<Teacher> teachers = td.getTeachers();
		    ArrayList<Teacher> teachersFiltered = td.getTeachers();
		    
		    teachersFiltered = td.getTeachersByDegree(request.getParameter("degree"));
		    request.setAttribute("teachersFiltered", teachersFiltered);
		    
		    
		    
		    
			request.setAttribute("teachers", teachers);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListTeachers.jsp");
			
			rd.forward(request, response);
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
