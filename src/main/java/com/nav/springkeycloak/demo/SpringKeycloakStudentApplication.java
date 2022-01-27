package com.nav.springkeycloak.demo;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
//@ComponentScan("com.nav.springkeycloak.demo.controller")
@EnableJpaRepositories("com.nav.springkeycloak.demo.repository")
@EnableMethodSecurity(prePostEnabled = true) // this allows method authorization to be performed on Student controller - manageStudents()
public class SpringKeycloakStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKeycloakStudentApplication.class, args);
		}

}
