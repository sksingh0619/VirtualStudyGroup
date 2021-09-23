package com.light.nearbyvsg;

public class Groups {

    String name;
    String subject;
    String topic;
    String description;

    public Groups(String name, String subject, String topic, String description) {
        this.name = name;
        this.subject = subject;
        this.topic = topic;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
