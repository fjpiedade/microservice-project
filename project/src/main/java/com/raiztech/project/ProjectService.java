package com.raiztech.project;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record ProjectService(ProjectRepository projectRepository) {
    public void registerProject(ProjectRegistrationRequest request) {
        Project project = Project.builder()
                .name(request.name())
                .description(request.description())
                .link(request.link())
                .image(request.image())
                .createdAt(LocalDateTime.now())
                .build();
        //TODO: check if
        //TODO: store project in db
        projectRepository.save(project);
    }
}
