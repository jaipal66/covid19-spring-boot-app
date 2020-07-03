package com.jp.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Application {

	public static void main(String[] args) {
		
		Class cls=Employee.class;
		Constructor [] con=cls.getDeclaredConstructors();
		System.out.println(cls.getCanonicalName());
		for(Constructor cn:con) {
			System.out.println(cn.getParameterCount());
			System.out.println(cn.getModifiers());
		}
		
		Method [] methods=cls.getDeclaredMethods();
		for(Method m:methods) {
			System.out.println(m.getName());
			System.out.println(Modifier.toString((m.getModifiers())));
			System.out.println(m.getExceptionTypes());
			System.out.println(m.getReturnType());
		}
		
	}
}
