package com.maple.system.web.main;

import java.util.List;

import com.maple.system.service.IStudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport{
	//****注入****
	private IStudentService studentService;
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	/*--------------------------*/
	/**
	 * 直接跳转页面
	 */
	public String inInfoPage() throws Exception{
		return "infoPage";
	}
	public String inResultPage() throws Exception{
		return "resultPage";
	}
	public String inUpdateGradePage() throws Exception{
		return "updateGradePage";
	}
	
	/*--------------------------*/
	public void getSomeInfo() throws Exception{
		studentService.getList(first, datalength);
	}
	
	/**
	 * 显示全部学生信息列表
	 * @throws Exception
	 */
	public void getAllInfo() throws Exception{
		studentService.getAll();
	}
	
	/**
	 * 显示一个学生信息列表（根据学号）
	 * @throws Exception
	 */
	public void getOneInfo() throws Exception{
		studentService.getOne(idstudent);
	}
	
	/**
	 * 查询一个学生信息列表（根据姓名）
	 * @throws Exception
	 */
	public void searchOneInfoByName() throws Exception{
		studentService.getOneByName(name);
	}
	
	/**
	 * 查询一个学生的课程及其成绩
	 * @throws Exception
	 */
	public void searchStudentCourseGrade() throws Exception{
		studentService.getOneCourseGradeInfo(idstudent);
	}
	
	/**
	 * 修改一个学生课程的成绩
	 * @throws Exception
	 */
	public void updateStudentCourseGrade() throws Exception{
		
		studentService.updateStudentGrade(studentcourseList);
	}
	
	/**
	 * 统计某一个学生的所修课程信息、汇总出学分、不及格课程（标红）
	 * @throws Exception
	 */
	public void searchOneGradeResult() throws Exception{
		studentService.getOneStudentGrade(idstudent);
	}
	
	/**
	 * 修改一个学生信息列表
	 * @throws Exception
	 */
	public void updateOneInfo() throws Exception{
		studentService.updateOne(idstudent, name, sex, birthday, phone, address, idclass);
	}
	
	/**
	 * 删除一个学生信息
	 * @throws Exception
	 */
	public void deleteOneInfo() throws Exception{
		studentService.deleteOne(idstudent);
	}
	
	/*--------------------------*/
	//****全局变量****
	//学生信息
	private String idstudent;
	private String name;
	private String sex;
	private String birthday;
	private String phone;
	private String address;
	private String idclass;
	//学生课程成绩
	private String idcourse;
	private String grade;
	private List<String> studentcourseList;
	//分页
	private int first;
	private int datalength;
	
	
	public String getIdstudent() {
		return idstudent;
	}

	public void setIdstudent(String idstudent) {
		this.idstudent = idstudent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdclass() {
		return idclass;
	}

	public void setIdclass(String idclass) {
		this.idclass = idclass;
	}

	public String getIdcourse() {
		return idcourse;
	}

	public void setIdcourse(String idcourse) {
		this.idcourse = idcourse;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<String> getStudentcourseList() {
		return studentcourseList;
	}

	public void setStudentcourseList(List<String> studentcourseList) {
		this.studentcourseList = studentcourseList;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getDatalength() {
		return datalength;
	}

	public void setDatalength(int datalength) {
		this.datalength = datalength;
	}



	
	
}
