package task;

//imports HashMap
import java.util.HashMap;

//imports Map
import java.util.Map;

//defines the TaskService class
public class TaskService {

 // stores tasks in memory
 private final Map<String, Task> tasks = new HashMap<>();

 // adds a task
 public void addTask(Task task) {

     // checks task for null
     if (task == null) {
    	 
         // throws exception for invalid task
         throw new IllegalArgumentException("Task cannot be null.");
     }

     // checks for duplicate ID
     if (tasks.containsKey(task.getTaskId())) {
    	 
         // throws exception for duplicate ID
         throw new IllegalArgumentException("Task ID must be unique.");
     }

     // adds the task to the map
     tasks.put(task.getTaskId(), task);
 }

 // deletes a task by ID
 public void deleteTask(String taskId) {

     // removes the task
     tasks.remove(taskId);
 }

 // updates a task name by ID
 public void updateTaskName(String taskId, String name) {

     // gets the task from the map
     Task task = tasks.get(taskId);

     // checks if task exists
     if (task == null) {
    	 
         // throws exception if task is missing
         throw new IllegalArgumentException("Task ID not found.");
     }

     // updates the name
     task.setName(name);
 }

 // updates a task description by ID
 public void updateTaskDescription(String taskId, String description) {

     // gets the task from the map
     Task task = tasks.get(taskId);

     // checks if task exists
     if (task == null) {
    	 
         // throws exception if task is missing
         throw new IllegalArgumentException("Task ID not found.");
     }

     // updates the description
     task.setDescription(description);
 }

 // returns a task by ID
 public Task getTask(String taskId) {
	 
     // sends back the task
     return tasks.get(taskId);
 }
}