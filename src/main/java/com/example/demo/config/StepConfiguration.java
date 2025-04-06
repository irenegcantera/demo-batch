package com.example.demo.config;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.processors.DemoItemProcessor;
import com.example.demo.readers.DemoItemReader;
import com.example.demo.writers.DemoItemWriter;

/**
 * Configuration class
 * 
 * @author irene
 * @version 1.0, 6 April 2025
 */
@Configuration
public class StepConfiguration {
	
	/**
	 * Create a new step bean with a specific characteristics
	 * 
	 * @param jobRepository the job repository to which the job should report to
	 * @return the step
	 * @see org.springframework.batch.core.Step
	 */
	@Bean
	Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("demo-batch-step", jobRepository)
				.<String, String>chunk(2, transactionManager)
				.reader(new DemoItemReader())
				.processor(new DemoItemProcessor())
				.writer(new DemoItemWriter())
				.build();
		
	}

}
