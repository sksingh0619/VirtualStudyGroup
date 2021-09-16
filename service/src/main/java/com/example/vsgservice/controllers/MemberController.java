package com.example.vsgservice.controllers;

import com.example.vsgservice.dbService.MemberRepository;
import com.example.vsgservice.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable String memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            return new ResponseEntity<>(member.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with " + memberId + " not found");
            //return new ResponseEntity<>(, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/members")
    public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
        Member createdMember = memberRepository.save(member);
        return ResponseEntity.ok(createdMember);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getMembers(){
        return new ResponseEntity<>(memberRepository.findAll(),HttpStatus.OK);
    }
}
