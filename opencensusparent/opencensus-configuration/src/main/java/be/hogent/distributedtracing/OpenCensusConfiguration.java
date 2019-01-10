package be.hogent.distributedtracing;

import io.opencensus.contrib.spring.aop.CensusSpringAspect;
import io.opencensus.exporter.trace.jaeger.JaegerTraceExporter;
import io.opencensus.trace.Sampler;
import io.opencensus.trace.Tracer;
import io.opencensus.trace.Tracing;
import io.opencensus.trace.config.TraceConfig;
import io.opencensus.trace.config.TraceParams;
import io.opencensus.trace.samplers.Samplers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class OpenCensusConfiguration {

	private final Logger LOGGER = LoggerFactory.getLogger(OpenCensusConfiguration.class);
	private String serviceName;
	private String jaegerHost;
	private String jaegerPort;
	private Double jaegerSamplerParam;

	public OpenCensusConfiguration(@Value("${spring.application.name}") String serviceName,
								   @Value("${jaeger.agent.host:localhost}") String jaegerHost,
								   @Value("${jaeger.agent.port:14268}") String jaegerPort,
								   @Value("${jaeger.sampler.param:0}") Double jaegerSamplerParam) {
		this.serviceName = serviceName;
		this.jaegerHost = jaegerHost;
		this.jaegerPort = jaegerPort;
		this.jaegerSamplerParam = jaegerSamplerParam;
		createJaegerExporter();
		configureSampler();
	}

	private void configureSampler() {
		TraceConfig traceConfig = Tracing.getTraceConfig();
		TraceParams activeTraceParams = traceConfig.getActiveTraceParams();
		Sampler sampler = jaegerSamplerParam == null ? Samplers.neverSample() : jaegerSamplerParam == 1 ? Samplers.alwaysSample() : Samplers.probabilitySampler(jaegerSamplerParam);
		traceConfig.updateActiveTraceParams(activeTraceParams.toBuilder().setSampler(sampler).build());
		LOGGER.info("Tracer configured with " + sampler.getDescription());
	}

	private void createJaegerExporter() {
		String url = buildUrl();
		JaegerTraceExporter.createAndRegister(url, serviceName);
		LOGGER.info("Jaeger exporter configured at " + url + " for " + serviceName);
	}

	private String buildUrl() {
		return new StringBuilder().append("http://")
				.append(jaegerHost)
				.append(":")
				.append(jaegerPort)
				.append("/api/traces")
				.toString();
	}

	@Bean
	public CensusSpringAspect censusSpringAspect() {
		return new CensusSpringAspect(Tracing.getTracer());
	}
}
