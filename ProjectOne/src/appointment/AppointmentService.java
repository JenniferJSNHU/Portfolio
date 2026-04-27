package appointment;

// imports HashMap
import java.util.HashMap;

// imports Map
import java.util.Map;

// defines the AppointmentService class
public class AppointmentService {

 // stores appointments in memory
 private final Map<String, Appointment> appointments = new HashMap<>();

 // adds an appointment
 public void addAppointment(Appointment appointment) {

     // checks appointment for null
     if (appointment == null) {

         // throws exception for invalid appointment
         throw new IllegalArgumentException("Appointment cannot be null.");
     }

     // checks for duplicate ID
     if (appointments.containsKey(appointment.getAppointmentId())) {

         // throws exception for duplicate ID
         throw new IllegalArgumentException("Appointment ID must be unique.");
     }

     // adds the appointment to the map
     appointments.put(appointment.getAppointmentId(), appointment);
 }

 // deletes an appointment by ID
 public void deleteAppointment(String appointmentId) {

     // removes the appointment
     appointments.remove(appointmentId);
 }

 // returns an appointment by ID
 public Appointment getAppointment(String appointmentId) {

     // sends back the appointment
     return appointments.get(appointmentId);
 }
}