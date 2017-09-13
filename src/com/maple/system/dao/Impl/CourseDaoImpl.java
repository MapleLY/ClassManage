package com.maple.system.dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.maple.system.dao.ICourseDao;
import com.maple.system.domain.Course;

public class CourseDaoImpl extends HibernateDaoSupport implements ICourseDao{

	/**
	 * 获取全部课程信息
	 */
	@Override
	public List<Course> getAll() {
		String hql = "from Course";
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 获取一个课程信息（根据课程编号）
	 */
	@Override
	public Course getOne(String idcourse) {
		String hql = "from Course a where a.idcourse =?";
		return (Course) getHibernateTemplate().find(hql, idcourse).get(0);
	}

	/**
	 * 获取一个课程信息（根据课程名称）
	 */
	@Override
	public Course getOneByName(String name) {
		String hql = "from Course a where a.name =?";
		return (Course) getHibernateTemplate().find(hql, name).get(0);
	}

	/**
	 * 修改一个课程信息
	 */
	@Override
	public void updateOne(Course courseOne) {
		getHibernateTemplate().update(courseOne);
	}

	/**
	 * 删除一个课程信息
	 */
	@Override
	public void deleteOne(Course courseOne) {
		getHibernateTemplate().delete(courseOne);
	}

}
