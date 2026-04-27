package test;

import appointment.Appointment;
import appointment.AppointmentService;

// imports JUnit assertions
import static org.junit.jupiter.api.Assertions.*;

// imports Date
import java.util.Date;

// imports Test annotation
import org.junit.jupiter.api.Test;

// defines AppointmentService tests
public class AppointmentServiceTest {

 // creates a future date
 private Date futureDate() {

     // sends back a date in the future
     return new Date(System.currentTimeMillis() + 86400000);
 }

 // tests adding an appointment
 @Test
 public void testAddAppointment() {

     // creates the service
     AppointmentService service = new AppointmentService();

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // adds the appointment
     service.addAppointment(appointment);

     // checks stored appointment
     assertTrue(service.getAppointment("123").equals(appointment));
 }

 // tests duplicate appointment ID
 @Test
 public void testDuplicateAppointmentId() {

     // creates the service
     AppointmentService service = new AppointmentService();

     // creates first appointment
     Appointment appointment1 = new Appointment("123", futureDate(), "Dentist appointment.");

     // creates second appointment
     Appointment appointment2 = new Appointment("123", futureDate(), "Doctor appointment.");

     // adds first appointment
     service.addAppointment(appointment1);

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // adds duplicate appointment
         service.addAppointment(appointment2);
     });
 }

 // tests adding null appointment
 @Test
 public void testAddAppointmentNull() {

     // creates the service
     AppointmentService service = new AppointmentService();

     // checks for thrown exception
     assertThrows(IllegalArgumentException.class, () -> {

         // adds invalid appointment
         service.addAppointment(null);
     });
 }

 // tests deleting an appointment
 @Test
 public void testDeleteAppointment() {

     // creates the service
     AppointmentService service = new AppointmentService();

     // creates an appointment
     Appointment appointment = new Appointment("123", futureDate(), "Dentist appointment.");

     // adds the appointment
     service.addAppointment(appointment);

     // deletes the appointment
     service.deleteAppointment("123");

     // checks that appointment is gone
     assertNull(service.getAppointment("123"));
 }
}