package com.maple.system.dao.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.maple.system.dao.ISgradeDao;
import com.maple.system.domain.Sgrade;

public class SgradeDaoImpl extends HibernateDaoSupport implements ISgradeDao {

	/**
	 * 通过一个学生学号获取所有信息（包括课程和成绩）
	 */
	@Override
	public List<Sgrade> getOneToAll(Integer idstudent) {
		String hql = "from Sgrade a where a.idstudent =?";
		return getHibernateTemplate().find(hql, idstudent);
	}

	/**
	 * 通过课程号获取所有信息（包括学号和成绩）
	 */
	@Override
	public List<Sgrade> getCourseToAll(String idcourse) {
		String hql = "from Sgrade a where a.idcourse =?";
		return getHibernateTemplate().find(hql, idcourse);
	}

	/**
	 * 通过学号和课程修改学生成绩
	 */
	@Override
	public void updateOneGrade(Sgrade sgrade) {
		getHibernateTemplate().update(sgrade);
	}	
	
}
