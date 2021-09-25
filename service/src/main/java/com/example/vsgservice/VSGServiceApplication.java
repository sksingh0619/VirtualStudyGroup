package com.example.vsgservice;

import com.example.vsgservice.dbService.JoinRequestRepository;
import com.example.vsgservice.dbService.MemberRepository;
import com.example.vsgservice.dbService.StudyGroupRepository;
import com.example.vsgservice.models.Member;
import com.example.vsgservice.models.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VSGServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(VSGServiceApplication.class, args);
    }
}
