package cap.curso.batch;

import java.util.Optional;
import java.util.StringTokenizer;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("processor")
public class ExmpleItemProcessor implements ItemProcessor<String, Optional<Integer>>
{

	public Optional<Integer> process(String item) throws Exception
	{
		StringTokenizer stringTokenizer= new StringTokenizer(item, ";");
		String numero1=stringTokenizer.nextToken();
		String numero2=stringTokenizer.nextToken();
		
		return Optional.ofNullable(Integer.parseInt(numero1)+Integer.parseInt(numero2));
	}

}
