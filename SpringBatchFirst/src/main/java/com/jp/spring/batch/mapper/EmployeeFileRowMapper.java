package com.jp.spring.batch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.jp.spring.batch.to.EmployeeTo;

public class EmployeeFileRowMapper implements FieldSetMapper<EmployeeTo> {

	@Override
	public EmployeeTo mapFieldSet(FieldSet fieldSet) throws BindException {
		EmployeeTo employeeTo=new EmployeeTo();
		employeeTo.setEmployeeID(fieldSet.readString("employeeID"));
		employeeTo.setFirstName(fieldSet.readString("firstName"));
		employeeTo.setLastName(fieldSet.readString("lastName"));
		employeeTo.setEmail(fieldSet.readString("email"));
		employeeTo.setAge(fieldSet.readInt("age"));
		return employeeTo;
	}

}
