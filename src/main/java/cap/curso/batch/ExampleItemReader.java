package cap.curso.batch;

import java.io.BufferedReader;

import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

/**
 * {@link ItemReader} with hard-coded input data.
 */

@Component("reader")
public class ExampleItemReader implements ItemReader<String> {
	
	
	private BufferedReader bufferedReader;
	/**
	 * Reads next record from input
	 */
	public String read() throws Exception {
		
		
		return null;
		
	}

}
