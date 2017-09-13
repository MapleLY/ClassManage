package com.maple.system.entities;

public class StudentCourseGrade {
	private String idcourse;
	private String name;
	private Double grade;
	
	public StudentCourseGrade(String idcourse, String name, Double grade) {
		super();
		this.idcourse = idcourse;
		this.name = name;
		this.grade = grade;
	}

	public String getIdcourse() {
		return idcourse;
	}

	public void setIdcourse(String idcourse) {
		this.idcourse = idcourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "StudentCourseGrade [idcourse=" + idcourse + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
	
}
