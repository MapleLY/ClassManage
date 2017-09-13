package com.maple.system.service;

public interface ICourseService {
	void getAll();//获取全部课程信息
	void getOne(String idcourse);//获取一个课程信息（根据课程编号）
	void getOneByName(String name);//获取一个课程信息（根据课程名称）
	String updateOne(String idcourse, String name, String style, String score);//修改一个课程信息
	String deleteOne(String idcourse);//删除一个课程信息
	void getOneCourseGrade(String idcourse);//统计每一门课程的最高分、最低分和平均分
}
