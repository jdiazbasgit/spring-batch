package cap.curso.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("processor")
public class ExmpleItemProcessor implements ItemProcessor<String, Integer>
{

	public Integer process(String item) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
