package com.jaforest.Event.Master.controllers;

import com.jaforest.Event.Master.model.family.Family;
import com.jaforest.Event.Master.model.family.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FamilyController {


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/newFamily")
    public RedirectView createNewFamily(String familyUsername, String familyPassword, String familyName, HttpServletRequest request){
        System.out.println("familyUsername = " + familyUsername);
        String familyPasswordEnc = passwordEncoder.encode(familyPassword);
        System.out.println("encoded password = " + familyPasswordEnc);
        Family family = new Family();

        family.setPassword(familyPasswordEnc);
        family.setUsername(familyUsername);
        family.setFamilyName(familyName);

        familyRepository.save(family);
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(familyUsername, familyPassword);
        authToken.setDetails(new WebAuthenticationDetails(request));
        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);


        return new RedirectView("/calendar");
    }
}
