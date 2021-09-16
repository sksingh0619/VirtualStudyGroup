package com.example.vsgservice;

import com.example.vsgservice.dbService.MemberRepository;
import com.example.vsgservice.dbService.StudyGroupRepository;
import com.example.vsgservice.models.Member;
import com.example.vsgservice.models.StudyGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VSGServiceApplication implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	StudyGroupRepository studyGroupRepository;

	public static void main(String[] args) {
		SpringApplication.run(VSGServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		memberRepository.save(new Member( "Raghvan", "raghu@rag.com"));
//		memberRepository.save(new Member( "Abhi", "abhi@rag.com"));

//		var s = studyGroupRepository.save(new StudyGroup("Sksingh","math","algebra","description"));
//		System.out.println(s.id);
	}
}
