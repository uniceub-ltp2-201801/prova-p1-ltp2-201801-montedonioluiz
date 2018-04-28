package model;

public class Course {
	
	private int id, hours, teacherid;
	
	private String name, major;
	
	public Course(int id, int hours, int teacherid, String name, String major) {
		super();
		this.id = id;
		this.hours = hours;
		this.teacherid = teacherid;
		this.name = name;
		this.major = major;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
}