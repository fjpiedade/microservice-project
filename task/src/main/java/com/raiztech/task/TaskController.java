package com.raiztech.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping(path = "{projectID}")
    public TaskResponse saveTask(@PathVariable UUID projectID){
        log.info("new Task Created on Project with ID {}",projectID);
        taskService.saveTask(projectID);
        return new TaskResponse(true);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTask(){
        List<Task> tasks = taskService.getAll();
        if (tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Task>>(taskService.getAll(), HttpStatus.OK);
    }
}
