package com.jaforest.Event.Master.model.member;

import com.jaforest.Event.Master.model.event.Event;
import com.jaforest.Event.Master.model.family.Family;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "familyAndMemberEvents",
            joinColumns = {@JoinColumn(name = "member")},
            inverseJoinColumns = {@JoinColumn(name = "event")}
    )
    Set<Event> familyEvents = new HashSet<>();

    public Set<Event> getFamilyEvents() {
        return familyEvents;
    }

    public void setFamilyEvents(Set<Event> familyEvents) {
        this.familyEvents = familyEvents;
    }

    @ManyToOne
    Family familyIBelongTo;

    @Column(unique = true)
    String password;
    String username;
    String firstName;
    String lastName;
    String role;
    int rewardPoints;

    public Member(String password, String username, String firstName,
                  String lastName, String role, Family familyIBelongTo) {
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.familyIBelongTo = familyIBelongTo;
    }

    public Member(){};

    public Family getFamilyIBelongTo() {
        return familyIBelongTo;
    }

    public void setFamilyIBelongTo(Family familyIBelongTo) {
        this.familyIBelongTo = familyIBelongTo;
    }

    public void setUsername(String username){this.username = username;}
    public void setPassword(String password){this.password = password;}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }
    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
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
}
