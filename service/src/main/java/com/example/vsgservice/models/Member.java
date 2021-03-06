package com.example.vsgservice.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Member {

    @Id
    public String id;

    @BsonProperty("name")
    public String name;
    @BsonProperty("email_id")
    public String emailId;
    @BsonProperty("profile")
    public String profile;

    public Member(String name, String emailId,String profile) {
        this.name = name;
        this.emailId = emailId;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getProfile() {
        return profile;
    }
}
