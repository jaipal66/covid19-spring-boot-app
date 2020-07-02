package com.jp.spring.batch.processor;

import java.util.Random;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.jp.spring.batch.entity.Employee;
import com.jp.spring.batch.to.EmployeeTo;

@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeTo, Employee> {

	@Override
	public Employee process(EmployeeTo item) throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeID(item.getEmployeeID()+new Random().nextInt(10000));
		employee.setFirstName(item.getFirstName());
		employee.setLastName(item.getLastName());
		employee.setEmail(item.getEmail());
		employee.setAge(item.getAge());
		return employee;
	}

}
