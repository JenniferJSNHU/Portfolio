package test;

import appointment.Appointment;

// imports JUnit assertions
import static org.junit.jupiter.api.Assertions.*;

// imports Date
import java.util.Date;

// imports Test annotation
import org.junit.jupiter.api.Test;

// defines Appointment tests
public class AppointmentTest {

 // creates a future date
 private Date futureDate() {

     // sends back a date in the future
     return new Date(System.currentTimeMillis() + 86400000);
 }

 // creates a past date
 private Date pastDate() {

     // sends back a date in the past
     return new Date(System.currentTimeMillis() - 86400000);
 }

 // tests valid appointment creation
 @Test
 public void testAppointmentCreation() {

     // creates a date
     Date date = futureDate();

     // creates an appointment
     Appointment appointment = new Appointment("123", date, "Dentist appointment.");

     // checks the appointment ID
     assertTrue(appointment.getAppointmentId().equals("123"));

     // checks the appointment date
     assertTrue(appointment.getAppointmentDate().equals(date));

     // checks the appointment description
     assertTrue(appointment.getDescription().equals("Dentist appointment."));
 }

 // tests null appointment ID
 @Test
 public void testAppointmentIdNull() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // creates invalid appointment
         new Appointment(null, futureDate(), "Dentist appointment.");
     });
 }

 // tests long appointment ID
 @Test
 public void testAppointmentIdTooLong() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // creates invalid appointment
         new Appointment("12345678901", futureDate(), "Dentist appointment.");
     });
 }

 // tests null appointment date
 @Test
 public void testAppointmentDateNull() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // creates invalid appointment
         new Appointment("123", null, "Dentist appointment.");
     });
 }

 // tests past appointment date
 @Test
 public void testAppointmentDateInPast() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // creates invalid appointment
         new Appointment("123", pastDate(), "Dentist appointment.");
     });
 }

 // tests null description
 @Test
 public void testAppointmentDescriptionNull() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // creates invalid appointment
         new Appointment("123", futureDate(), null);
     });
 }

 // tests long description
 @Test
 public void testAppointmentDescriptionTooLong() {

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // creates invalid appointment
         new Appointment("123", futureDate(), "This description is definitely longer than fifty characters total for testing.");
     });
 }

 // tests valid date update
 @Test
 public void testSetAppointmentDate() {

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // creates a new date
     Date newDate = new Date(System.currentTimeMillis() + 172800000);

     // updates the date
     appointment.setAppointmentDate(newDate);

     // checks updated date
     assertTrue(appointment.getAppointmentDate().equals(newDate));
 }

 // tests valid description update
 @Test
 public void testSetDescription() {

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // updates the description
     appointment.setDescription("Doctor appointment.");

     // checks updated description
     assertTrue(appointment.getDescription().equals("Doctor appointment."));
 }

 // tests null date update
 @Test
 public void testSetAppointmentDateNull() {

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // updates with invalid date
         appointment.setAppointmentDate(null);
     });
 }

 // tests past date update
 @Test
 public void testSetAppointmentDateInPast() {

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // updates with invalid date
         appointment.setAppointmentDate(pastDate());
     });
 }

 // tests null description update
 @Test
 public void testSetDescriptionNull() {

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // updates with invalid description
         appointment.setDescription(null);
     });
 }

 // tests long description update
 @Test
 public void testSetDescriptionTooLong() {

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // updates with invalid description
         appointment.setDescription("This description is definitely longer than fifty characters total for testing.");
     });
 }
}