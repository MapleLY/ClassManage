package com.maple.system.web.main;

import java.util.List;

import com.maple.system.service.ISclassService;
import com.opensymphony.xwork2.ActionSupport;

public class SclassAction extends ActionSupport{
	//****注入****
	private ISclassService sclassService;
	public void setSclassService(ISclassService sclassService) {
		this.sclassService = sclassService;
	}
	
	/*--------------------------*/
	/**
	 * 直接跳转页面
	 */
	public String inInfoPage() throws Exception{
		return "infoPage";
	}
	
	/*--------------------------*/
	/**
	 * 显示全部班级信息列表
	 * @throws Exception
	 */
	public void getAllInfo() throws Exception{
		sclassService.getAll();
	}
	
	/**
	 * 显示一个班级信息列表（根据编号）
	 * @throws Exception
	 */
	public void getOneInfo() throws Exception{
		sclassService.getOne(idclass);
	}
	
	/**
	 * 查询一个班级信息列表（根据名称）
	 * @throws Exception
	 */
	public void searchOneInfoByName() throws Exception{
		sclassService.getOneByName(searchList);
	}
	
	/**
	 * 修改一个班级信息列表
	 * @throws Exception
	 */
	public void updateOneInfo() throws Exception{
		sclassService.updateOne(idclass ,name);
	}
	
	/**
	 * 删除一个班级信息
	 * @throws Exception
	 */
	public void deleteOneInfo() throws Exception{
		sclassService.deleteOne(idclass);
	}
	
	
	
	/*--------------------------*/
	//****全局变量****
	private String idclass;
	private String name;

	//查询
	private List<String> searchList;
	
	public String getIdclass() {
		return idclass;
	}
	public void setIdclass(String idclass) {
		this.idclass = idclass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<String> searchList) {
		this.searchList = searchList;
	}
	
}
