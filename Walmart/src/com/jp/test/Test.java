package com.jp.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		Employee emp1=new Employee("abc",10);
		Employee emp2=new Employee("pr",20);
		
		Map<Employee,String> map=new HashMap<>();
		map.put(emp1, "EMP1");
		map.put(emp2, "EMP2");
		Employee emp3=new Employee("abc",10);
		
		System.out.println(map.get(emp3));
		System.out.println(map.size());
		
		
	}

	public void ma1(int[] arr) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		int count = 0;
		while (left <= right) {
			if (left == right) {
				count++;
				break;
			}
			if (arr[left] + arr[right] <= 3.0) {
				left++;
				right--;
				count++;
			} else {
				right--;
				count++;
			}
		}
		System.out.println(count);
	}
}

class Employee {
	
	private String name;
	private int age;

	Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
	@Override
	public int hashCode() {
	return 1;
	}
	
}
