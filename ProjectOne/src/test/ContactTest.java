package test;

import contact.Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Contact class
 */
public class ContactTest {

    // Test valid contact creation (all fields valid)
    @Test
    public void testValidContact() {
        Contact contact = new Contact("123", "Jen", "Joseph", "1234567890", "123 Main St");

        // Verify all values stored correctly
        assertEquals("123", contact.getContactId());
        assertEquals("Jen", contact.getFirstName());
        assertEquals("Joseph", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test invalid contactId (null and >10 chars)
    @Test
    public void testInvalidContactId() {

        // Null ID should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jen", "Joseph", "1234567890", "123 Main");
        });

        // ID longer than 10 should throw exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Jen", "Joseph", "1234567890", "123 Main");
        });
    }

    // Test invalid firstName (null and >10 chars)
    @Test
    public void testInvalidFirstName() {

        // Null firstName
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Joseph", "1234567890", "123 Main");
        });

        // Too long firstName
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "VeryLongName", "Joseph", "1234567890", "123 Main");
        });
    }

 // Test invalid firstName updates
    @Test
    public void testInvalidFirstNameUpdate() {
        Contact contact = new Contact("123", "Jen", "Joseph", "1234567890", "123 Main");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("VeryLongName");
        });
    }
    // Test invalid lastName (null and >10 chars)
    @Test
    public void testInvalidLastName() {

        // Null lastName
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Jen", null, "1234567890", "123 Main");
        });

        // Too long lastName
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Jen", "VeryLongLastName", "1234567890", "123 Main");
        });
    }

    // Test invalid phone (null and not 10 digits)
    @Test
    public void testInvalidPhone() {

        // Null phone
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Jen", "Joseph", null, "123 Main");
        });

        // Not 10 digits
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Jen", "Joseph", "12345", "123 Main");
        });
    }

    // Test invalid address (null and >30 chars)
    @Test
    public void testInvalidAddress() {

        // Null address
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Jen", "Joseph", "1234567890", null);
        });

        // Address too long
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Jen", "Joseph", "1234567890",
                    "1234567890123456789012345678901");
        });
    }

    // Test updating valid fields
    @Test
    public void testUpdateFields() {
        Contact contact = new Contact("123", "Jen", "Joseph", "1234567890", "123 Main");

        // Update values
        contact.setFirstName("Jenny");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak St");

        // Verify updates applied
        assertEquals("Jenny", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak St", contact.getAddress());
    }
 
    // Test invalid lastName updates
    @Test
    public void testInvalidLastNameUpdate() {
        Contact contact = new Contact("123", "Jen", "Joseph", "1234567890", "123 Main");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("VeryLongLastName");
        });
    }

    // Test invalid phone updates
    @Test
    public void testInvalidPhoneUpdate() {
        Contact contact = new Contact("123", "Jen", "Joseph", "1234567890", "123 Main");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345");
        });
    }

    // Test invalid address updates
    @Test
    public void testInvalidAddressUpdate() {
        Contact contact = new Contact("123", "Jen", "Joseph", "1234567890", "123 Main");

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    
    }
}