package com.maple.system.dao;

import java.util.List;

import com.maple.system.domain.Course;
import com.maple.system.domain.Student;

public interface ICourseDao {
	List<Course> getAll();//获取全部课程信息
	Course getOne(String idcourse);//获取一个课程信息（根据课程编号）
	Course getOneByName(String name);//获取一个课程信息（根据课程名称）
	void updateOne(Course courseOne);//修改一个课程信息
	void deleteOne(Course courseOne);//删除一个课程信息
}
