package com.jp.publici;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ForEachApplication {

	public static void main(String[] args) {

		List<Employee> employeList = new ArrayList<>();
		employeList.add(new Employee("jaipal", 30, 90000, "Male"));
		employeList.add(new Employee("jp", 78, 80000, "Male"));
		employeList.add(new Employee("kp", 20, 50000, "Female"));
		employeList.add(new Employee("cp", 10, 85000, "Female"));
		employeList.add(new Employee("dp", 40, 10000, "Male"));

		System.out.println("Before java 8 sorting and iterating list");
		Collections.sort(employeList, new EmployeeNameComparator());
		Iterator<Employee> it = employeList.iterator();
		while (it.hasNext())
			System.out.println(it.next());

		System.out.println("Before java 8 sorting and iterating list using anonymous class");

		Comparator<Employee> salary = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		};
		Collections.sort(employeList, salary);
		Iterator<Employee> it1 = employeList.iterator();
		while (it1.hasNext())
			System.out.println(it1.next());

		System.out.println("With java 8 converting list of employee to lit of name");
		Predicate<Employee> pre=emp->"cp"!=emp.getName();
		List<String> emp = employeList.stream()
				.filter(pre)
				.sorted(Comparator.comparing(Employee::getName).reversed())
				.map(employee->employee.getName())
				.collect(Collectors.toList());

		emp.forEach((employee) -> {
			System.out.println(employee);
		});
	}
}

class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

class EmployeeSalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o1.getSalary() - o2.getSalary());
	}

}

class EmployeeAgeComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}

}

class Employee implements Comparable<Employee> {
	private String name;
	private int age;
	private double salary;
	private String gender;

	Employee(String name, int age, double salary, String gender) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}

}
