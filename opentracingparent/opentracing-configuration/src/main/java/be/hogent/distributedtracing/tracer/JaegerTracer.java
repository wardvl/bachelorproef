package be.hogent.distributedtracing.tracer;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.context.annotation.Bean;

public class JaegerTracer {

	@Bean
	public Tracer jaegerTracer() {
		return Configuration.fromEnv().getTracer();
	}
}
