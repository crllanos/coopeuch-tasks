package cl.coopeuch.tasks.service;

import cl.coopeuch.tasks.entity.TaskEntity;
import org.springframework.stereotype.Service;

@Service
public interface ITaskService {
    TaskEntity createTask(TaskEntity task);
}
