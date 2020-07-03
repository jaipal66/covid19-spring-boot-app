package com.jp.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		EmployeeService service=new EmployeeService();
		EmployeeCollection collection=new EmployeeCollection();
		List<Employee> emps=new ArrayList<>();
		Employee emp1=new Employee();
		emp1.setEmpID(101);
		emp1.setName("Jaipal");
		emp1.setEmail("jaipal66kumar@gmail.com");
		emp1.setDob("05/11/1990");
		
		Employee emp2=new Employee();
		emp2.setEmpID(102);
		emp2.setName("Jaipal");
		emp2.setEmail("jaipal66kumar@gmail.com");
		emp2.setDob("05/11/1990");
		
		Employee emp3=new Employee();
		emp3.setEmpID(103);
		emp3.setName("Jaipal");
		emp3.setEmail("jaipal66kumar@gmail.com");
		emp3.setDob("05/11/1990");
		
		Employee emp4=new Employee();
		emp4.setEmpID(104);
		emp4.setName("Jaipal");
		emp4.setEmail("jaipal66kumar@gmail.com");
		emp4.setDob("05/11/1990");
		
		Employee emp5=new Employee();
		emp5.setEmpID(105);
		emp5.setName("Jaipal");
		emp5.setEmail("jaipal66kumar@gmail.com");
		emp5.setDob("05/11/1990");
		
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		
		collection.setEmployee(emps);
		
		//service.convertToXml(collection);
		
		EmployeeCollection collection1=null;
		collection1=service.convertToObject(new File("employeeCollection.xml"),collection1);
		for(Employee emp:collection1.getEmployee())
			System.out.println(emp.getName());
		
		
	}
}
