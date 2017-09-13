package com.maple.system.dao;

import java.util.List;

import com.maple.system.domain.Sgrade;

public interface ISgradeDao {
	List<Sgrade> getOneToAll(Integer idstudent);//通过一个学生学号获取所有信息（包括课程和成绩）
	List<Sgrade> getCourseToAll(String idcourse);//通过课程号获取所有信息（包括学号和成绩）
	void updateOneGrade(Sgrade sgrade);//通过学号和课程修改学生成绩
}
