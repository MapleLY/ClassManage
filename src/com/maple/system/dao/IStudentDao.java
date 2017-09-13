package com.maple.system.dao;

import java.util.List;

import com.maple.system.domain.Student;

public interface IStudentDao {
	List<Student> getAll();//获取全部学生信息
	Student getOne(Integer idstudent);//获取一个学生信息（根据学号）
	Student getOneByName(String name);//获取一个学生信息（根据姓名）
	void updateOne(Student studentOne);//修改一个学生信息
	void deleteOne(Student studentOne);//删除一个学生信息
	
	List<Student> getList(int first, int datalength);//获取列表学生信息
}
