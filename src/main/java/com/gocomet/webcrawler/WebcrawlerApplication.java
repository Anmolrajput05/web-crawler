package com.gocomet.webcrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.gocomet.webcrawler.entity.Role;
import com.gocomet.webcrawler.entity.User;
import com.gocomet.webcrawler.service.RoleService;
import com.gocomet.webcrawler.service.UserService;

@SpringBootApplication(scanBasePackages = "com.gocomet.webcrawler")
public class WebcrawlerApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebcrawlerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WebcrawlerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		Role r = new Role(1,"ADMIN");		
		roleService.save(r);
		User u = new User(1,"admin","admin",roleService.getByNames("ADMIN"));
		userService.save(u);
	}

}
