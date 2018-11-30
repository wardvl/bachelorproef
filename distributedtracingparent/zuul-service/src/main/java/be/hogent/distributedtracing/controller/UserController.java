//package be.hogent.distributedtracing.controller;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.logging.Logger;
//
//@RestController
//public class UserController {
//
//	protected Logger logger = Logger.getLogger(UserController.class.getName());
//
//	public UserController() {
//		logger.info("UserController loaded.");
//	}
//
//	@RequestMapping("/users/{id}")
//	public String byId(@PathVariable("id") Integer id) {
//		return String.valueOf(id);
//	}
//}
