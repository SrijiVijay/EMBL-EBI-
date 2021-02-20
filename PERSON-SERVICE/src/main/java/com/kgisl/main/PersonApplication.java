package com.kgisl.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The Class PersonApplication.
 */
@SpringBootApplication(scanBasePackages = { "com.kgisl" })
@EntityScan("com.kgisl.model")
@EnableJpaRepositories("com.kgisl.repository")
@ComponentScan(basePackages = "com.kgisl")
// @EnableDiscoveryClient
// @RefreshScope
public class PersonApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

}