package com.maple.system.dao;

import java.util.List;

import com.maple.system.domain.Sclass;

public interface ISclassDao {
	List<Sclass> getAll();//获取全部班级信息
	Sclass getOne(String idclass);//获取一个班级信息（根据编号）
	Sclass getOneByName(String name);//获取一个班级信息（根据名称）
	void updateOne(Sclass sclassOne);//修改一个班级信息
	void deleteOne(Sclass sclassOne);//删除一个班级信息
	
	List<Sclass> searchAll(String hql);
}
