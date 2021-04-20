package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ApplicationController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/")
    public String showSplashPage(Principal p, Model m){

        if(p != null){
            System.out.println("p.getname = " + p.getName());
        }
        return "home.html";
    }

    @GetMapping("/signup")
    public String showSignupPage(){
        return "signup.html";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login.html";
    }

    @GetMapping("/calendar")
    public String showCalendarPage(){
        System.out.println("showing calendar route");
        return "calendar.html";
    }

    @GetMapping("/profile")
    public String showProfilePage(){
        return "profile.html";
    }

    @GetMapping("/about")
    public String showAboutPage(){
        return "aboutus.html";
    }

}
