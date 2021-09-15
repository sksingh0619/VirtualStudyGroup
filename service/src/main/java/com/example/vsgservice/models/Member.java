package com.example.vsgservice.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Member {

    @BsonProperty("id")
    public int id;
    @BsonProperty("name")
    public String name;
    @BsonProperty("email_id")
    public String emailId;

    public Member(int id, String name, String emailId) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }
}
