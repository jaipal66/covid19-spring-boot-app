package com.jp.java8.foreach;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> string1=new ArrayList<>();
		List<String> string2=new ArrayList<>();
		List<String> string3=new ArrayList<>();
		List<String> string4=new ArrayList<>();
		string1.add("4");
		string2.add("5");
		string3.add("Name");
		string3.add("22");
		string3.add("33.4");
		string4.add("Name");
		string4.add("22");
		string4.add("33.4");
		List<List<String>> app=new ArrayList<>();
		app.add(string1);
		app.add(string2);
		app.add(string3);
		app.add(string4);
		
		int rows=Integer.parseInt(app.get(0).get(0));
		int columns=Integer.parseInt(app.get(1).get(0));
		System.out.println(rows+" "+columns);
		
	}
}
