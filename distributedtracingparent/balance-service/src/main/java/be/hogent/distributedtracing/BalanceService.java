package be.hogent.distributedtracing;

import be.hogent.distributedtracing.tracer.JaegerTracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import(JaegerTracer.class)
public class BalanceService {

	public static void main(String[] args) {
		SpringApplication.run(BalanceService.class, args);
	}
}
