package com.example.taskmanagement.repository;

import com.example.taskmanagement.entity.Task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testTaskPersistence() {

    
        Task task = new Task(
                "Complete Lab",
                "Repository Integration Testing"
        );

      
        Task savedTask = taskRepository.save(task);

        
        Optional<Task> retrievedTask =
                taskRepository.findById(savedTask.getId());

       
        assertNotNull(savedTask.getId());

        assertTrue(retrievedTask.isPresent());

        assertEquals(
                "Complete Lab",
                retrievedTask.get().getTitle()
        );

        assertEquals(
                "Repository Integration Testing",
                retrievedTask.get().getDescription()
        );

        System.out.println("Task ID: " + savedTask.getId());
        System.out.println("Task Title: " + retrievedTask.get().getTitle());
        System.out.println("Task Retrieved Successfully!");
    }
}