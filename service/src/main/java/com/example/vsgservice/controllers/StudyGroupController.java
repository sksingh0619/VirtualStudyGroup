package com.example.vsgservice.controllers;

import com.example.vsgservice.dbService.DbService;
import com.example.vsgservice.models.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyGroupController {
    private DbService dbService;

    @Autowired
    public StudyGroupController(DbService dbService) {
        this.dbService = dbService;
    }

    @GetMapping("/studyGroup/{groupId}")
    public StudyGroup getStudyGroup(@PathVariable int groupId){
        return new StudyGroup("df", "df","aas", "joyed");
    }
}
