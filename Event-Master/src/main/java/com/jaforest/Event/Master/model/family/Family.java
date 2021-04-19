package com.jaforest.Event.Master.model.family;

import com.jaforest.Event.Master.model.event.Event;
import com.jaforest.Event.Master.model.member.Member;

import javax.persistence.*;
import java.util.List;

@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "familyIBelongTo", cascade = CascadeType.ALL)
    List<Member> members;

    @OneToMany(mappedBy = "familyEventsIBelongTo", cascade = CascadeType.ALL)
    List<Event> events;

    String familyName;

    public Family(String familyName) {
        this.familyName = familyName;
    }

    public Family(){};

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
