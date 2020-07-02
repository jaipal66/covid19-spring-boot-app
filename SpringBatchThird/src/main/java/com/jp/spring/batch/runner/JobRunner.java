package com.jp.spring.batch.runner;

import java.util.Date;

import javax.print.attribute.standard.JobPriority;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.jp.spring.batch.util.Constants;

@Component
public class JobRunner {

	private static Logger LOGGER = LoggerFactory.getLogger(JobRunner.class);

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job seondJob;

	@Async
	public void runBatchjob() {
		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addString(Constants.CONTEXT_KEY, "employees.txt");
		jobParametersBuilder.addDate("date",new Date(),true);
		runJob(seondJob, jobParametersBuilder.toJobParameters());

	}

	public void runJob(Job job, JobParameters jobParameters) {
		try {
			JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
