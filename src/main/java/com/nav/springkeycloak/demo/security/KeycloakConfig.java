package com.nav.springkeycloak.demo.security;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*See Belo link why this class exists and bean cannot be created in KeycloakSecurityConfig class
* https://stackoverflow.com/questions/57787768/example-keycloak-spring-boot-app-fails-to-find-bean-keycloakspringbootconfigreso
* */

@Configuration
public class KeycloakConfig {

    /**
     * By default, keycloak read from json file. We want to provide properties through application.properties.
     * Below configuration creates a bean provided by Spring which reads properties from application.properties file.
     * * @return
     */
    @Bean
    KeycloakSpringBootConfigResolver keycloakConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }
}
