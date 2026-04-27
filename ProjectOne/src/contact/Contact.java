package contact;

// Contact class representing a single contact object
public class Contact {

    // Unique ID (required, max 10 char, not updatable)
    private final String contactId;

    // Required, max 10 char
    private String firstName;

    // Required, max 10 char
    private String lastName;

    // Required, 10 digits
    private String phone;

    // Required, max 30 char
    private String address;

    // Constructor validates all fields 
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        // Validate contactId (not null, <=10)
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        // Validate firstName (not null, <=10)
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }

        // Validate lastName (not null, <=10)
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }

        // Validate phone (exactly 10 digits)
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone");
        }

        // Validate address (not null, <=30)
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Assign values 
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter for contactId 
    public String getContactId() {
        return contactId;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Update firstName with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // Update lastName with validation
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // Update phone with validation
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone");
        }
        this.phone = phone;
    }

    // Update address with validation
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}