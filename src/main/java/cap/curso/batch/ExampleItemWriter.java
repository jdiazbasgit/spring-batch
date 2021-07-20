package cap.curso.batch;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
@Component("writer")
public class ExampleItemWriter implements ItemWriter<Optional<Integer>>
{

	private static final Log log = LogFactory.getLog(ExampleItemWriter.class);

	/**
	 * @see ItemWriter#write(java.util.List)
	 */
	public void write(List<? extends Optional<Integer>> data) throws Exception
	{
		try (FileOutputStream fileOutputStream = new FileOutputStream("salida.txt", true);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);)
		{
			if (data.get(0).isPresent())
			{
				printWriter.println(data.get(0).get());
				printWriter.flush();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
