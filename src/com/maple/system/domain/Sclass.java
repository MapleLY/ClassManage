package com.maple.system.domain;

public class Sclass {
	private String idclass;
	private String name;
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
	@Override
	public String toString() {
		return "sclass [idclass=" + idclass + ", name=" + name + "]";
	}
	
	
}
