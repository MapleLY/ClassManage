package com.maple.system.entities;

public class CourseGradeResult {
	private double maxgrade;
	private double mingrade;
	private double averagegrade;
	
	public CourseGradeResult(double maxgrade, double mingrade, double averagegrade) {
		super();
		this.maxgrade = maxgrade;
		this.mingrade = mingrade;
		this.averagegrade = averagegrade;
	}
	
	public double getMaxgrade() {
		return maxgrade;
	}
	public void setMaxgrade(double maxgrade) {
		this.maxgrade = maxgrade;
	}
	public double getMingrade() {
		return mingrade;
	}
	public void setMingrade(double mingrade) {
		this.mingrade = mingrade;
	}
	public double getAveragegrade() {
		return averagegrade;
	}
	public void setAveragegrade(double averagegrade) {
		this.averagegrade = averagegrade;
	}
	
	@Override
	public String toString() {
		return "CourseGradeResult [maxgrade=" + maxgrade + ", mingrade=" + mingrade + ", averagegrade=" + averagegrade
				+ "]";
	}
	
	
}
