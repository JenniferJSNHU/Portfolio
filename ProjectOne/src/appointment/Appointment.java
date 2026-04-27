package appointment;

// imports Date
import java.util.Date;

// defines Appointment class
public class Appointment {

 // stores appointment ID
 private final String appointmentId;

 // stores appointment date
 private Date appointmentDate;

 // stores appointment description
 private String description;

 // creates appointment object
 public Appointment(String appointmentId, Date appointmentDate, String description) {

     // checks appointment ID for null
     if (appointmentId == null) {

         // throws exception for invalid ID
         throw new IllegalArgumentException("Appointment ID cannot be null.");
     }

     // checks appointment ID length
     if (appointmentId.length() > 10) {

         // throws exception for invalid ID length
         throw new IllegalArgumentException("Appointment ID cannot be longer than 10 characters.");
     }

     // checks appointment date for null
     if (appointmentDate == null) {

         // throws exception for invalid date
         throw new IllegalArgumentException("Appointment date cannot be null.");
     }

     // checks if appointment date is in the past
     if (appointmentDate.before(new Date())) {

         // throws exception for past date
         throw new IllegalArgumentException("Appointment date cannot be in the past.");
     }

     // checks description for null
     if (description == null) {

         // throws exception for invalid description
         throw new IllegalArgumentException("Appointment description cannot be null.");
     }

     // checks description length
     if (description.length() > 50) {

         // throws exception for invalid description length
         throw new IllegalArgumentException("Appointment description cannot be longer than 50 characters.");
     }

     // assigns the appointment ID
     this.appointmentId = appointmentId;

     // assigns the appointment date
     this.appointmentDate = appointmentDate;

     // assigns the description
     this.description = description;
 }

 // returns the appointment ID
 public String getAppointmentId() {

     // sends back the appointment ID
     return appointmentId;
 }

 // returns the appointment date
 public Date getAppointmentDate() {

     // sends back the appointment date
     return appointmentDate;
 }

 // returns the appointment description
 public String getDescription() {

     // sends back the description
     return description;
 }

 // updates the appointment date
 public void setAppointmentDate(Date appointmentDate) {

     // checks appointment date for null
     if (appointmentDate == null) {

         // throws exception for invalid date
         throw new IllegalArgumentException("Appointment date cannot be null.");
     }

     // checks if appointment date is in the past
     if (appointmentDate.before(new Date())) {

         // throws exception for past date
         throw new IllegalArgumentException("Appointment date cannot be in the past.");
     }

     // updates the appointment date
     this.appointmentDate = appointmentDate;
 }

 // updates the appointment description
 public void setDescription(String description) {

     // checks description for null
     if (description == null) {

         // throws exception for invalid description
         throw new IllegalArgumentException("Appointment description cannot be null.");
     }

     // checks description length
     if (description.length() > 50) {

         // throws exception for invalid description length
         throw new IllegalArgumentException("Appointment description cannot be longer than 50 characters.");
     }

     // updates the description
     this.description = description;
 }
}