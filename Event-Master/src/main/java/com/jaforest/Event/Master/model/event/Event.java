package com.jaforest.Event.Master.model.event;

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
    String date;

    public Event(String title, String date, Family familyEventsIBelongTo) {
        this.title = title;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ManyToOne
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
