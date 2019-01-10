package be.hogent.distributedtracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(OpenCensusConfiguration.class)
public class UserService {

	public static void main(String[] args) {
		SpringApplication.run(UserService.class, args);
	}
}