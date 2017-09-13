package com.maple.system.domain;

import java.io.Serializable;

public class Sgrade implements Serializable{
	private Integer idstudent;
	private String idcourse;
	private Double grade;
	
	
	public Sgrade() {
		super();
	}
	public Sgrade(Integer idstudent, String idcourse, Double grade) {
		super();
		this.idstudent = idstudent;
		this.idcourse = idcourse;
		this.grade = grade;
	}
	public Integer getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(Integer idstudent) {
		this.idstudent = idstudent;
	}
	public String getIdcourse() {
		return idcourse;
	}
	public void setIdcourse(String idcourse) {
		this.idcourse = idcourse;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Sgrade [idstudent=" + idstudent + ", idcourse=" + idcourse + ", grade=" + grade + "]";
	}

	
}
