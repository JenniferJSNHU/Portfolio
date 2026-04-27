package task;

//defines the Task class
public class Task {

 // stores the task ID
 private final String taskId;

 // stores the task name
 private String name;

 // stores the task description
 private String description;

 // creates a task object
 public Task(String taskId, String name, String description) {

     // checks task ID for null
     if (taskId == null) {
    	 
         // throws exception for invalid ID
         throw new IllegalArgumentException("Task ID cannot be null.");
     }

     // checks task ID length
     if (taskId.length() > 10) {
    	 
         // throws exception for invalid ID length
         throw new IllegalArgumentException("Task ID cannot be longer than 10 characters.");
     }

     // checks name for null
     if (name == null) {
    	 
         // throws exception for invalid name
         throw new IllegalArgumentException("Task name cannot be null.");
     }

     // checks name length
     if (name.length() > 20) {
    	 
         // throws exception for invalid name length
         throw new IllegalArgumentException("Task name cannot be longer than 20 characters.");
     }

     // checks description for null
     if (description == null) {
    	 
         // throws exception for invalid description
         throw new IllegalArgumentException("Task description cannot be null.");
     }

     // checks description length
     if (description.length() > 50) {
    	 
         // throws exception for invalid description length
         throw new IllegalArgumentException("Task description cannot be longer than 50 characters.");
     }

     // assigns the task ID
     this.taskId = taskId;

     // assigns the name
     this.name = name;

     // assigns the description
     this.description = description;
 }

 // returns the task ID
 public String getTaskId() {
	 
     // sends back the task ID
     return taskId;
 }

 // returns the task name
 public String getName() {
	 
     // sends back the name
     return name;
 }

 // returns the task description
 public String getDescription() {
	 
     // sends back the description
     return description;
 }

 // updates the task name
 public void setName(String name) {

     // checks name for null
     if (name == null) {
    	 
         // throws exception for invalid name
         throw new IllegalArgumentException("Task name cannot be null.");
     }

     // checks name length
     if (name.length() > 20) {
    	 
         // throws exception for invalid name length
         throw new IllegalArgumentException("Task name cannot be longer than 20 characters.");
     }

     // updates the name
     this.name = name;
 }

 // updates the task description
 public void setDescription(String description) {

     // checks description for null
     if (description == null) {
    	 
         // throws exception for invalid description
         throw new IllegalArgumentException("Task description cannot be null.");
     }

     // checks description length
     if (description.length() > 50) {
    	 
         // throws exception for invalid description length
         throw new IllegalArgumentException("Task description cannot be longer than 50 characters.");
     }

     // updates the description
     this.description = description;
 }
}