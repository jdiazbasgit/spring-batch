package cap.curso.batch;

import java.util.Optional;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan("cap.curso.batch")

public class ExampleConfiguration {

//	@Value("${spring.datasource.jdbc.driver-class-name}")
//	private String driverClassName;
//
//	@Value("${spring.datasource.jdbc.url}")
//	private String driverUrl;
//
//	@Value("${spring.datasource.jdbc.user}")
//	private String driverUsername;
//
//	@Value("${spring.datasource.jdbc.password}")
//	private String driverPassword;
//
//	@Autowired
//	@Qualifier("jobRepository")
//	private JobRepository jobRepository;
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("reader")
	public ExampleItemReader reader;
	
	@Autowired
	@Qualifier("writer")
	public ExampleItemWriter writer;
	
	@Autowired
	@Qualifier("processor")
	public ExmpleItemProcessor procesor;
	
	@Value("${file.input}")
	public String fileInput;
	
	@Bean
	public Job job1() {
		return this.jobBuilderFactory.get("job1")
				.start(step1())
				.build(); 
	}
	
	@Bean
	public Step step1() {
		
		return this.stepBuilderFactory.get("step1")
					.<String, Optional<Integer>>chunk(100)
					.reader(reader)
					.processor(procesor)
					.writer(writer)
					.build();
	}
	
	

//	@Bean
//	public DataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName(driverClassName);
//		dataSource.setUrl(driverUrl);
//		dataSource.setUsername(driverUsername);
//		dataSource.setPassword(driverPassword);
//		return dataSource;
//	}
//
//	@Bean
//	public SimpleJobLauncher jobLauncher() {
//		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
//		jobLauncher.setJobRepository(jobRepository);
//		return jobLauncher;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		return new DataSourceTransactionManager(dataSource());
//	}

}
