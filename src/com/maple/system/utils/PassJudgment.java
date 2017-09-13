package com.maple.system.utils;

public class PassJudgment {
	public static String judgment(Double grade){
		if(grade > 60){
			return "及格";
		}else{
			return "不及格";
		}
	}
}
