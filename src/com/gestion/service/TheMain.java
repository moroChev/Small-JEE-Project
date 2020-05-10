package com.gestion.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TheMain {

	public static boolean isValid(String value) {
		return value.matches("[0-9][0-9][0-9][0-9]+-+[0-9]+-+[0-9][0-9]");
	}
	
		
//		String[] elements = value.split("-");
//		for(String element : elements )
//		{
//			System.out.println(element);
//		}
//		int yy = Integer.parseInt(elements[0]);
//		int mm = Integer.parseInt(elements[1]);
//		int dd = Integer.parseInt(elements[2]);
//		
//		boolean resul = yy>1000 && yy<10000 && mm>0 && mm<13 && dd>0 && dd<32;
		
		

	
	
	public static void main(String[] args) {
		
		
		Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(now);
        System.out.println("Java's Default Date Format: " + now);
        System.out.println("Mysql's Default Date Format: " + mysqlDateString);
	
	

	}

}
