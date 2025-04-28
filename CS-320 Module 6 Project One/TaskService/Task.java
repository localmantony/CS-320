package task;

public class Task {
	private final String taskID;
	private String taskName;
	private String taskDescription;
	
	public Task(String taskID, String taskName, String taskDescription) {
		if(taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException("Invalid task ID");
		}
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid task name");
		}
		if(taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid task description");
		}
		
		this.taskID = taskID;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	public String getTaskID() {
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		this.taskName = taskName;
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		this.taskDescription = taskDescription;
	}
}
