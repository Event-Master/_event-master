package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.event.Event;
import com.jaforest.Event.Master.model.member.Member;
import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/")
    public String showSplashPage(Principal p, Model m){

        if(p != null){
            System.out.println("p.getname = " + p.getName());
            Member member = memberRepository.findByUsername(p.getName());
            m.addAttribute("member", member);
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

    @GetMapping("/calendarEvents")
    @ResponseBody
    public List showCalendarEvents(Principal p){
        System.out.println("showing calendarEvents route");
        System.out.println(p.getName());
        Member member = memberRepository.findByUsername(p.getName());
        List<Event> eventList = member.getFamilyIBelongTo().getEvents();
        return eventList;
    }

    @GetMapping("/profile")
    public String showProfilePage(Principal p, Model m){
        if(p != null){
            System.out.println("p.getName() = " + p.getName());
            Member member = memberRepository.findByUsername(p.getName());
            System.out.println("member.getFirstName() = " + member.getFirstName());
            System.out.println("member.getLastName() = " + member.getLastName());
            System.out.println("member.getFamilyIBelongTo().getId() = " + member.getFamilyIBelongTo().getId());
            System.out.println("member.getFamilyIBelongTo().getMembers().get(0).getFirstName() = " + member.getFamilyIBelongTo().getMembers().get(0).getFirstName());
            System.out.println("member.getRole() = " + member.getRole());
            m.addAttribute("member", member);

        }
        return "profile.html";
    }

    @GetMapping("/about")
    public String showAboutPage(){
        return "aboutus.html";
    }

}
