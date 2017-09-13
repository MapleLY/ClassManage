package com.maple.system.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.maple.system.domain.Sgrade;

public class GradeStatistical {
	
	//获取成绩数组
	public static List getList(List<Sgrade> courseGradeInfo){
		List listGrade = new ArrayList<>();
		for (Sgrade sgrade : courseGradeInfo) {
			listGrade.add(sgrade.getGrade());
		}
		return listGrade;
	}
	
	/**
	 * 获取成绩最大值
	 * @param courseGradeInfo
	 * @return
	 */
	public static double maxGrade(List<Sgrade> courseGradeInfo){
		return Collections.max(getList(courseGradeInfo));
	}
	
	/**
	 * 获取成绩最小值
	 * @param courseGradeInfo
	 * @return
	 */
	public static double minGrade(List<Sgrade> courseGradeInfo){
		return Collections.min(getList(courseGradeInfo));
	}
	
	/**
	 * 获取成绩平均值
	 * @param courseGradeInfo
	 * @return
	 */
	public static double average(List<Sgrade> courseGradeInfo){
		double gradeAll = 0;
		List list = getList(courseGradeInfo);
		for (int i = 0; i < list.size(); i++) {
			gradeAll += (double)list.get(i);
		}
		return gradeAll/list.size();
	}
}
