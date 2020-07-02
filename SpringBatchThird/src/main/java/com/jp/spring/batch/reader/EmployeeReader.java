package com.jp.spring.batch.reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.jp.spring.batch.to.EmployeeTo;


@Component
public class EmployeeReader implements ItemReader<EmployeeTo> {
	
	private List<EmployeeTo> list;
	public EmployeeReader(List<File> files) {
				
	}

	private static final String FILE_PATH="";
	@Override
	public EmployeeTo read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		EmployeeTo employeeTo=null;
		return employeeTo;
	}
	
	public EmployeeReader readFlatFile() {
		List<String> files=null;
		try {
			files = Arrays.asList(new ClassPathResource(FILE_PATH).getFile().list());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<File> fileList=files.stream().map((path)->{
			try {
				return new ClassPathResource(FILE_PATH+path).getFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).collect(Collectors.toList());
		return new EmployeeReader(fileList);
	}

}
