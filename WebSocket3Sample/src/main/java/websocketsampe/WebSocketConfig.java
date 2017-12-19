package websocketsampe;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig  implements WebSocketConfigurer{

	  	   @Override
	  	   public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	          registry.addHandler(myTextWebSocketHandler(), "/echo").withSockJS();
	  	   }
	 
	 	   @Bean
	 	   public WebSocketHandler myTextWebSocketHandler() {
	          return new PerConnectionWebSocketHandler(MyTextWebSocketHandler.class);
	     }
	
}

