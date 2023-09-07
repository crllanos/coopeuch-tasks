package cl.coopeuch.tasks.service.impl;

import cl.coopeuch.tasks.entity.TaskEntity;
import cl.coopeuch.tasks.repository.TaskRepository;
import cl.coopeuch.tasks.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }
}
