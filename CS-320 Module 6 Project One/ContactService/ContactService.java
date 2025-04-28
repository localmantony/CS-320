package contact;
import java.util.HashMap;

public class ContactService {
    public HashMap<String, Contact> contactMap = new HashMap<>();

    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contactMap.put(contact.getId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contactMap.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contactMap.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setFirstName(firstName);
    }
    
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contactMap.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setLastName(lastName);
    }
    
    public void updatePhoneNumber(String contactId, String phoneNumber) {
        Contact contact = contactMap.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setPhoneNumber(phoneNumber);
    }
    
    public void updateAddress(String contactId, String address) {
        Contact contact = contactMap.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setAddress(address);
    }
    
}
