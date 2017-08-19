package sample3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FooService fooService() {
        return new FooServiceImpl(map());
    }

   
    @Bean
    public Map<String, String>  map(){
    	 Map<String, String>   map =new HashMap<>();
    	 map.put("a", "aaaaa");
    	 return map;
    }
  
}