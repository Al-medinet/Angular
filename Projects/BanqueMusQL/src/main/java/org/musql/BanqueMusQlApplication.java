package org.musql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("spring-beans.xml")
public class BanqueMusQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueMusQlApplication.class, args);
	}
}
