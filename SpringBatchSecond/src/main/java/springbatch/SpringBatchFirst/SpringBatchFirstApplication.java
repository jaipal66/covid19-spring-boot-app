package springbatch.SpringBatchFirst;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan(basePackages= {"com.jp.spring.batch"})
@EnableJpaRepositories(basePackages="com.jp.spring.batch.repository")
@EntityScan("com.jp.spring.batch.entity")
public class SpringBatchFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchFirstApplication.class, args);
	}

}
