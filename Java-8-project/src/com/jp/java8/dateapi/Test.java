package com.jp.java8.dateapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		String date="1990/11/05";
		DateFormat formatter=new SimpleDateFormat("YYYY:MM:dd");
		String formatedDate=formatter.format(new Date());
		System.out.println(formatedDate);
		
		
		LocalDate localDate=LocalDate.now();
		System.out.println("Current Date : "+localDate);
		
		LocalDate localDate2=LocalDate.of(1990,05,18);
		System.out.println("Date as per input : "+localDate2);
		
		
		
	}
}
