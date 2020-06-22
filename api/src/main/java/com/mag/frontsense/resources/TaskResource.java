package com.mag.frontsense.resources;

import com.mag.frontsense.beans.TaskBean;
import com.mag.frontsense.models.Task;
import org.json.JSONObject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/task")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    private TaskBean taskBean;

    @GET
    @Path("/test")
    public Response testResponse() {
        return Response.ok("Task api is up and running!")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept")
                .build();
    }

    @GET
    @Path("/all")
    public Response getTasks() {
        List<Task> tasks = taskBean.allTasks();

        return Response.ok(tasks)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept")
                .build();
    }

    @OPTIONS
    @Path("/insert")
    public Response optionsInsert() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8100")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept")
                .build();
    }

    @POST
    @Path("/insert")
    public Response insertTask(String task) {
        taskBean.insertTask(new JSONObject(task));

        return Response.ok()
                .header("Access-Control-Allow-Origin", "http://localhost:8100")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Origin, Content-Type, Accept")
                .build();
    }
}
