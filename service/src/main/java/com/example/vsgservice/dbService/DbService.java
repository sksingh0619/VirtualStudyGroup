package com.example.vsgservice.dbService;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;

@Component
public class DbService {
    private final MongoDatabaseFactory mongoDatabaseFactory;

    public DbService(MongoDatabaseFactory mongoDatabaseFactory) {
        this.mongoDatabaseFactory = mongoDatabaseFactory;
    }
}
