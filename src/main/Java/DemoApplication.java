@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}

        @Bean
	public Function<String, String> lowercase() {
		return value -> value.toLowerCase();
	}
}
