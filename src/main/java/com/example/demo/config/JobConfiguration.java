package com.example.demo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class
 * 
 * @author irene
 * @version 1.0, 6 April 2025
 */
@Configuration
public class JobConfiguration {
	
	/**
	 * Create a new job bean with a specific characteristics
	 * 
	 * @param jobRepository the job repository to which the job should report to
	 * @return the job
	 * @see org.springframework.batch.core.Job
	 */
	@Bean
	Job job(JobRepository jobRepository, Step step) {
		return new JobBuilder("demo-batch-job", jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}

}
