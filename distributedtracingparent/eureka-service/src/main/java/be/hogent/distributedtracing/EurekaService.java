package be.hogent.distributedtracing;

import be.hogent.distributedtracing.tracer.ZipkinTracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaServer
@Import(ZipkinTracer.class)
public class EurekaService {

	public static void main(String[] args) {
		SpringApplication.run(EurekaService.class, args);
	}
}
