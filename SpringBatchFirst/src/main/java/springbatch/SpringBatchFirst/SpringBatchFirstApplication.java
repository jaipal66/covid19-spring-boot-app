package springbatch.SpringBatchFirst;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan(basePackages= {"com.jp.spring.batch"})
public class SpringBatchFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchFirstApplication.class, args);
	}

}
