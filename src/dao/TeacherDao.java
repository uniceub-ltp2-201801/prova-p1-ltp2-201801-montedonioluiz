package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Course;
import model.Teacher;

public class TeacherDao {
	private Connection c;
	
	public TeacherDao(Connection c) {
		this.c = c;	
	}
	
	public ArrayList<Teacher> getTeachers() {
		ArrayList<Teacher> result = new ArrayList<Teacher>();
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			
			ps = c.prepareStatement("SELECT * FROM teacher ORDER BY name asc");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(getTeacher(rs.getInt("id")));
			}
			
			
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	public Teacher getTeacher(int id) {
		Teacher t = new Teacher();
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			
			ps = c.prepareStatement("SELECT * FROM teacher WHERE id = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			rs.first();
			
			String date = "" + rs.getDate("dob"); 
			int d = Integer.parseInt(date.substring(8));
			int m = Integer.parseInt(date.substring(5,7));
			int y = Integer.parseInt(date.substring(0, 4));//YYYY-MM-DD
			
			LocalDate dob = LocalDate.of(y, m, d);
			
			t = new Teacher(rs.getInt("id"), rs.getInt("degree"), rs.getString("name"), rs.getString("momname"), dob); //int id, int degree, String name, String momname, LocalDate dob) {
			System.out.println(t);
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return t;
	}
	
	public String getDegreeName(int degreeId) {
		String degree = "";
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			
			ps = c.prepareStatement("SELECT title FROM degree WHERE id = ?");
			ps.setInt(1, degreeId);
			
			rs = ps.executeQuery();
			
			rs.first();
			
			degree = rs.getString("title");
			
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return degree;
	}
	
	public int getDegreeId(String name) {
		int degree = 0;
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			
			ps = c.prepareStatement("SELECT id FROM degree WHERE title = ?");
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			rs.first();
			
			degree = rs.getInt("id");
			
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return degree;
	}
	
	public ArrayList<Course> getCourses(int teacherId){
		ArrayList<Course> cs = new ArrayList<Course>();
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			
			ps = c.prepareStatement("SELECT * FROM course WHERE teacherid = ?");
			ps.setInt(1, teacherId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cs.add(new Course(rs.getInt("id"), rs.getInt("hours"), rs.getInt("teacherid"), rs.getString("name"), rs.getString("major")));//int id, int hours, int teacherid, String name, String major
			}
			
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return cs;
	}
	
	public ArrayList<Teacher> getTeachersByDegree(String degree){
		ArrayList<Teacher> ts = new ArrayList<Teacher>();
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			ps = c.prepareStatement("SELECT id FROM teacher WHERE degree = ?");
			ps.setInt(1, getDegreeId(degree));
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ts.add(getTeacher(rs.getInt("id")));//int id, int hours, int teacherid, String name, String major
			}
			
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ts;
	}
	
}
