package com.example.vsgservice.controllers;

import com.example.vsgservice.dbService.JoinRequestService;
import com.example.vsgservice.dbService.MemberService;
import com.example.vsgservice.dbService.StudyGroupService;
import com.example.vsgservice.models.JoinRequest;
import com.example.vsgservice.models.JoinRequestStatus;
import com.example.vsgservice.models.Member;
import com.example.vsgservice.models.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudyGroupController {
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    StudyGroupService studyGroupService;

    @Autowired
    JoinRequestService joinRequestService;

    @Autowired
    MemberService memberService;

    @GetMapping("/studyGroups/{groupId}")
    public StudyGroup getStudyGroup(@PathVariable String groupId){
        return studyGroupService.getStudyGroup(groupId);
    }

    @PutMapping("/studyGroups")
    public ResponseEntity<StudyGroup> createStudyGroup(@Valid @RequestBody StudyGroup studyGroup){
        StudyGroup createdStudyGroup = studyGroupService.createStudyGroup(studyGroup);
        return ResponseEntity.ok(createdStudyGroup);
    }

    @GetMapping("/studyGroups")
    public ResponseEntity<List<StudyGroup>> getStudyGroups(@RequestParam (required = false) String subject, @RequestParam (required = false) String topic) {

        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();

        if (subject != null && !subject.isEmpty() && !subject.isBlank()) {
            criteria.add(Criteria.where("subject").is(subject));
        }

        if (topic != null && !topic.isEmpty() && !topic.isBlank()) {
            criteria.add(Criteria.where("topic").is(topic));

        }

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
            return ResponseEntity.ok(mongoTemplate.find(query, StudyGroup.class));
        }else{
            return ResponseEntity.ok(studyGroupService.getStudyGroups());
        }
    }

    @PostMapping("/studyGroups/{groupId}/members/{memberId}/join")
    public void join(@PathVariable String groupId, @PathVariable String memberId){
        Member member = memberService.getMember(memberId);
        StudyGroup studyGroup = studyGroupService.getStudyGroup(groupId);
        if (member != null && studyGroup != null){
            // studyGroup.memberIds.add(memberId);
            // studyGroupService.updateStudyGroup(studyGroup);
            joinRequestService.createJoinRequest(member.id, studyGroup.id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/studyGroups/{groupId}/requests/{requestId}/accept")
    public void acceptJoinRequest(@PathVariable String groupId, @PathVariable String requestId){
        JoinRequest joinRequest = joinRequestService.getJoinRequest(requestId);
        StudyGroup studyGroup = studyGroupService.getStudyGroup(groupId);
        if (joinRequest != null && studyGroup != null){
            // update join request => set status to Accepted
            // update request
            // studyGroup.memberIds.add(memberId);
            // studyGroupService.updateStudyGroup(studyGroup);
            joinRequest.status = JoinRequestStatus.ACCEPTED;
            joinRequestService.updateJoinRequest(joinRequest);
            studyGroup.memberIds.add(joinRequest.memberId);
            studyGroupService.updateStudyGroup(studyGroup);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/studyGroups/{groupId}/requests/{requestId}/reject")
    public void rejectJoinRequest(@PathVariable String groupId, @PathVariable String requestId){
        JoinRequest joinRequest = joinRequestService.getJoinRequest(requestId);
        StudyGroup studyGroup = studyGroupService.getStudyGroup(groupId);
        if (joinRequest != null && studyGroup != null){
            joinRequest.status = JoinRequestStatus.DECLINE;
            joinRequestService.updateJoinRequest(joinRequest);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



}
