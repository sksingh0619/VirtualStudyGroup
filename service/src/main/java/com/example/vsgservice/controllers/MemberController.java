package com.example.vsgservice.controllers;

import com.example.vsgservice.dbService.DbService;
import com.example.vsgservice.models.Member;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private DbService dbService;

    @Autowired
    public MemberController(DbService dbService) {
        this.dbService = dbService;
    }

    @GetMapping("/member/{memberId}")
    public Member getMember(@PathVariable int memberId) {
        DBObject dbObject = this.dbService.FetchDocument(memberId,"member_doc");

        return new Member(memberId, "TestUser", "testuser@test.com");
    }
}
