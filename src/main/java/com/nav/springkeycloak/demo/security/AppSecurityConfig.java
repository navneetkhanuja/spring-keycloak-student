package com.nav.springkeycloak.demo.security;

import com.nav.springkeycloak.demo.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/* After creating KeycloakSecurity Config this class is commented out. All authentication for user will be done by Keycloak.*/
/*@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsServiceImpl userDetailsService;

    public AppSecurityConfig(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    //This will configure urls which everyone can access and which requires authentication
    @Override
    public void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests()
                .antMatchers("/", "/login")
                .permitAll()
                //below url needs to be authenticated before anyone can access
                .antMatchers("/home")
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
                .passwordParameter("password")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and().logout().logoutUrl("/logout") //don't have to provide explicit method in controller. Just link in UI.
                .logoutSuccessUrl("/login");
    }

    *//**This method will provide authentication based on user information collected from DB.
     Information from DB is collected using username and password entered by user in UI.
     @see com.nav.springkeycloak.demo.service.UserDetailsServiceImpl
     *//*

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    //This bean will be used by spring to encode/decode the password saved in user table of database
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}*/
