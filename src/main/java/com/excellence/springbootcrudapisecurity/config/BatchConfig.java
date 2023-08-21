//package com.excellence.springbootcrudapisecurity.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import com.excellence.springbootcrudapisecurity.service.TaskService;
//
//@SuppressWarnings("removal")
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//
//	@Autowired
//	private final JobBuilderFactory jobBuilderFactory;
//	@Autowired
//	private final StepBuilderFactory stepBuilderFactory;
//	@Autowired
//	private final JobLauncher jobLauncher;
//	@Autowired
//	private final TaskService taskService;
//
//	public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
//			JobLauncher jobLauncher, TaskService taskService) {
//		this.jobBuilderFactory = jobBuilderFactory;
//		this.stepBuilderFactory = stepBuilderFactory;
//		this.jobLauncher = jobLauncher;
//		this.taskService = taskService;
//	}
//
//	@Bean
//	public Job updateTaskStatusJob() {
//		return jobBuilderFactory.get("updateTaskStatusJob").start(updateTaskStatusStep()).build();
//	}
//
//	@Bean
//	public Step updateTaskStatusStep() {
//		return stepBuilderFactory.get("updateTaskStatusStep").tasklet((contribution, chunkContext) -> {
//			taskService.updateTaskStatusBasedOnDueDates();
//			return RepeatStatus.FINISHED;
//		}).build();
//	}
//
//	@Scheduled(cron = "0 0 2 * * *") 
//	public void runUpdateTaskStatusJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
//		JobParameters parameters = new JobParametersBuilder()
//				.addString("jobId", String.valueOf(System.currentTimeMillis())).toJobParameters();
//		JobExecution jobExecution = jobLauncher.run(updateTaskStatusJob(), parameters);
//	}
//}
