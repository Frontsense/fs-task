package com.mag.frontsense.beans;

import com.mag.frontsense.models.MongoTask;
import com.mag.frontsense.models.Task;
import org.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.List;

@RequestScoped
public class TaskBean {

    private Client httpClient;

    @Inject
    private TaskBean taskBean;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    public List<Task> allTasks() {
        MongoTask mt = new MongoTask();

        return mt.getAllTasks();
    }

    public Task getTask(Integer taskId) {
        MongoTask mt = new MongoTask();

        return mt.getTaskById(taskId);
    }

    public void insertTask(JSONObject jsonTask) {
        MongoTask mt = new MongoTask();

        mt.insertTask(jsonTask);
    }
}
