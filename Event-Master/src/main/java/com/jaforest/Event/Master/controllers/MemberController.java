package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.family.Family;
import com.jaforest.Event.Master.model.family.FamilyRepository;
import com.jaforest.Event.Master.model.member.Member;
import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/newUser")
    public RedirectView createNewUser(String username, String password, String firstName,
                                      String lastName, HttpServletRequest request) {

        String passwordEnc = passwordEncoder.encode(password);
        System.out.println("encoded password = " + passwordEnc);
        Member member = new Member();
        Family family = new Family();
        member.setPassword(passwordEnc);
        member.setUsername(username);
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setRole("parent");
        member.setFamilyIBelongTo(family);

        familyRepository.save(family);

        family.setFamilyName(lastName);

        memberRepository.save(member);


        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        authToken.setDetails(new WebAuthenticationDetails(request));
        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/calendar");
    }


        @PostMapping("/newUser/{id}")
        public RedirectView createNewUserFromAdmin(@PathVariable long id, String username, String role, String password, String firstName,
                String lastName, HttpServletRequest request){

            String passwordEnc = passwordEncoder.encode(password);
            System.out.println("encoded password = " + passwordEnc);
            Member member = new Member();
            Family family = familyRepository.getOne(id);
            member.setPassword(passwordEnc);
            member.setUsername(username);
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setRole(role);
            member.setFamilyIBelongTo(family);

            family.setFamilyName(lastName);

            memberRepository.save(member);

            return new RedirectView("/profile");
    }



}
