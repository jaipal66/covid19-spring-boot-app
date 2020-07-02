package com.jp.spring.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.spring.batch.runner.JobRunner;

@RestController
public class JobController {

	@Autowired
	private JobRunner jobRunner;
	
	@RequestMapping(value="/job")
	public String runJob() {
		jobRunner.runBatchjob();
		return "Job submitted successfully";
	}
}
