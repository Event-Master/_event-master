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
