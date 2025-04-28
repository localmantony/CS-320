package appointment;

import java.util.Date;

public class Appointment {
	private final String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
		if(appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		if(appointmentDate == null || appointmentDate.before(new Date()) ) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		if(appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		
		this.appointmentID = appointmentID;
		this.appointmentDate = appointmentDate;
		this.appointmentDescription = appointmentDescription;
	}
	
	public String getAppointmentID() {
		return appointmentID;
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
}
