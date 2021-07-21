package cap.curso.batch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@SpringBootApplication
@Data
public class EjemploMvcBootApplication implements CommandLineRunner{

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;
	
	@Value("${job.parametro}")
	private String parametro;

	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		SpringApplication.run(EjemploMvcBootApplication.class, args);
		
	}
	
	

	@Override
	public void run(String... args) throws Exception
	{
		JobParameter parameter= new JobParameter(args[0]);
		Map<String,JobParameter> mapaParametros= new HashMap();
		mapaParametros.put("parametro1",parameter);
		JobParameters parameters= new JobParameters(mapaParametros);
       
        getJobLauncher().run(getJob(),parameters);
        
		
	}
	
	
	
	

}
