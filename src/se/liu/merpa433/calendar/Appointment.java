package se.liu.merpa433.calendar;

public class Appointment {
    public String subject;
    public SimpleDate date;
    public TimeSpan timeSpan;

    public Appointment(final String subject, final SimpleDate date, final TimeSpan timeSpan) {
	this.subject = subject;
	this.date = date;
	this.timeSpan = timeSpan;
    }

    public String getSubject() {
	return subject;
    }

    public SimpleDate getDate() {
	return date;
    }

    public TimeSpan getTimeSpan() {
	return timeSpan;
    }



    @Override public String toString() {
	return "Appointment{" + "date=" + date + '}';
    }
}
