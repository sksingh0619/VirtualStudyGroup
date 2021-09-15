package com.example.vsgservice;

import com.example.vsgservice.dbService.MemberRepository;
import com.example.vsgservice.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VSGServiceApplication implements CommandLineRunner {

	@Autowired
	MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(VSGServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		memberRepository.save(new Member("22f2", "Raghvan", "raghu@rag.com"));
		memberRepository.save(new Member("12f2", "Abhi", "abhi@rag.com"));
	}
}
