package cap.curso.batch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader")
@Data
public class ExampleItemReader implements ItemReader<String>
{

	private BufferedReader bufferedReader;

	/**
	 * Reads next record from input
	 */
	public String read() throws Exception
	{
		if (getBufferedReader() == null)
		{
			try
			{
				FileInputStream fileInputStream = new FileInputStream("entrada.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				setBufferedReader(bufferedReader);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		if (getBufferedReader().ready())
			return getBufferedReader().readLine();
		getBufferedReader().close();
		return null;

	}

}
