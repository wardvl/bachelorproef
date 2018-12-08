package be.hogent.distributedtracing;

import be.hogent.distributedtracing.tracer.ZipkinTracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import(ZipkinTracer.class)
public class UserService {

	public static void main(String[] args) {
		SpringApplication.run(UserService.class, args);
	}
}