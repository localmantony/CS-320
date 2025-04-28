package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;

import appointment.Appointment;

class AppointmentTest {
	
	Date validFutureDate = new Date(2030-1900, 1, 1);
	
	@Test
	void allGoodTest() {
		Appointment appointment = new Appointment("goodID", validFutureDate, "goodDescription");
		assertTrue(appointment.getAppointmentID().equals("goodID"));
		assertTrue(appointment.getAppointmentDate().equals(validFutureDate));
		assertTrue(appointment.getAppointmentDescription().equals("goodDescription"));
	}
	
	@Test
	void testBadIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Appointment("badidtoolong", validFutureDate, "goodDescription");
		});
	}
	
	@Test
	void testBadIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Appointment(null, validFutureDate, "goodDescription");
		});
	}
	
	@Test
	void testBadDateInPast() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			Date pastDate = new Date(2024-1900, 1, 1);
			new Appointment("goodID", pastDate, "goodDescription");
		});
	}
	
	@Test
	void testBadDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Appointment("goodID", null, "goodDescription");
		});
	}
	
	@Test
	void testBadDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Appointment("goodID", validFutureDate, "BadDescription11111111112222222222333333333344444444445555555555");
		});
	}
	
	@Test
	void testBadDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
			new Appointment("goodID", validFutureDate, null);
		});
	}
}
