package com.nav.springkeycloak.demo.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    /**
     * Method sets keycloakauthenticationprovider in Spring context.
     * @param auth
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    //This will configure urls which everyone can access and which requires authentication
    @Override
    public void configure(HttpSecurity http) throws Exception{
        super.configure(http);
        http
                .authorizeRequests()
                .antMatchers("/", "/testpage") // Test page to demo that this page can be accessed by anyone but all other pages requires authentication
                .permitAll()
                .anyRequest()
                .authenticated()
                //below url needs to be authenticated before anyone can access
                /*.antMatchers("/home")
                .authenticated()
                //csrf (cross site request forgery) disabled
                .and()
                .csrf()
                .disable()
                //after authentication user will be redirected
                .formLogin()
                .loginPage("/login") //login url to be presented.This name should be same as in action="/login" of login.html
                .defaultSuccessUrl("/home") //when post action is login then redirect to home page
                //parameters in login.html
                .usernameParameter("username")
                .passwordParameter("password")*/  //Not needed for keycloak
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and().logout().logoutUrl("/logout") //don't have to provide explicit method in controller. Just link in UI.
                .logoutSuccessUrl("/login");
    }

}
