package com.academy.it.notes2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/*
<li> 1. @Configuration
<li> 2. @EnableAutoConfiguration
<li> 3. @COmponentScan -> @>Autowired
*/
@SpringBootApplication
@EnableJpaAuditing
public class Notes2Application {

	public static void main(String[] args) {
		SpringApplication.run(Notes2Application.class, args);
	}

}
