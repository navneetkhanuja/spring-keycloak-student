package com.nav.springkeycloak.demo.service;

import com.nav.springkeycloak.demo.entity.User;
import com.nav.springkeycloak.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User getUserByUserName(String userName){

        return userRepository.findByUserName(userName);
    }
}
