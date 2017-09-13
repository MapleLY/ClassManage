package com.maple.system.service.Impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.maple.system.dao.ICourseDao;
import com.maple.system.dao.ISgradeDao;
import com.maple.system.dao.IStudentDao;
import com.maple.system.domain.Course;
import com.maple.system.domain.Sclass;
import com.maple.system.domain.Sgrade;
import com.maple.system.domain.Student;
import com.maple.system.entities.StudentCourseGrade;
import com.maple.system.entities.StudentGradeResult;
import com.maple.system.service.IStudentService;
import com.maple.system.utils.PassJudgment;
import com.maple.system.utils.ScoreCalculation;

import net.sf.json.JSONSerializer;

public class StudentServiceImpl implements IStudentService{
	private IStudentDao studentDao;
	private ISgradeDao sgradeDao;
	private ICourseDao courseDao;
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public void setSgradeDao(ISgradeDao sgradeDao) {
		this.sgradeDao = sgradeDao;
	}
	public void setCourseDao(ICourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	/*--------------------------*/
	//****全局变量****
	public HttpServletResponse response;//for ajax
	public PrintWriter out;//for ajax
	
	/*--------------------------*/
	/**
	 * 初始化ajax响应流
	 * @throws Exception
	 */
	public void initAjax() throws Exception{
		response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter();
	}
	
	/*--------------------------*/
	/**
	 * 获取全部学生信息
	 */
	@Override
	public void getAll() {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(studentDao.getAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个学生信息（根据学号）
	 */
	@Override
	public void getOne(String idstudent) {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(studentDao.getOne(Integer.valueOf(idstudent))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个学生信息（根据姓名）
	 */
	@Override
	public void getOneByName(String name) {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(studentDao.getOneByName(name)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改一个学生信息
	 */
	@Override
	public String updateOne(String idstudent, String name, String sex, String birthday, String phone, String address, String idclass) {
		try {
			initAjax();
			
			Student studentOne = studentDao.getOne(Integer.valueOf(idstudent));
			studentOne.setName(name);
			studentOne.setSex(sex);
			studentOne.setBirthday(birthday);
			studentOne.setPhone(phone);
			studentOne.setAddress(address);
			studentOne.setIdclass(idclass);
			
			studentDao.updateOne(studentOne);
			out.print(JSONSerializer.toJSON(studentDao.getOne(studentOne.getIdstudent())));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("false");
		return null;
	}
	
	/**
	 * 删除一个学生信息
	 */
	@Override
	public String deleteOne(String idstudent) {
		try {
			initAjax();
			Student studentOne = studentDao.getOne(Integer.valueOf(idstudent));
			if(studentOne!=null){
				studentDao.deleteOne(studentOne);
				out.print("true");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("false");
		return null;
	}

	
	/**
	 * 统计某一个学生的所修课程信息、汇总出学分、不及格课程（标红）
	 */
	@Override
	public void getOneStudentGrade(String idstudent) {
		try {
			initAjax();
			List<StudentGradeResult> studentGradeResults = new ArrayList<>();
			StudentGradeResult studentGradeResult;
			List<Sgrade> studentGradeInfo = sgradeDao.getOneToAll(Integer.valueOf(idstudent));//获取Sgrade信息
			for (Sgrade sgrade : studentGradeInfo) {
				Course course = courseDao.getOne(sgrade.getIdcourse());//获取课程信息
				
				Float studentscore = ScoreCalculation.studentScore(sgrade.getGrade(), course.getScore());//获取学生学分
				String passornot = PassJudgment.judgment(sgrade.getGrade());
				
				studentGradeResult = new StudentGradeResult(course.getIdcourse(), course.getName(), course.getStyle(), course.getScore(), sgrade.getGrade(), studentscore, passornot);
				studentGradeResults.add(studentGradeResult);
			}
			
			out.print(JSONSerializer.toJSON(studentGradeResults));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个学生的所修课程及其成绩 
	 */
	@Override
	public void getOneCourseGradeInfo(String idstudent) {
		try {
			initAjax();
			List<StudentCourseGrade> studentCourseGrades = new ArrayList<>();
			StudentCourseGrade studentCourseGrade;
			List<Sgrade> studentGradeInfo = sgradeDao.getOneToAll(Integer.valueOf(idstudent));//获取Sgrade信息
			for (Sgrade sgrade : studentGradeInfo) {
				Course course = courseDao.getOne(sgrade.getIdcourse());
				studentCourseGrade = new StudentCourseGrade(course.getIdcourse(), course.getName(), sgrade.getGrade());
				studentCourseGrades.add(studentCourseGrade);
			}

			out.print(JSONSerializer.toJSON(studentCourseGrades));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改学生某一课程的成绩
	 */
	@Override
	public String updateStudentGrade(List<String> studentcourseList) {
		try {
			initAjax();
			String strstudentcourseList = studentcourseList.toString();
			int strchar = strstudentcourseList.indexOf("]");
			strstudentcourseList = strstudentcourseList.substring(1, strchar);
			String[] studentcourseOne = strstudentcourseList.split(",");
			
			for (int i = 0; i < studentcourseOne.length; i++) {
				String a = studentcourseOne[i];
				i++;
				String b = studentcourseOne[i];
				i++;
				String c = studentcourseOne[i];

				Sgrade sgrade = new Sgrade(Integer.valueOf(a), b, Double.valueOf(c));
				sgradeDao.updateOneGrade(sgrade);
			}
			
			out.print("true");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("false");
		return null;
	}
	@Override
	public void getList(int first, int datalength) {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(studentDao.getList(first, datalength)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
