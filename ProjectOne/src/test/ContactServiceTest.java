package test;

import contact.Contact;
import contact.ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for ContactService class
 */
public class ContactServiceTest {

    // Test adding a contact with unique ID
    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("111", "Jen", "Joseph", "1234567890", "123 Main");

        // Add contact to service
        service.addContact(contact);

        // Verify contact stored correctly
        assertEquals(contact, service.getContact("111"));
    }

    // Test adding duplicate contact ID (should fail)
    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact("111", "Jen", "Joseph", "1234567890", "123 Main");
        Contact contact2 = new Contact("111", "Amy", "Smith", "0987654321", "456 Oak");

        service.addContact(contact1);

        // Adding duplicate ID should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Test deleting a contact by ID
    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("111", "Jen", "Joseph", "1234567890", "123 Main");

        service.addContact(contact);

        // Delete contact
        service.deleteContact("111");

        // Verify contact no longer exists
        assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("111");
        });
    }

    // Test updating contact fields by ID
    @Test
    public void testUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("111", "Jen", "Joseph", "1234567890", "123 Main");

        service.addContact(contact);

        // Update all fields
        service.updateFirstName("111", "Jenny");
        service.updateLastName("111", "Smith");
        service.updatePhone("111", "0987654321");
        service.updateAddress("111", "456 Oak");

        // Retrieve updated contact
        Contact updated = service.getContact("111");

        // Verify updates applied correctly
        assertEquals("Jenny", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Oak", updated.getAddress());
    }
    // Test adding a null contact
    @Test
    public void testAddNullContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    // Test deleting a contact that does not exist
    @Test
    public void testDeleteMissingContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    // Test updating a missing contact
    @Test
    public void testUpdateMissingContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Jenny");
        });
    }
}