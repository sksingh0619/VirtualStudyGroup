package com.example.vsgservice.dbService;

import com.example.vsgservice.models.JoinRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JoinRequestRepository extends MongoRepository<JoinRequest, String> {
}
