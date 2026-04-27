package contact;

import java.util.HashMap;
import java.util.Map;

//Service class for managing contacts
public class ContactService {

    // In-memory storage (no database required)
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add contact 
    public void addContact(Contact contact) {

        // Check for null or duplicate ID
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid or duplicate contact");
        }

        // Store contact
        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {

        // Ensure contact exists
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }

        // Remove contact
        contacts.remove(contactId);
    }

    // Update firstName by ID
    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    // Update lastName by ID
    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    // Update phone by ID
    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    // Update address by ID
    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    // Retrieve contact by ID (used in tests)
    public Contact getContact(String contactId) {

        // Ensure contact exists
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }

        return contacts.get(contactId);
    }
}