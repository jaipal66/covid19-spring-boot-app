package com.jp.datastructure.array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {

		Set<Employee> map = new TreeSet<>();
		map.add(new Employee("jaipal", 25));
		map.add(new Employee("jaipal", 25));

		System.out.println(map.size());

	}

}

class Employee implements Comparable<Employee> {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee emp = (Employee) obj;
		if (emp.name != this.name)
			return false;
		if (emp.age != this.age)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash = hash * 31 + this.name.hashCode();
		hash = hash * 31 + this.age;
		return hash;
	}



	@Override
	public int compareTo(Employee emp) {
		this.name.compareTo(emp.name);
		return 0;
	}
}