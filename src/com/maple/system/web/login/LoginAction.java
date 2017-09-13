package com.maple.system.web.login;

import java.util.List;

import com.maple.system.domain.Student;
import com.maple.system.service.ILoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	//****注入****
	private ILoginService loginService;
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	
	/*--------------------------*/
	
	/**
	 * 直接跳转页面
	 */
	
	public String inTitlePage() throws Exception{
		return "titlePage";
	}
	
	public String inPage() throws Exception{
		return "loginPage";
	}
	
	public String inLeftPage() throws Exception{
		return "leftPage";
	}
	
	
	public String inSclassInfo() throws Exception{
		return "sclassinfoPage";
	}

	/**
	 * 账号密码检查（登录）
	 * @return
	 * @throws Exception
	 */
	public String checkLogin() throws Exception{
		int checkLogin = loginService.checkLogin(idstudent, password);
		if(checkLogin == 0){
			return "mainPage";
		}else if(checkLogin == 1){
			return "loginPage";
		}else if(checkLogin == 2){
			return "loginPage";
		}
		return "loginPage";
	}
	
	
	
	/*--------------------------*/
	//****全局变量****
	private String idstudent;
	private String password;
	
	public String getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(String idstudent) {
		this.idstudent = idstudent;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
