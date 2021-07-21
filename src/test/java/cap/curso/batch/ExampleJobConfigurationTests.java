package cap.curso.batch;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations={"/launch-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleJobConfigurationTests {
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job1;
	
	
	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(jobLauncher);
	}
	
	@Test
	public void testLaunchJob() throws Exception {
		
		JobParameter parameter= new JobParameter(1l);
		Map<String,JobParameter> mapaParametros= new HashMap();
		mapaParametros.put("parametro1",parameter);
		JobParameters parameters= new JobParameters(mapaParametros);
		jobLauncher.run(job1, parameters);
	}
	
}
