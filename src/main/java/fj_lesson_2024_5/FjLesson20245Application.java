package fj_lesson_2024_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FjLesson20245Application {
	public static void main(String[] args) {
		SpringApplication.run(FjLesson20245Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(); // Создаем бин RestTemplate
	}
}
