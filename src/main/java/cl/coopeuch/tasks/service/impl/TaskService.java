package cl.coopeuch.tasks.service.impl;

import cl.coopeuch.tasks.entity.TaskEntity;
import cl.coopeuch.tasks.repository.TaskRepository;
import cl.coopeuch.tasks.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity readTask(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() ->
                new EntityNotFoundException(String.format("task id %d not found.", taskId)));
    }

    @Override
    public List<TaskEntity> listTasks() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public TaskEntity updateTask(Long taskId, TaskEntity newTask) {
        TaskEntity update = this.readTask(taskId);
        update.setDescription(newTask.getDescription());
        update.setCreation(newTask.getCreation());
        update.setVigency(newTask.getVigency());
        return taskRepository.save(update);
    }


    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

}
