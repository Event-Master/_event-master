package com.jaforest.Event.Master.model.family;

import com.jaforest.Event.Master.model.event.Event;
import com.jaforest.Event.Master.model.member.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Family implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String familyName;
    @Column(unique = true)
    String username;
    String password;

    public Family(String username, String password, String familyName) {
        this.username = username;
        this.password = password;
        this.familyName = familyName;
    }

    public Family(){};

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Family(String familyName) {
        this.familyName = familyName;
    }


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
