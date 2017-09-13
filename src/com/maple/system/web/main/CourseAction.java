package com.maple.system.web.main;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.maple.system.service.ICourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONSerializer;

public class CourseAction extends ActionSupport{
	//****注入****
	private ICourseService courseService;
	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}
	
	/*--------------------------*/
	/**
	 * 直接跳转页面
	 */
	public String inInfoPage() throws Exception{
		return "infoPage";
	}
	public String inResultPage() throws Exception{
		System.out.println("进入result");
		return "resultPage";
	}
	
	/*--------------------------*/
	/*--------------------------*/
	/**
	 * 显示全部课程信息列表
	 * @throws Exception
	 */
	public void getAllInfo() throws Exception{
		courseService.getAll();
	}
	
	/**
	 * 显示一个课程信息列表（根据编号）
	 * @throws Exception
	 */
	public void getOneInfo() throws Exception{
		courseService.getOne(idcourse);
	}
	
	/**
	 * 查询一个课程信息列表（根据名称）
	 * @throws Exception
	 */
	public void searchOneInfoByName() throws Exception{
		courseService.getOneByName(name);
	}
	
	/**
	 * 统计每一门课程的最高分、最低分和平均分
	 * @throws Exception
	 */
	public void searchOneGradeResult() throws Exception{
		courseService.getOneCourseGrade(idcourse);
	}
	
	/**
	 * 修改一个课程信息列表
	 * @throws Exception
	 */
	public void updateOneInfo() throws Exception{
		courseService.updateOne(idcourse ,name, style, score);
	}
	
	/**
	 * 删除一个课程信息
	 * @throws Exception
	 */
	public void deleteOneInfo() throws Exception{
		courseService.deleteOne(idcourse);
	}
	
	/*--------------------------*/
	//****全局变量****
	private String idcourse;
	private String name;
	private String style;
	private String score;
	public String getIdcourse() {
		return idcourse;
	}

	public void setIdcourse(String idcourse) {
		this.idcourse = idcourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
}
