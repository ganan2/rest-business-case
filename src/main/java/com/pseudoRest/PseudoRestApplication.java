package com.pseudoRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.pseudoRest")
@EnableJpaRepositories(basePackages = {"com.pseudoRest,domain", "com.pseudoRest.repos"})
public class PseudoRestApplication {

	public static void main(String[] args) {

		/**
		 *
		 * Applications that use spring-boot-devtools will automatically restart whenever files on the classpath change.
		 * This can be a useful feature when working in an IDE as it gives a very fast feedback loop for code changes.
		 * By default, any entry on the classpath that points to a folder will be monitored for changes.
		 * Note that certain resources such as static assets and view templates do not need to restart the application.
		 *
		 * https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html
		 */
		System.setProperty("spring.devtools.restart.enabled", "true");
		System.setProperty("spring.devtools.restart.exclude", "static/**,public/**");
		SpringApplication.run(PseudoRestApplication.class, args);
	}
}
