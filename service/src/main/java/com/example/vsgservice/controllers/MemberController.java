package com.example.vsgservice.controllers;

import com.example.vsgservice.dbService.DbService;
import com.example.vsgservice.dbService.MemberRepository;
import com.example.vsgservice.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/member/{memberId}")
    public Member getMember(@PathVariable String memberId) {
        return memberRepository.findById(memberId).get();
    }
}
