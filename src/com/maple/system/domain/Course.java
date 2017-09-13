package com.maple.system.domain;

public class Course {
	private String idcourse;
	private String name;
	private String style;
	private Float score;
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
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Course [idcourse=" + idcourse + ", name=" + name + ", style=" + style + ", score=" + score + "]";
	}

	
	
	
}
