package cl.coopeuch.tasks.controller;

import cl.coopeuch.tasks.dto.CreateTaskRequest;
import cl.coopeuch.tasks.entity.TaskEntity;
import cl.coopeuch.tasks.service.impl.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskEntity>> listTasks(){
        List<TaskEntity> tasks = taskService.listTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskEntity> readTask(@PathVariable Long taskId){
        TaskEntity task = taskService.readTask(taskId);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity createTask(@RequestBody CreateTaskRequest task){
        return ResponseEntity.ok(
                taskService.createTask(
                        TaskEntity.builder()
                                .description(task.getDescription())
                                .vigency(task.getVigency())
                                .build()));
    }
}
