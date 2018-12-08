package be.hogent.distributedtracing;

import be.hogent.distributedtracing.tracer.ZipkinTracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@Import(ZipkinTracer.class)
public class ZuulService {

	public static void main(String[] args) {
		SpringApplication.run(ZuulService.class, args);
	}
}
