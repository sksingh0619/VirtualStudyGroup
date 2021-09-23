package com.example.vsgservice.dbService;

import com.example.vsgservice.models.JoinRequest;
import com.example.vsgservice.models.JoinRequestStatus;
import com.example.vsgservice.models.JoinRequestResult;
import com.example.vsgservice.models.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoinRequestService {
    @Autowired
    JoinRequestRepository joinRequestRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    StudyGroupService studyGroupService;

    public JoinRequest createJoinRequest(String memberId, String groupId) {
        JoinRequest requestJoin = new JoinRequest(memberId, groupId);
        requestJoin.status = JoinRequestStatus.PENDING;
        return joinRequestRepository.save(requestJoin);
    }

    public JoinRequest getJoinRequest(String requestId) {
        return joinRequestRepository.findById(requestId).get();
    }

    public void updateJoinRequest(JoinRequest joinRequest) {
        joinRequestRepository.save(joinRequest);
    }

    public List<JoinRequestResult> getJoinRequests(String memberId) {
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();
        if (memberId != null && !memberId.isBlank() && !memberId.isBlank()) {
            criteria.add(Criteria.where("memberId").is(memberId));
        }
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        List<JoinRequest> joinRequestList = mongoTemplate.find(query, JoinRequest.class);
        List<JoinRequestResult> joinResponseList = new ArrayList<>();
        for (JoinRequest joinRequest : joinRequestList) {
            JoinRequestResult joinRequestResult = new JoinRequestResult();
            joinRequestResult.setRequestId(joinRequest.id);
            joinRequestResult.setStudyGroupId(joinRequest.groupId);
            StudyGroup studyGroup = studyGroupService.getStudyGroup(joinRequest.groupId);
            joinRequestResult.setStudyGroupName(studyGroup.getGroupName());
            joinRequestResult.setStudyGroupSubject(studyGroup.getSubject());
            joinRequestResult.setStudyGroupTopic(studyGroup.getTopic());
            joinRequestResult.setStatus(joinRequest.getStatus());
            joinResponseList.add(joinRequestResult);
        }
        return joinResponseList;
    }
}
