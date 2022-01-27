package com.nav.springkeycloak.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {

    @GetMapping(value = {"/", "/testpage"})
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("testpage");
        return modelAndView;
    }

    @GetMapping(value = {"/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

   /* @PostMapping( "/login") //this will be invoked as post action of sign in form.See login.html
    public ModelAndView loginRedirectURL(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }*/

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("/access-denied")
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView("access-denied");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('PROFESSOR')")
    @GetMapping("/manage-students")
    public ModelAndView manageStudents(){
        ModelAndView modelAndView = new ModelAndView("manage-students");
        return modelAndView;
    }

}
