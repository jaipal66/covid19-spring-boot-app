package com.jp.json.json_project;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeService {

	public void convertToJSON(File file, EmployeeCollection employee) {

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, employee);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("converted to JSON");

	}

	public EmployeeCollection convertToObject(File file, EmployeeCollection employeeCollection) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			employeeCollection = objectMapper.readValue(file, EmployeeCollection.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeCollection;

	}
}
