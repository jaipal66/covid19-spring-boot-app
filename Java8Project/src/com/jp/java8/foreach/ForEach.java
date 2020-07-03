package com.jp.java8.foreach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ForEach {

	public static void main(String[] args) {
		
		ArrayList<String> list=new ArrayList<>();
		list.add("aAaA");
		list.add("AaA");
		list.add("aAa");
		list.add("AAaa");
		
		Map<String,Integer> items=new HashMap<>();
		items.put("ONE",1);
		items.put("TWO",2);
		items.put("THREE",3);
		items.put("FOUR",4);
		items.put("FIVE",5);
		items.put("SIX",6);
		
		System.out.println("...........Printing LIST ............");
		for(Object s : list)
		     System.out.println(s+" ");
		
		System.out.println("JAVA 8 with method reference");
		list.forEach(System.out::println);
		
		System.out.println("JAVA 8 with Lamda ");
		list.forEach((value)-> System.out.println(value));
		
		System.out.println("With Stream and filter");
		list.stream().filter(s->s.contains("AAaa")).forEach(System.out::println);
		
		System.out.println("...........Printing MAP ............");
		
		
		for(Map.Entry<String, Integer> entry:items.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
		System.out.println("JAVA 8 with Lamda ");
		items.forEach((key,value)->System.out.println(key+" : "+value));
		
		System.out.println("JAVA 8 with Lamda and if ");
		
	    items.forEach((key,value)->{
	    	System.out.println(key+" : "+value);
	    	if("ONE".equals(key)) {
	    		System.out.println("Matched");
	    	}
	    });
	}
}
