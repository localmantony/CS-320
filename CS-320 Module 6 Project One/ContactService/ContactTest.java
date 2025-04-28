package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void allGoodTest() {
		Contact contact = new Contact("goodID", "goodfirst", "goodlast", "1234567890", "Good Address");
		assertTrue(contact.getId().equals("goodID"));
		assertTrue(contact.getFirstName().equals("goodfirst"));
		assertTrue(contact.getLastName().equals("goodlast"));
		assertTrue(contact.getPhoneNumber().equals("1234567890"));
		assertTrue(contact.getAddress().equals("Good Address"));
	}
	
	@Test
	void testBadIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("badidtoolong", "goodfirst", "goodlast", "1234567890", "Good Address");
		});
	}
	
	@Test
	void testBadIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact(null, "goodfirst", "goodlast", "1234567890", "Good Address");
		});
	}
	
	@Test
	void testBadFirstTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "badfirstTooLong", "goodlast", "1234567890", "Good Address");
		});
	}
	
	@Test
	void testBadFirstNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", null, "goodlast", "1234567890", "Good Address");
		});
	}
	
	@Test
	void testBadLastTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", "BadLastTooLong", "1234567890", "Good Address");
		});
	}
	
	@Test
	void testBadLastNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", null, "1234567890", "Good Address");
		});
	}
	
	@Test
	void testBadNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", "goodlast", "12345678901", "Good Address");
		});
	}
	
	@Test
	void testBadNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", "goodlast", "123456789", "Good Address");
		});
	}
	
	@Test
	void testBadNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", "goodlast", null, "Good Address");
		});
	}
	
	@Test
	void testBadNumberNonNumeric() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", "goodlast", "123456789O", "Good Address");
		});
	}
	
	@Test
	void testBadAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", "goodlast", "1234567890", "12345678910 Bad Address Way Too Many Characters");
		});
	}

	@Test
	void testBadAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Contact("goodID", "goodfirst", "goodlast", "1234567890", null);
		});
	}
}
