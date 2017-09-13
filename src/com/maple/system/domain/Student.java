package com.maple.system.domain;

public class Student {
	private Integer idstudent;
	private String password;
	private String name;
	private String sex;
	private String birthday;
	private String phone;
	private String address;
	private String idclass;

	public Integer getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(Integer idstudent) {
		this.idstudent = idstudent;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "Student [idstudent=" + idstudent + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", birthday=" + birthday + ", phone=" + phone + ", address=" + address + ", idclass=" + idclass + "]";
	}

	
	
}
