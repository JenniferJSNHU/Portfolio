package test;

import task.Task;
import task.TaskService;

//imports JUnit assertions
import static org.junit.jupiter.api.Assertions.*;

//imports Test annotation
import org.junit.jupiter.api.Test;

//defines TaskService tests
public class TaskServiceTest {

 // tests adding a task
 @Test
 public void testAddTask() {

     // creates the service
     TaskService service = new TaskService();

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // adds the task
     service.addTask(task);

     // checks stored task
     assertTrue(service.getTask("123").equals(task));
 }

 // tests duplicate task ID
 @Test
 public void testDuplicateTaskId() {

     // creates the service
     TaskService service = new TaskService();

     // creates first task
     Task task1 = new Task("123", "Homework", "Finish Module Four assignment.");

     // creates second task
     Task task2 = new Task("123", "Project", "Submit project work.");

     // adds first task
     service.addTask(task1);

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // adds duplicate task
         service.addTask(task2);
     });
 }

 // tests deleting a task
 @Test
 public void testDeleteTask() {

     // creates the service
     TaskService service = new TaskService();

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // adds the task
     service.addTask(task);

     // deletes the task
     service.deleteTask("123");

     // checks that task is gone
     assertNull(service.getTask("123"));
 }

 // tests updating name
 @Test
 public void testUpdateTaskName() {

     // creates the service
     TaskService service = new TaskService();

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // adds the task
     service.addTask(task);

     // updates the name
     service.updateTaskName("123", "Project");

     // checks updated name
     assertTrue(service.getTask("123").getName().equals("Project"));
 }

 // tests updating description
 @Test
 public void testUpdateTaskDescription() {

     // creates the service
     TaskService service = new TaskService();

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // adds the task
     service.addTask(task);

     // updates the description
     service.updateTaskDescription("123", "Submit the completed task service.");

     // checks updated description
     assertTrue(service.getTask("123").getDescription().equals("Submit the completed task service."));
 }

 // tests updating missing task name
 @Test
 public void testUpdateMissingTaskName() {

     // creates the service
     TaskService service = new TaskService();

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // updates missing task
         service.updateTaskName("999", "Project");
     });
 }

 // tests updating missing task description
 @Test
 public void testUpdateMissingTaskDescription() {

     // creates the service
     TaskService service = new TaskService();

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // updates missing task
         service.updateTaskDescription("999", "New description.");
     });
 }
}