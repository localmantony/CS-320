package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {

    private ContactService testContactService;

    @BeforeEach
    public void setUp() {
        testContactService = new ContactService();
        testContactService.addContact(new Contact("goodID", "goodfirst", "goodlast", "1234567890", "goodaddress"));
    }

    @Test
    public void testAddContact() {
        assertTrue(testContactService.contactMap.containsKey("goodID"));
    }

    @Test
    public void testDeleteContact() {
        testContactService.deleteContact("goodID");
        assertTrue(!testContactService.contactMap.containsKey("goodID"));
    }

    @Test
    public void testUpdateFirstName() {
        testContactService.updateFirstName("goodID", "newFirst");
        assertEquals("newFirst", testContactService.contactMap.get("goodID").getFirstName());
    }
    
    @Test
    public void testUpdateLastName() {
        testContactService.updateLastName("goodID", "newLast");
        assertEquals("newLast", testContactService.contactMap.get("goodID").getLastName());
    }
    
    @Test
    public void testUpdatePhoneNumber() {
        testContactService.updatePhoneNumber("goodID", "0987654321");
        assertEquals("0987654321", testContactService.contactMap.get("goodID").getPhoneNumber());
    }
    
    @Test
    public void testUpdateAddress() {
        testContactService.updateAddress("goodID", "newAddress");
        assertEquals("newAddress", testContactService.contactMap.get("goodID").getAddress());
    }
    

    @Test
    public void testAddContactWithDuplicateId() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.addContact(new Contact("goodID", "goodfirst2", "goodlast2", "1234567890", "goodaddress2"));
        });
    }

    @Test
    void testDeleteNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.deleteContact("NonExistentID");
        });
    }

    @Test
    public void testUpdateFirstNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updateFirstName("NonExistentID", "nonexistent");
        });
    }
    
    @Test
    public void testUpdateLastNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updateLastName("NonExistentID", "person");
        });
    }
    
    @Test
    public void testUpdatePhoneNumberNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updatePhoneNumber("NonExistentID", "0000000000");
        });
    }
    
    @Test
    public void testUpdateAddressNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            testContactService.updateAddress("NonExistentID", "Non Existent Address");
        });
    }
    
}
