package com.jp.oops.java8;

public interface EmployeeIterface{
	default void EmployeeMethod() {
		System.out.println("EmployeeIterface personMethod");
	}
	default void EmployeeMethod2() {
		System.out.println("EmployeeIterface personMethod2");
	}
	default void commanPersonMethod() {
		System.out.println("EmployeeIterface commanPersonMethod");
	}
	static int personStaticMethod() {
		System.out.println("EmployeeIterface personStaticMethod");
		return 1;
	}
}
