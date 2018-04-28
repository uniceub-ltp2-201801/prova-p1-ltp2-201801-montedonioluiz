package model;

import java.time.LocalDate;

public class Teacher {

		private int id, degree;
		
		private String name, momName;
		
		private LocalDate dob;
		
		public Teacher() {
			
		}
		
		public Teacher(int id, int degree, String name, String momName, LocalDate dob) {
			super();
			this.id = id;
			this.degree = degree;
			this.name = name;
			this.momName = momName;
			this.dob = dob;
		}

		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getDegree() {
			return degree;
		}


		public void setDegree(int degree) {
			this.degree = degree;
		}

		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getMomName() {
			return momName;
		}


		public void setMomName(String momName) {
			this.momName = momName;
		}


		public LocalDate getDob() {
			return dob;
		}


		public void setDob(LocalDate dob) {
			this.dob = dob;
		}
		
		public String toString() {
			return getId() + " " + getName() + " " + getDob() + " " + getMomName() + " " + getDegree();
		}
		
}