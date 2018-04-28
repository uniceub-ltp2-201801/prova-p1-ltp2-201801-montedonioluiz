package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDao {
	private Connection c;
	
	public CourseDao(Connection c) {
		this.c = c;	
	}
	
	public void addCourse(String name, String major, int hours, int teacherId) {
		try {
			PreparedStatement ps;
			
			ps = c.prepareStatement("INSERT INTO course (name, major, hours, teacherid) VALUES (?, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, major);
			ps.setInt(3, hours);
			ps.setInt(4, teacherId);
			ps.execute();
			
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCourse(int id) {
		try {
			PreparedStatement ps;
			
			ps = c.prepareStatement("DELETE FROM course WHERE id= ?");
			ps.setInt(1, id);
			ps.execute();
			
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
