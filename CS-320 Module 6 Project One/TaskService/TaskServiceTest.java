package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

public class TaskServiceTest {

    private TaskService testTaskService;

    @BeforeEach
    public void setUp() {
        testTaskService = new TaskService();
        testTaskService.addTask(new Task("goodID", "goodName", "goodDescription"));
    }

    @Test
    public void testAddTask() {
        assertTrue(testTaskService.taskMap.containsKey("goodID"));
    }

    @Test
    public void testDeleteTask() {
        testTaskService.deleteTask("goodID");
        assertTrue(!testTaskService.taskMap.containsKey("goodID"));
    }

    @Test
    public void testUpdateTaskName() {
        testTaskService.updateName("goodID", "newName");

        assertTrue(testTaskService.taskMap.get("goodID").getTaskName().equals("newName"));
    }
    
    @Test
    public void testUpdateTaskDescription() {
        testTaskService.updateDescription("goodID", "newDescription");

        assertTrue(testTaskService.taskMap.get("goodID").getTaskDescription().equals("newDescription"));
    }
    
    @Test
    public void testAddTaskWithDuplicateId() {
        assertThrows(IllegalArgumentException.class, () -> {
            testTaskService.addTask(new Task("goodID", "goodName2", "goodDescription2"));
        });
    }

    @Test
    void testDeleteNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            testTaskService.deleteTask("NonExistentID");
        });
    }

    @Test
    public void testUpdateNameNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            testTaskService.updateName("NonExistentID", "nonexistentname");
        });
    }
    
    @Test
    public void testUpdateDescriptionNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            testTaskService.updateName("NonExistentID", "nonexistentndescription");
        });
    }
}
