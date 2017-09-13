package com.maple.system.service.Impl;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.maple.system.dao.ICourseDao;
import com.maple.system.dao.ISgradeDao;
import com.maple.system.domain.Course;
import com.maple.system.domain.Sgrade;
import com.maple.system.domain.Student;
import com.maple.system.entities.CourseGradeResult;
import com.maple.system.service.ICourseService;
import com.maple.system.utils.GradeStatistical;

import net.sf.json.JSONSerializer;

public class CourseServiceImpl implements ICourseService{
	private ICourseDao courseDao;
	private ISgradeDao sgradeDao;
	public void setCourseDao(ICourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public void setSgradeDao(ISgradeDao sgradeDao) {
		this.sgradeDao = sgradeDao;
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
	 * 获取全部课程信息
	 */
	@Override
	public void getAll() {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(courseDao.getAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个课程信息（根据课程编号）
	 */
	@Override
	public void getOne(String idcourse) {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(courseDao.getOne(idcourse)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个课程信息（根据课程名称）
	 */
	@Override
	public void getOneByName(String name) {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(courseDao.getOneByName(name)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改一个课程信息
	 */
	@Override
	public String updateOne(String idcourse, String name, String style, String score) {
		try {
			initAjax();
			
			Course courseOne = courseDao.getOne(idcourse);
			courseOne.setName(name);
			courseOne.setStyle(style);
			courseOne.setScore(Float.valueOf(score));
			
			courseDao.updateOne(courseOne);
			out.print(JSONSerializer.toJSON(courseDao.getOne(courseOne.getIdcourse())));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("false");
		return null;
	}
	
	/**
	 * 删除一个课程信息
	 */
	@Override
	public String deleteOne(String idcourse) {
		try {
			initAjax();
			Course courseOne = courseDao.getOne(idcourse);
			if(courseOne!=null){
				courseDao.deleteOne(courseOne);
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
	 * 统计每一门课程的最高分、最低分和平均分
	 */
	@Override
	public void getOneCourseGrade(String idcourse) {
		try {
			initAjax();

			CourseGradeResult courseGradeResult;
			List<Sgrade> courseGradeInfo = sgradeDao.getCourseToAll(idcourse);//获取Sgrade

			double maxgrade = GradeStatistical.maxGrade(courseGradeInfo);
			double mingrade = GradeStatistical.minGrade(courseGradeInfo);
			double averagegrade = GradeStatistical.average(courseGradeInfo);
			courseGradeResult = new CourseGradeResult(maxgrade, mingrade, averagegrade);
			
			out.print(JSONSerializer.toJSON(courseGradeResult));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
