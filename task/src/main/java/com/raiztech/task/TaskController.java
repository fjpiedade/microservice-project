package com.raiztech.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
    //ResponseEntity<Task>
    @GetMapping(path = "{projectID}")
    public TaskResponse saveTask(@PathVariable UUID projectID){
        log.info("new Task Created on Project with ID {}",projectID);
        taskService.saveTask(projectID);
        return new TaskResponse(true);
    }
}
