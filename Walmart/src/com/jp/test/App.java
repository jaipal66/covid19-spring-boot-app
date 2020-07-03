package com.jp.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
        int array[]= {2,3,4,5,6,6,6,6,6,8};
		int target=6;
		int index=findIndex(array,target);
		//System.out.println(index);
		
		//System.out.println(binarySearch(array, target));
		
		
		String string="IncridebaleIndia";
		System.out.println(firstNonRepeatedChar(string));
		
	}
	
	public static char firstNonRepeatedChar(String string) {
		if(string==null)
			return ' ';
		
		Map<Character,Integer> map=new LinkedHashMap<>();
		
		for(int i=0;i<string.length();i++) {
			char key=string.charAt(i);
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, 1);
			}
		}
		char result=' ';
		for (Map.Entry<Character, Integer> entry:map.entrySet()) {
			if(entry.getValue()==1)
				return entry.getKey();
		}
			
		return result;
	}
	public static int findIndex(int array[],int target) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==target) {
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int array[],int target) {
		int middle=array.length-1/2;
		
		if(array[middle]==target) {
			return middle;
		}
		else if(target<array[middle]) {
			binarySearch(array,target);
		}else {
			binarySearch(array,target);
		}
		return -1;
	}
}
