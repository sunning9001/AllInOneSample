package springbootcondictionsample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		long end = System.currentTimeMillis();
		logger.info("============程序启动成功!      耗时间:{}毫秒==============", end - begin);
		
		OnClassObject hw = ctx.getBean(OnClassObject.class);
		System.out.println(hw);
	}

}
