package com.example.vsgservice.controllers;

import com.example.vsgservice.dbService.JoinRequestService;
import com.example.vsgservice.dbService.MemberService;
import com.example.vsgservice.models.JoinRequestResult;
import com.example.vsgservice.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    JoinRequestService joinRequestService;

    @GetMapping("/members/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable String memberId) {
        Member member = memberService.getMember(memberId);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with " + memberId + " not found");
        }
    }

    @PutMapping("/members")
    public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
        Member createdMember = memberService.createMember(member);
        return ResponseEntity.ok(createdMember);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getMembers() {
        return new ResponseEntity<>(memberService.getMembers(), HttpStatus.OK);
    }

    @GetMapping("/members/{memberId}/requests")
    public ResponseEntity<List<JoinRequestResult>> listJoinRequests(@PathVariable String memberId) {
        return ResponseEntity.ok(joinRequestService.getJoinRequests(memberId));

    }

    @DeleteMapping("/members/{memberId}/requests/{requestId}")
    public ResponseEntity deleteJoinRequest() {

        return new ResponseEntity(HttpStatus.OK);

    }
}
