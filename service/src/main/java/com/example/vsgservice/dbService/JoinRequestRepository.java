package com.example.vsgservice.dbService;

import com.example.vsgservice.models.JoinRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinRequestRepository extends MongoRepository<JoinRequest, String> {
}
