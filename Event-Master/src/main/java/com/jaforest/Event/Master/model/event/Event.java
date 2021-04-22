package com.jaforest.Event.Master.model.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaforest.Event.Master.model.family.Family;
import com.jaforest.Event.Master.model.member.Member;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    String title;
    String startDay;
    String endDay;
    String dow;
    String color;
    int reward;

    public Event(String title, String startDay, String endDay, String dow,
                 String color, int reward, Family familyEventsIBelongTo) {
        this.title = title;
        this.startDay = startDay;
        this.endDay = endDay;
        this.dow = dow;
        this.color = color;
        this.reward = reward;

        this.familyEventsIBelongTo = familyEventsIBelongTo;
    }

    public Event(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    Family familyEventsIBelongTo;

    @ManyToMany(mappedBy = "familyEvents")
    Set<Member> familyMembers = new HashSet<>();

    public Set<Member> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<Member> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public Family getFamilyEventsIBelongTo() {
        return familyEventsIBelongTo;
    }

    public void setFamilyEventsIBelongTo(Family familyEventsIBelongTo) {
        this.familyEventsIBelongTo = familyEventsIBelongTo;
    }
}
