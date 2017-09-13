package com.maple.system.service.Impl;

import java.util.List;

import com.maple.system.dao.IStudentDao;
import com.maple.system.domain.Student;
import com.maple.system.service.ILoginService;
import com.opensymphony.xwork2.ActionContext;

public class LoginServiceImpl implements ILoginService{
	private IStudentDao studentDao;
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	/**
	 * 账号密码查询
	 */
	@Override
	public int checkLogin(String idstudent, String password) {
		Integer idstudentInt = Integer.valueOf(idstudent);
		Student student = studentDao.getOne(idstudentInt);
		if(student == null){
			return 1;
		}else{
			if(!student.getPassword().equals(password)){
				return 2;
			}else{
				return 0;
			}
		}
	}
	
	
	
}
