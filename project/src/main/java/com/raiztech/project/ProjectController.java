package com.raiztech.project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    //@HystrixCommand(fallbackMethod="unknown")
    @PostMapping
    public void createProject(@RequestBody Project projectRegistrationRequest){
        log.info("new Project created {}",projectRegistrationRequest);
        projectService.registerProject(projectRegistrationRequest);
    }
    public String unknown() {
        System.out.println("~~~~~~~~~");
        return "unknown";
    }


    @GetMapping
    public ResponseEntity<List<Project>> getAllProject(){
        List<Project> projects = projectService.getAll();
        if (projects.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Project>>(projectService.getAll(), HttpStatus.OK);
    }
}
