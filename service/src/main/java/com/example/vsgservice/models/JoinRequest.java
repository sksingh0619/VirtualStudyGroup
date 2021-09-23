package com.example.vsgservice.models;

import org.springframework.data.annotation.Id;

public class JoinRequest {
    @Id
    public String id;
    public String memberId;
    public String groupId;
    public String studyGroupName;
    public JoinRequestStatus status;

    public String getStudyGroupName() {
        return studyGroupName;
    }

    public void setStudyGroupName(String studyGroupName) {
        this.studyGroupName = studyGroupName;
    }

    public JoinRequest(String memberId, String groupId) {
        this.memberId = memberId;
        this.groupId = groupId;
    }

    public JoinRequestStatus getStatus() {
        return this.status;
    }
}

