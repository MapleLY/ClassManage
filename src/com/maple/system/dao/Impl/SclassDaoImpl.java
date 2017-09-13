package com.maple.system.dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.maple.system.dao.ISclassDao;
import com.maple.system.domain.Sclass;

public class SclassDaoImpl extends HibernateDaoSupport implements ISclassDao{

	/**
	 * 获取全部班级信息
	 */
	@Override
	public List<Sclass> getAll() {
		String hql = "from Sclass";
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 获取一个班级信息（根据编号）
	 */
	@Override
	public Sclass getOne(String idclass) {
		String hql = "from Sclass a where a.idclass =?";
		return (Sclass) getHibernateTemplate().find(hql, idclass).get(0);
	}
	
	/**
	 * 获取一个班级信息（根据名称）
	 */
	@Override
	public Sclass getOneByName(String name) {
		String hql = "from Sclass a where a.name =?";
		return (Sclass) getHibernateTemplate().find(hql, name).get(0);
	}


	/**
	 * 修改一个班级信息
	 */
	@Override
	public void updateOne(Sclass sclassOne) {
		getHibernateTemplate().update(sclassOne);
	}
	
	/**
	 * 删除一个班级信息
	 */
	@Override
	public void deleteOne(Sclass sclassOne) {
		getHibernateTemplate().delete(sclassOne);
	}

	@Override
	public List<Sclass> searchAll(String hql) {
		return getHibernateTemplate().find(hql);
	}


}
