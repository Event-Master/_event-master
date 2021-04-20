package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.family.FamilyRepository;
import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

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

//    @PostMapping("/newUser")
//    public RedirectView createNewUser(String username, String password, String firstName,
//                                      String lastName, String role, HttpServletRequest request){
//
//        String passwordEnc = passwordEncoder.encode(password);
//        System.out.println("encoded password = " + passwordEnc);
//        Member member = new Member();
//
//        member.setPassword(passwordEnc);
//        member.setUsername(username);
//        member.setFirstName(firstName);
//        member.setLastName(lastName);
//        member.setRole(role);
//
//        memberRepository.save(member);
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
//        authToken.setDetails(new WebAuthenticationDetails(request));
//        Authentication authentication = authenticationManager.authenticate(authToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        return new RedirectView("/");
//    }



}
