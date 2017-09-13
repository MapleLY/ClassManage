package com.maple.system.service;

import java.util.List;

public interface ISclassService {
	void getAll();//获取全部班级信息
	void getOne(String idclass);//获取一个班级信息（根据编号）
	void getOneByName(List<String> searchList);//获取一个班级信息（根据名称）
	String updateOne(String idclass, String name);//修改一个班级信息
	String deleteOne(String idclass);//删除一个班级信息
	
}
