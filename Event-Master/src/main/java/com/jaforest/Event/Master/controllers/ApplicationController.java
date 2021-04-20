package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/")
    public String showSplashPage(){
        return "home.html";
    }

    @GetMapping("/signup")
    public String showSignupPage(){
        return "signup.html";
    }

    @GetMapping("/calendar")
    public String showCalendarPage(){
        return "calendar.html";
    }

    @GetMapping("/profile")
    public String showProfilePage(){
        return "profile.html";
    }

    @GetMapping("/about")
    public String showAboutPage(){
        return "about.html";
    }

}
