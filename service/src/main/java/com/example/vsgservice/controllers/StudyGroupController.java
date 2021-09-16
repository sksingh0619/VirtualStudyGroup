package com.example.vsgservice.controllers;

import com.example.vsgservice.dbService.DbService;
import com.example.vsgservice.dbService.StudyGroupRepository;
import com.example.vsgservice.models.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudyGroupController {

    @Autowired
    StudyGroupRepository studyGroupRepository;

    @GetMapping("/studyGroups/{groupId}")
    public StudyGroup getStudyGroup(@PathVariable String groupId){
        return studyGroupRepository.findById(groupId).get();
    }

    @PutMapping("/studyGroups")
    public ResponseEntity<StudyGroup> createStudyGroup(@Valid @RequestBody StudyGroup studyGroup){
        StudyGroup createdStudyGroup = studyGroupRepository.save(studyGroup);
        return ResponseEntity.ok(createdStudyGroup);
    }

    @GetMapping("/studyGroups")
    public ResponseEntity<List<StudyGroup>> getStudyGroups(){
        return new ResponseEntity<>(studyGroupRepository.findAll(), HttpStatus.OK);
    }
}
