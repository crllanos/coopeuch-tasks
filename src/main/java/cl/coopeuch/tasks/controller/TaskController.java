package cl.coopeuch.tasks.controller;

import cl.coopeuch.tasks.dto.TaskRequest;
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

    @PostMapping
    public ResponseEntity createTask(@RequestBody TaskRequest task){
        return ResponseEntity.ok(
                taskService.createTask(
                        TaskEntity.builder()
                                .description(task.getDescription())
                                .vigency(task.getVigency())
                                .build()));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskEntity> readTask(@PathVariable Long taskId){
        TaskEntity task = taskService.readTask(taskId);
        return ResponseEntity.ok(task);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable Long taskId,
                                                 @RequestBody TaskRequest task){
        TaskEntity newTask = taskService.updateTask(taskId,
                TaskEntity.builder()
                        .description(task.getDescription())
                        .vigency(task.getVigency())
                .build());
        return ResponseEntity.ok(newTask);
    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}
