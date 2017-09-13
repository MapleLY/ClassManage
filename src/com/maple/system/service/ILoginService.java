package com.maple.system.service;

import java.util.List;

import com.maple.system.domain.Student;

public interface ILoginService {
	int checkLogin(String idstudent, String password);//账号密码查询
}
