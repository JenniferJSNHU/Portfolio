package test;

import task.Task;

//imports JUnit assertions
import static org.junit.jupiter.api.Assertions.*;

//imports Test annotation
import org.junit.jupiter.api.Test;

//defines Task tests
public class TaskTest {

 // tests valid task creation
 @Test
 public void testTaskCreation() {

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // checks the task ID
     assertTrue(task.getTaskId().equals("123"));

     // checks the task name
     assertTrue(task.getName().equals("Homework"));

     // checks the task description
     assertTrue(task.getDescription().equals("Finish Module Four assignment."));
 }

 // tests null task ID
 @Test
 public void testTaskIdNull() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // creates invalid task
         new Task(null, "Homework", "Finish Module Four assignment.");
     });
 }

 // tests long task ID
 @Test
 public void testTaskIdTooLong() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // creates invalid task
         new Task("12345678901", "Homework", "Finish Module Four assignment.");
     });
 }

 // tests null task name
 @Test
 public void testTaskNameNull() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // creates invalid task
         new Task("123", null, "Finish Module Four assignment.");
     });
 }

 // tests long task name
 @Test
 public void testTaskNameTooLong() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // creates invalid task
         new Task("123", "ThisTaskNameIsWayTooLong", "Finish Module Four assignment.");
     });
 }

 // tests null description
 @Test
 public void testTaskDescriptionNull() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // creates invalid task
         new Task("123", "Homework", null);
     });
 }

 // tests long description
 @Test
 public void testTaskDescriptionTooLong() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // creates invalid task
         new Task("123", "Homework", "This description is definitely longer than fifty characters total for testing.");
     });
 }

 // tests valid name update
 @Test
 public void testSetName() {

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // updates the name
     task.setName("Project");

     // checks updated name
     assertTrue(task.getName().equals("Project"));
 }

 // tests valid description update
 @Test
 public void testSetDescription() {

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // updates the description
     task.setDescription("Submit the task milestone.");

     // checks updated description
     assertTrue(task.getDescription().equals("Submit the task milestone."));
 }

 // tests null name update
 @Test
 public void testSetNameNull() {

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // updates with invalid name
         task.setName(null);
     });
 }

 // tests long name update
 @Test
 public void testSetNameTooLong() {

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // updates with invalid name
         task.setName("ThisTaskNameIsWayTooLong");
     });
 }

 // tests null description update
 @Test
 public void testSetDescriptionNull() {

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // updates with invalid description
         task.setDescription(null);
     });
 }

 // tests long description update
 @Test
 public void testSetDescriptionTooLong() {

     // creates a task
     Task task = new Task("123", "Homework", "Finish Module Four assignment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {
    	 
         // updates with invalid description
         task.setDescription("This description is definitely longer than fifty characters total for testing.");
     });
 }
}