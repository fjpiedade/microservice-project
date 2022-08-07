package com.raiztech.project;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    private final RestTemplate restTemplate;

    public void registerProject(Project request) {
        Project project = Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .link(request.getLink())
                .image(request.getImage())
                .createdAt(LocalDateTime.now())
                .build();
        //TODO: check if
        //TODO: store project in db
        projectRepository.saveAndFlush(project);
        //TODO: insert Default Task from new Project
        TaskResponse taskResponse = restTemplate.getForObject(
                //"http://localhost:9010/api/v1/tasks/{projectID}",
                "http://TASK/api/v1/tasks/{projectID}",
                TaskResponse.class,
                project.getId());
        if(!taskResponse.isExist()){
          throw new IllegalStateException("Save Project Successfully");
        }
        //TODO: send Notification
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}
