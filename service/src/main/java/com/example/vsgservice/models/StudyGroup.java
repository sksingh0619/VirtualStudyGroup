package com.example.vsgservice.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
public class StudyGroup {

    @Id
    public String id;
    @BsonProperty("group_name")
    public String groupName;
    @BsonProperty("subject")
    public  String subject;
    @BsonProperty("topic")
    public String topic;
    @BsonProperty("description")
    public String description;
    public List<String> memberIds;

    public StudyGroup(String groupName, String subject, String topic, String description) {
        this.groupName = groupName;
        this.subject = subject;
        this.topic = topic;
        this.description = description;
        memberIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getMemberIds() {
        return memberIds;
    }
}
