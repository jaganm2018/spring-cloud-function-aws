package demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Value;
import java.util.function.Function;

@SpringBootApplication
@EnableConfigServer
public class DemoApplication {

	@Value("${env}")
	private String env;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Function<String, String> fetchEnv() {
		return value -> env;
	}
}
