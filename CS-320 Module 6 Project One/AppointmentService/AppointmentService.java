package appointment;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	public HashMap<String, Appointment> appointmentMap = new HashMap<>();
	    
    public void addAppointment(Appointment appointment) {
    	if (appointmentMap.containsKey(appointment.getAppointmentID())) {
    		throw new IllegalArgumentException("Appointment ID already exists");
    	}
    	appointmentMap.put(appointment.getAppointmentID(), appointment);
    }
    
    public void deleteAppointment(String appointmentID) {
    	if (!appointmentMap.containsKey(appointmentID)) {
    		throw new IllegalArgumentException("Appointment not found");
    	}
    	appointmentMap.remove(appointmentID);
    }
}
