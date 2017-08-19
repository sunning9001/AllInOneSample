package sample3;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

public class FooServiceImpl implements FooService {

	private Map<String, String>  map;
	/*public  @Value("#{jdbcProperties.jdbcUrl}") String url;*/
	
	
	 
	 
	
	public FooServiceImpl(Map<String, String> map) {
		this.map =map;
		
	}

	@Override
	public String getValue(String key) {
		return map.get(key);
	}

}
