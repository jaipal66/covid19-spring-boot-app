package com.jp.design.patterns.singleton;

import java.io.Serializable;

public class Employee implements Serializable {

	private static Employee employee;

	private Employee() {

	}

	public static Employee getEmployee() {
		if (employee == null) {
			employee = new Employee();
		}
		return employee;
	}

	public Object readResolve() {
		return employee;
	}

}
