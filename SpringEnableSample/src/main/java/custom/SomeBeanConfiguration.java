package custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SomeBeanConfiguration {

    @Bean
    public String aBean1() {
        return "aBean1";
    }

    @Bean
    public String aBean2() {
        return "aBean2";
    }
}