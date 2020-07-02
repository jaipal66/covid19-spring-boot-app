package com.jp.spring.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jp.spring.batch.entity.Employee;
import com.jp.spring.batch.repository.EmployeeRepository;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

	Logger LOGGER = LoggerFactory.getLogger(EmployeeWriter.class);
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void write(List<? extends Employee> employees) throws Exception {
		employeeRepository.saveAll(employees);
		LOGGER.info("{} employees saved in database ",employees.size());
	}

}
