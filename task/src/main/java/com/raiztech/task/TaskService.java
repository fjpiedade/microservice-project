package com.raiztech.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public boolean saveTask(UUID projectID) {
        taskRepository.save(Task.builder()
                .projectID(projectID)
                .title("New Task")
                .description("more one task on the table")
                .link("https://local.hub.png")
                .image("photo.png")
                .status("open task")
                .createdAt(LocalDateTime.now())
                .build());
        return true;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
