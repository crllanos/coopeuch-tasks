package cl.coopeuch.tasks.service;

import cl.coopeuch.tasks.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITaskService {
    List<TaskEntity> listTasks();
    TaskEntity createTask(TaskEntity task);
    TaskEntity readTask(Long taskId);
    TaskEntity updateTask(Long taskId, TaskEntity newTask);
    void deleteTask(Long taskId);
}
