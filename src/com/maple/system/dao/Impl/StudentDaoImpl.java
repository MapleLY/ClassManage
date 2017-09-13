package com.maple.system.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.maple.system.dao.IStudentDao;
import com.maple.system.domain.Student;

public class StudentDaoImpl extends HibernateDaoSupport implements IStudentDao{

	/**
	 * 获取全部学生信息
	 */
	@Override
	public List<Student> getAll() {
		String hql="from Student";
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 获取一个学生信息（根据学号）
	 */
	@Override
	public Student getOne(Integer idstudent) {
		String hql = "from Student a where a.idstudent =?";
		return (Student) getHibernateTemplate().find(hql, idstudent).get(0);
	}

	/**
	 * 获取一个学生信息（根据姓名）
	 */
	@Override
	public Student getOneByName(String name) {
		String hql = "from Student a where a.name =?";
		return (Student) getHibernateTemplate().find(hql, name).get(0);
	}

	/**
	 * 修改一个学生信息
	 */
	@Override
	public void updateOne(Student studentOne) {
		getHibernateTemplate().update(studentOne);
	}

	/**
	 * 删除一个学生信息
	 */
	@Override
	public void deleteOne(Student studentOne) {
		getHibernateTemplate().delete(studentOne);
	}

	@Override
	public List<Student> getList(int first, int datalength) {
		String hql = "from Student";
		Session ssn = getSession();
		Query query = ssn.createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(datalength);
		List<Student> readyGet = query.list();
		ssn.close();
		return readyGet;
	}

}
