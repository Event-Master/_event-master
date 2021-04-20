package com.jaforest.Event.Master.config;

import com.jaforest.Event.Master.model.family.FamilyRepository;
import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FamilyRepository familyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return familyRepository.findByUsername(username);
    }


}
