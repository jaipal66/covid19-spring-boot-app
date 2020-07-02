package com.jp.spring.batch.job;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
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

@Configuration
public class ReadFromFlatFileStoreToDB {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private EmployeeProcessor employeeProcessor;

	@Autowired
	private DataSource dataSource;

	@Qualifier(value = "firstJob")
	@Bean
	public Job firstJob() {
		return this.jobBuilderFactory.get("firstJob").start(firstStep())
				// .next(step) if we have multiple step
				.build();
	}

	@Bean
	public Step firstStep() {
		return this.stepBuilderFactory.get("firstStep")
				.<EmployeeTo, Employee>chunk(10) // chunk size is used for
																						// transaction
				.reader(employeeReader())
				.processor(employeeProcessor)
				.writer(writeEmployeeToDB())
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

	@Bean
	public JdbcBatchItemWriter<Employee> writeEmployeeToDB() {
		JdbcBatchItemWriter<Employee> employeeWriter = new JdbcBatchItemWriter<Employee>();
		employeeWriter.setDataSource(dataSource);
		employeeWriter.setSql(
				"insert into employee (employee_id,first_name,last_name,email,age) values (:employeeID,:firstName,:lastName,:email,:age)");
		employeeWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return employeeWriter;
	}
}
