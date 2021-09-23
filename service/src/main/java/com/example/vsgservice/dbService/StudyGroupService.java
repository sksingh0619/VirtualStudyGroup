package com.example.vsgservice.dbService;

import com.example.vsgservice.models.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyGroupService {

    @Autowired
    StudyGroupRepository studyGroupRepository;

    public StudyGroup getStudyGroup(String groupId){
       Optional<StudyGroup> studyGroup = studyGroupRepository.findById(groupId);
       if(studyGroup.isPresent()){
           return studyGroup.get();
       }
       return null;
    }

    public StudyGroup createStudyGroup(StudyGroup studyGroup){
        return studyGroupRepository.save(studyGroup);
    }

    public List<StudyGroup> getStudyGroups(){
        return studyGroupRepository.findAll();
    }

    public StudyGroup updateStudyGroup(StudyGroup studyGroup){
        return studyGroupRepository.save(studyGroup);
    }
}
