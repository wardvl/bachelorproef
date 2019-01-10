package be.hogent.distributedtracing;

import be.hogent.distributedtracing.tracer.JaegerTracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JaegerTracer.class)
public class UserService {

	public static void main(String[] args) {
		SpringApplication.run(UserService.class, args);
	}
}