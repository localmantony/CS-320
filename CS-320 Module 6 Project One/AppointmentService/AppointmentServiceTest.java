package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import appointment.Appointment;
import appointment.AppointmentService;

public class AppointmentServiceTest {

    private AppointmentService testAppointmentService;

    @BeforeEach
    public void setUp() {
    	@SuppressWarnings("deprecation")
    	Date validFutureDate = new Date(2030-1900, 1, 1);
        testAppointmentService = new AppointmentService();
        testAppointmentService.addAppointment(new Appointment("goodID", validFutureDate, "goodDescription"));
    }

    @Test
    public void testAddAppointment() {
        assertTrue(testAppointmentService.appointmentMap.containsKey("goodID"));
    }
    
    @Test
    public void testAddDuplicateAppointment() {
    	Date validFutureDate = new Date(2030-1900, 1, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            testAppointmentService.addAppointment(new Appointment("goodID", validFutureDate, "goodDescription"));
        });
    }

    @Test
    public void testDeleteAppointment() {
        testAppointmentService.deleteAppointment("goodID");
        assertTrue(!testAppointmentService.appointmentMap.containsKey("goodID"));
    }

    @Test
    void testDeleteNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            testAppointmentService.deleteAppointment("NonExistentID");
        });
    }
    
}
