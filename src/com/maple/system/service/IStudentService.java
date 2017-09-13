package com.maple.system.service;

import java.util.List;

public interface IStudentService {
	void getAll();//获取全部学生信息
	void getOne(String idstudent);//获取一个学生信息（根据学号）
	void getOneByName(String name);//获取一个学生信息（根据姓名）
	String updateOne(String idstudent, String name, String sex, String birthday, String phone, String address, String idclass);//修改一个学生信息
	String deleteOne(String idstudent);//删除一个学生信息
	void getOneStudentGrade(String idstudent);//统计某一个学生的所修课程信息、汇总出学分、不及格课程（标红）
	void getOneCourseGradeInfo(String idstudent);//获取一个学生的所修课程及其成绩
	String updateStudentGrade(List<String> studentcourseList);//修改学生某一课程的成绩
	
	void getList(int first, int datalength);
}
