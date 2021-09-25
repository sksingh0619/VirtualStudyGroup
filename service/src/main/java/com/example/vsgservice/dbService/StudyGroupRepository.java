package com.example.vsgservice.dbService;

import com.example.vsgservice.models.StudyGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends MongoRepository<StudyGroup, String> {
}
