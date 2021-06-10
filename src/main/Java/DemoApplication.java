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
