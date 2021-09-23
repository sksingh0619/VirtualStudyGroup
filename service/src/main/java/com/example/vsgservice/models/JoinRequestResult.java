package com.example.vsgservice.models;

public class JoinRequestResult {
    String studyGroupId;
    String studyGroupName;
    String studyGroupSubject;
    String studyGroupTopic;
    String requestId;
    JoinRequestStatus status;

    public String getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(String studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public String getStudyGroupName() {
        return studyGroupName;
    }

    public void setStudyGroupName(String studyGroupName) {
        this.studyGroupName = studyGroupName;
    }

    public String getStudyGroupSubject() {
        return studyGroupSubject;
    }

    public void setStudyGroupSubject(String studyGroupSubject) {
        this.studyGroupSubject = studyGroupSubject;
    }

    public String getStudyGroupTopic() {
        return studyGroupTopic;
    }

    public void setStudyGroupTopic(String studyGroupTopic) {
        this.studyGroupTopic = studyGroupTopic;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public JoinRequestStatus getStatus() {
        return status;
    }

    public void setStatus(JoinRequestStatus status) {
        this.status = status;
    }
}
