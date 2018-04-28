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
 * Servlet implementation class DetailTeacher
 */
@WebServlet("/DetailTeacher")
public class DetailTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailTeacher() {
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
			
			Teacher t = td.getTeacher(Integer.parseInt(request.getParameter("id")));
		    String d = td.getDegreeName(t.getDegree());		
		    ArrayList<Course> cs = td.getCourses(t.getId());
			
			request.setAttribute("teacher", t);
			request.setAttribute("degree", d);
			request.setAttribute("courses", cs);
			System.out.println(t);
			
			RequestDispatcher rd = request.getRequestDispatcher("DetailTeacher.jsp");
			
			rd.forward(request, response);
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
