package se.liu.merpa433.calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cal {
    private List<Appointment> appointments;

    public Cal(List<Appointment> appointments) {
	this.appointments = appointments;
	appointments = new ArrayList<>();
    }
    public void show() {
	int i = 0;
	for (Appointment appointment : this.appointments) {
	    System.out.println(appointments.get(i));
	    i++;
	}

    }
    public void book(int year, String month, int day, int startHour, int startMinute, int endHour, int endMinute, String subject) {
	if (year < 1970 || Month.getMonthLength(month) == -1) {
	    throw new IllegalArgumentException("felmeddelande");
	}
	else {
	    final SimpleDate appointmentDate = new SimpleDate(year, new Month(month, Month.getMonthNumber(month),day), day);
	    final TimePoint appointmentStart = new TimePoint(startHour, startMinute);
	    final TimePoint appointmentEnd = new TimePoint(endHour, endMinute);
	    final TimeSpan appointmentTimeSpan = new TimeSpan(appointmentStart, appointmentEnd);
	    final Appointment finalAppointment = new Appointment(subject, appointmentDate, appointmentTimeSpan);
	    this.appointments.add(finalAppointment);
	}
    }

    public static void main(String[] args) {
	List<Appointment> appointments = new ArrayList<>();
	Cal calendar = new Cal(appointments);
	for(int i = 1; i <= 10; i++) {
	    calendar.book(2000, "january", i*2, i,i,i*2, i*2, "Mervan är COOOL!");
	}
	calendar.show();
    }
}
