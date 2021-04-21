package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.event.Event;
import com.jaforest.Event.Master.model.event.EventRepository;
import com.jaforest.Event.Master.model.family.Family;
import com.jaforest.Event.Master.model.family.FamilyRepository;
import com.jaforest.Event.Master.model.member.Member;
import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FamilyRepository familyRepository;

    @PostMapping("/newEvent")
    public RedirectView addNewEvent(Principal p, String title, String date){
        System.out.println("username =" + p.getName());
        System.out.println("title =" + title);
        System.out.println("date =" + date);
        Member member = memberRepository.findByUsername(p.getName());
        Family family = familyRepository.getOne(member.getFamilyIBelongTo().getId());
        Event event = new Event();
        event.setDate(date);
        event.setTitle(title);
        event.setFamilyEventsIBelongTo(family);
        eventRepository.save(event);

        return new RedirectView ("/calendar");
    }
}
