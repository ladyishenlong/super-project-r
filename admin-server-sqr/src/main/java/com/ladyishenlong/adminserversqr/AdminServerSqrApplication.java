package com.ladyishenlong.adminserversqr;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class AdminServerSqrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerSqrApplication.class, args);
	}

}
