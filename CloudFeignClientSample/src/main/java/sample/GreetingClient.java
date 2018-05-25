package sample;


import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("spring-cloud-eureka-client")
public interface GreetingClient extends GreetingController {
}