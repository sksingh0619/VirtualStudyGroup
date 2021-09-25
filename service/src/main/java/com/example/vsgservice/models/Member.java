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

    public Member(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
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
}
