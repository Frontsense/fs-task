package com.mag.frontsense.models;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MongoTask {

    private final String DBUser         = "root";
    private final String DBPassword     = "jXi5B86rnboc2SQC";
    private final String DBName         = "fs-tasks";
    private final String DBCollection   = "tasks";

    private MongoClient connectDB() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://"+ DBUser +":"+ DBPassword +"@cluster0-9m5aj.mongodb.net/"+ DBName +"?retryWrites=true&w=majority");

        return new MongoClient(uri);
    }

    public List<Task> getAllTasks() {
        MongoClient client = connectDB();
        MongoDatabase db = client.getDatabase(DBName);
        MongoCollection<Document> taskCollection = db.getCollection(DBCollection);

        List<Task> results = new ArrayList<>();

        for(Document curr : taskCollection.find()) {
            Task currTask = new Task(curr.getInteger("taskId"),
                    curr.getString("desc"),
                    curr.getString("sensorType"),
                    curr.getDouble("lat"),
                    curr.getDouble("lng"),
                    curr.getDouble("radius")
            );

            results.add(currTask);
        }

        return results;
    }

    public void insertTask(JSONObject jsonTask) {
        MongoClient client = connectDB();
        MongoDatabase db = client.getDatabase(DBName);
        MongoCollection<Document> taskCollection = db.getCollection(DBCollection);

        //get last id
        int last = taskCollection.find().sort(new BasicDBObject("taskId", -1)).first().getInteger("taskId");

        Document newTask = Document.parse(jsonTask.toString());
        newTask.append("taskId", last + 1);
        Double radius = jsonTask.getDouble("radius");
        newTask.remove("radius");
        newTask.append("radius", radius);

        taskCollection.insertOne(newTask);
    }
}
