package com.maple.system.utils;

public class ScoreCalculation {
	public static Float studentScore(Double grade, Float score){
		if(grade > 90){
			return score;
		}else if(grade > 80){
			return (float) (score*0.9);
		}else if(grade > 70){
			return (float) (score*0.7);
		}else if(grade > 60){
			return (float) (score*0.5);
		}else{
			return (float) 0;
		}
	}
}
