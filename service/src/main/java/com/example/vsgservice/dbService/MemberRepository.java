package com.example.vsgservice.dbService;

import com.example.vsgservice.models.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
