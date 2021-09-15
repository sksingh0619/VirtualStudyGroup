package com.example.vsgservice.dbService;

import com.example.vsgservice.models.Member;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

public class DbService {
    private MongoClient mongoClient;
    private DB database;
    private DBCollection dbCollection;

    public DbService() {
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://vsg-mongo:ZWoZWs7W4WKJ0SmmxoFL277u6uI28dyYZs3xuRyny80VvIwjQQBA1wU7kDB2jtDrg4r4UtnAlbcd6dKoa91csQ==@vsg-mongo.mongo.cosmos.azure.com:10255/?ssl=true&replicaSet=globaldb&retrywrites=false&maxIdleTimeMS=120000&appName=@vsg-mongo@"));
            database = mongoClient.getDB("vsg-db");
            dbCollection = database.getCollection("resources");
        } catch (Exception ex) {
            // ignore
        }
    }

    public void InsertDocument(DBObject dbObject) {
        dbCollection.insert(dbObject);
    }

    public DBObject FetchDocument(int docId, String docType) {
        DBObject query = new BasicDBObject("_id", docId).append("type", docType);
        DBCursor cursor = dbCollection.find(query);
        return cursor.one();
    }
}
