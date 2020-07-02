package com.jp.spring.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.jp.spring.batch.entity.Employee;
import com.jp.spring.batch.mapper.EmployeeFileRowMapper;
import com.jp.spring.batch.processor.EmployeeProcessor;
import com.jp.spring.batch.to.EmployeeTo;
import com.jp.spring.batch.writer.EmployeeWriter;

@Configuration
public class ReadWriteUsingCustomDB {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	

	
	@Autowired
	private EmployeeProcessor employeeProcessor;
	
	@Autowired
	private EmployeeWriter employeeWriter;
	
	
	@Bean
	@Qualifier(value="secondJob")
	public Job createJob() {
		return this.jobBuilderFactory
				.get("secondJob")
				.start(createStep())
				.build();
	}
	
	@Bean
	public Step createStep() {
		return this.stepBuilderFactory.get("firstStep")
		.<EmployeeTo, Employee>chunk(5)
		.reader(employeeReader())
		.processor(employeeProcessor)
		.writer(employeeWriter)
		.build();
	}
	
	@StepScope
	@Bean
	public Resource inputFileResource(@Value("#{jobParameters[fileName]}") final String fileName) {
		return new ClassPathResource(fileName);
	}

	@StepScope
	@Bean
	public FlatFileItemReader<EmployeeTo> employeeReader() {
		FlatFileItemReader<EmployeeTo> reader = new FlatFileItemReader<EmployeeTo>();
		reader.setResource(inputFileResource(null));
		reader.setLineMapper(new DefaultLineMapper<EmployeeTo>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames("employeeID", "firstName", "lastName", "email", "age");
						// setDelimiter(DELIMITER_COMMA);
					}
				});
				setFieldSetMapper(new EmployeeFileRowMapper());
			}
		});
		return reader;
	}

}
