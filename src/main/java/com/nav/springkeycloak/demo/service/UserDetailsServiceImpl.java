package com.nav.springkeycloak.demo.service;

import com.nav.springkeycloak.demo.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

//Returns spring User object to enable spring perform authentication and authorization
// based on information found in DB for username entered in UI.
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserService userService;

    public UserDetailsServiceImpl(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("User: " + username + "not found in DB");
        }

        //Set of roles read from User in DB have to be converted into SimpleGrantedAuthority
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

         user.getRoles()
                 .forEach(roles -> authorities.add(new SimpleGrantedAuthority(roles.getRole())));

         //Spring User class is a subclass of UserDetails class
        return new org.springframework.security.core.userdetails
                .User(user.getUserName(), user.getPassword(), authorities);
    }
}
