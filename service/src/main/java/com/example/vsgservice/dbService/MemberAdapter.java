package com.example.vsgservice.dbService;

import com.example.vsgservice.models.Member;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;

public class MemberAdapter {
    public static final DBObject toDBObject(Member member) {
        return new BasicDBObject("_id", member.getId())
                .append("name", member.getName())
                .append("emailId", member.getEmailId());
    }

    public static Member toMemberObject(DBObject dbObject) {

       return new Member((int)dbObject.get("_id"), dbObject.get("name"), dbObject.get("emailId"));


    }
}
