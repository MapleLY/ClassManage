package com.maple.system.entities;

public class StudentGradeResult extends Object{
	private String idcourse;
	private String coursename;
	private String style;
	private Float coursescore;
	private Double grade;
	private Float studentscore;
	private String passornot;
	
	public StudentGradeResult(String idcourse, String coursename, String style, Float coursescore, Double grade,
			Float studentscore, String passornot) {
		super();
		this.idcourse = idcourse;
		this.coursename = coursename;
		this.style = style;
		this.coursescore = coursescore;
		this.grade = grade;
		this.studentscore = studentscore;
		this.passornot = passornot;
	}

	public String getIdcourse() {
		return idcourse;
	}

	public void setIdcourse(String idcourse) {
		this.idcourse = idcourse;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Float getCoursescore() {
		return coursescore;
	}

	public void setCoursescore(Float coursescore) {
		this.coursescore = coursescore;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Float getStudentscore() {
		return studentscore;
	}

	public void setStudentscore(Float studentscore) {
		this.studentscore = studentscore;
	}

	public String getPassornot() {
		return passornot;
	}

	public void setPassornot(String passornot) {
		this.passornot = passornot;
	}

	@Override
	public String toString() {
		return "StudentGradeResult [idcourse=" + idcourse + ", coursename=" + coursename + ", style=" + style
				+ ", coursescore=" + coursescore + ", grade=" + grade + ", studentscore=" + studentscore
				+ ", passornot=" + passornot + "]";
	}
	
	
}
