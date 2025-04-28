package task;

import java.util.HashMap;

import contact.Contact;

public class TaskService {
	public HashMap<String, Task> taskMap = new HashMap<>();
	    
    public void addTask(Task task) {
    	if (taskMap.containsKey(task.getTaskID())) {
    		throw new IllegalArgumentException("Task ID already exists");
    	}
    	taskMap.put(task.getTaskID(), task);
    }
    
    public void deleteTask(String taskID) {
    	if (!taskMap.containsKey(taskID)) {
    		throw new IllegalArgumentException("Task not found");
    	}
    	taskMap.remove(taskID);
    }
    
    public void updateName(String taskID, String taskName) {
    	Task searchTask = taskMap.get(taskID);
    	if (searchTask == null) {
    		throw new IllegalArgumentException("Task not found.");
    	}
    	
    	searchTask.setTaskName(taskName);
    }
    
    public void updateDescription(String taskID, String taskDescription) {
    	Task searchTask = taskMap.get(taskID);
    	if (searchTask == null) {
    		throw new IllegalArgumentException("Task not found.");
    	}
    	
    	searchTask.setTaskName(taskDescription);
    }	
}
