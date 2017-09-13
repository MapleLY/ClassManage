package com.maple.system.service.Impl;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.maple.system.dao.ISclassDao;
import com.maple.system.domain.Sclass;
import com.maple.system.service.ISclassService;

import net.sf.json.JSONSerializer;

public class SclassServiceImpl implements ISclassService{
	//****注入****
	private ISclassDao sclassDao;
	public void setSclassDao(ISclassDao sclassDao) {
		this.sclassDao = sclassDao;
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
	 * 获取全部班级信息
	 */
	@Override
	public void getAll() {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(sclassDao.getAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取一个班级信息（根据编号）
	 */
	@Override
	public void getOne(String idclass) {
		try {
			initAjax();
			out.print(JSONSerializer.toJSON(sclassDao.getOne(idclass)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一个班级信息（根据名称）
	 */
	@Override
	public void getOneByName(List<String> searchList) {
		try {
			initAjax();
			String strsearchList = searchList.toString();
			System.out.println(strsearchList);
			int strchar = strsearchList.indexOf("]");
			strsearchList = strsearchList.substring(1, strchar);
			String[] searchListOne = strsearchList.split(",");
			System.out.println(strsearchList);
			System.out.println(searchListOne.length);
			
			String hql = "from Sclass s where 1=1";
			String strhql = "";
			for (int i = 0; i < searchListOne.length; i++) {
				String a = searchListOne[i];
				i++;
				String b = searchListOne[i];
				i++;
				String c = searchListOne[i];
				
				if(!a.equals("0")){
					if(!c.equals("NONE")){
						strhql += " " + a;
						strhql += " s." + b + "='" + c + "'";
					}
				}else{
					if(!c.equals("NONE")){
						strhql += " and s." + b + "='" + c + "'";
					}
				}
			}
			hql += strhql;
			System.out.println(hql);
			sclassDao.searchAll(hql);
			System.out.println(sclassDao.searchAll(hql));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改一个班级信息
	 */
	@Override
	public String updateOne(String idclass, String name) {
		try {
			initAjax();
			
			Sclass sclassOne = sclassDao.getOne(idclass);
			sclassOne.setName(name);
			
			sclassDao.updateOne(sclassOne);
			out.print(JSONSerializer.toJSON(sclassDao.getOne(sclassOne.getIdclass())));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("false");
		return null;
	}
	
	/**
	 * 删除一个班级信息
	 */
	@Override
	public String deleteOne(String idclass) {
		try {
			initAjax();
			Sclass sclassOne = sclassDao.getOne(idclass);
			if(sclassOne!=null){
				sclassDao.deleteOne(sclassOne);
				out.print("true");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.print("false");
		return null;
	}

	
}
