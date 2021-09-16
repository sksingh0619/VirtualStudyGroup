package com.example.vsgservice.dbService;

import com.example.vsgservice.models.StudyGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudyGroupRepository extends MongoRepository<StudyGroup, String> {
}
