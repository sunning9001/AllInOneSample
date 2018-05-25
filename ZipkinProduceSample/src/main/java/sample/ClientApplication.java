package sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ClientApplication {

  //  @Autowired
  //  private SpanAccessor spanAccessor;




	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@GetMapping("/hi")
	public String hi(){
   //     Span span = this.spanAccessor.getCurrentSpan();
//restTemplate().
     //   template.header(Span.TRACE_ID_NAME, Span.idToHex(span.getTraceId()));
     //   setHeader(template, Span.SPAN_NAME_NAME, span.getName() );
     //   setHeader(template, Span.SPAN_ID_NAME, Span.idToHex(span.getSpanId()));
		return this.restTemplate().getForEntity("http://localhost:9081/hi",String.class).getBody();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
