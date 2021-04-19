package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.member.Member;
import com.jaforest.Event.Master.model.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class MemberController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/newUser")
    public RedirectView createNewUser(Model m, Principal p, String username, String password, String firstName,
                                      String lastName, String role, String family, int rewardPoints){

        password = passwordEncoder.encode(password);
        System.out.println("encoded password = " + password);
        Member member = new Member(username, password, firstName, lastName, role, family, rewardPoints);

        member.setPassword(password);
        member.setUsername(username);

        memberRepository.save(member);

        return new RedirectView("/calendar");
    }

}
