package be.hogent.distributedtracing.tracer;

import brave.Tracing;
import brave.opentracing.BraveTracer;
import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.okhttp3.OkHttpSender;

public class ZipkinTracer {
	@Bean
	public BraveTracer braveTracer(@Value("${spring.application.name}") String serviceName,
								   @Value("${opentracing.zipkin.http-sender.baseUrl}") String zipkinBaseUrl) {
		OkHttpSender okHttpSender = OkHttpSender.create(zipkinBaseUrl + "/api/v2/spans");
		AsyncReporter<Span> reporter = AsyncReporter.builder(okHttpSender).build();
		Tracing braveTracer = Tracing.newBuilder()
				.localServiceName(serviceName)
				.sampler(Sampler.ALWAYS_SAMPLE)
				.spanReporter(reporter).build();
		return BraveTracer.create(braveTracer);
	}
}