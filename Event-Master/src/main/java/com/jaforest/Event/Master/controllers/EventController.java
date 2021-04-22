package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.event.Event;
import com.jaforest.Event.Master.model.event.EventRepository;
import com.jaforest.Event.Master.model.family.Family;
import com.jaforest.Event.Master.model.family.FamilyRepository;
import com.jaforest.Event.Master.model.member.Member;
import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FamilyRepository familyRepository;

    @DeleteMapping("/deleteEvent/{id}")
    public RedirectView deleteEvent(@PathVariable long id){
        eventRepository.deleteById(id);
        return new RedirectView("/profile");
    }

    @PostMapping("/newEvent")
    public RedirectView addNewEvent(Principal p, String title, String startDay,
                                    String endDay, String startDayTime, String endDayTime, String color,
                                    int reward, String dow, String assignTo) throws ParseException {

        System.out.println("ASSIGNED TO = " + assignTo);
        if (assignTo.equals("Entire Family")){
            Member member = memberRepository.findByUsername(p.getName());
            Family family = familyRepository.getOne(member.getFamilyIBelongTo().getId());
            List<Member> rewardedFamily = family.getMembers();
            for (Member familyMember : rewardedFamily) {
                System.out.println("MEMBER NAME = " + familyMember.getFirstName());
                int awardedMemberPoints = familyMember.getRewardPoints();
                familyMember.setRewardPoints(awardedMemberPoints + reward);
            }
        } else {
            Member awardedMember = memberRepository.findByUsername(assignTo);
            int awardedMemberPoints = awardedMember.getRewardPoints();
            awardedMember.setRewardPoints(awardedMemberPoints + reward);
            System.out.println("UPDATED TOTAL = " + awardedMember.getRewardPoints());
        }
        Member member = memberRepository.findByUsername(p.getName());
        Family family = familyRepository.getOne(member.getFamilyIBelongTo().getId());

        Event event = new Event();
        event.setTitle(title);
        event.setColor(color);
        event.setReward(reward);

        String dowInt = "";

        if (!startDay.equals("")){
            event.setStartDay(startDay);
            event.setEndDay(endDay);
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date theDate = sdf.parse(startDay);
            Calendar cal = Calendar.getInstance();
            cal.setTime(theDate);
            dowInt = String.valueOf(cal.get(Calendar.DAY_OF_WEEK) - 1);
            System.out.println("THE DATE: " + theDate);
            System.out.println("DAY OF THE WEEK = " + cal.get(Calendar.DAY_OF_WEEK));
            System.out.println(dowInt);
        }

        if (!startDayTime.equals("")){
            event.setStartDay(startDayTime);
            event.setEndDay(endDayTime);
            System.out.println("START DAY TIME = " + startDayTime);
            DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date theDate = sdf2.parse(startDayTime);
//            Date theDate2 = sdf2.
            Calendar cal = Calendar.getInstance();
            cal.setTime(theDate);
            dowInt = String.valueOf(cal.get(Calendar.DAY_OF_WEEK) - 1);
            System.out.println("THE DATE2: " + theDate);
            System.out.println("DAY OF THE WEEK2 = " + cal.get(Calendar.DAY_OF_WEEK));
            System.out.println(dowInt);
        }

        if (dow.equals("Never"))event.setDow(null);
        if (dow.equals("Daily"))event.setDow("0, 1, 2, 3, 4, 5, 6");
        if (dow.equals("Weekly"))event.setDow(dowInt);
        event.setFamilyEventsIBelongTo(family);

        eventRepository.save(event);
        eventRepository.findById(member.getFamilyIBelongTo().getId());
//        System.out.println(member.getFamilyIBelongTo().getEvents());

        return new RedirectView ("/calendar");
    }
}
