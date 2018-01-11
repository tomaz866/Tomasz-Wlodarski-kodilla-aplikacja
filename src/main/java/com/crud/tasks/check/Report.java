package com.crud.tasks.check;

import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Report {

    @Autowired
    private TaskRepository taskRepository;

    public long countTasks() {
        long size = taskRepository.count();

        return size;
    }

    public boolean checkShow() {
        long size = taskRepository.count();
        if(size > 0) {
            return true;
        }
        return false;
    }
}
