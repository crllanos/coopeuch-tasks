package cl.coopeuch.tasks.service.impl;

import cl.coopeuch.tasks.entity.TaskEntity;
import cl.coopeuch.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class TaskServiceTest {

        @InjectMocks
        private TaskService taskService;

        @Mock
        private TaskRepository taskRepository;

        @Test
        public void shouldReadTask_Ok(){
            when(taskRepository.findById(1L)).thenReturn(mockTaskEntity());
            TaskEntity a = taskService.readTask(100L);
            Assertions.assertNotNull(a);
        }


    @Test
    public void shouldNotReadTask_NotFound(){
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            taskService.readTask(anyLong());
        });
        String expectedMessage = "not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

        /**
         * mock data
         * */
        private Optional<TaskEntity> mockTaskEntity() {
            return Optional.ofNullable(TaskEntity.builder()
                    .description("task de prueba")
                    .creation(LocalDateTime.now())
                    .build());
        }

        private List<Optional<TaskEntity>> mockTaskEntityList() {
            return List.of(mockTaskEntity(),mockTaskEntity(),mockTaskEntity(),
                    mockTaskEntity(),mockTaskEntity());
    }

    }