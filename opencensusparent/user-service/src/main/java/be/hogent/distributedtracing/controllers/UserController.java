package be.hogent.distributedtracing.controllers;

import io.opencensus.contrib.spring.aop.Traced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Traced
	@RequestMapping("/users/{id}")
	public String findById(@PathVariable("id") Integer id) {
		return String.valueOf(id);
	}
}
