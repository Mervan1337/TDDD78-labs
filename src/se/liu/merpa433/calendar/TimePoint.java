package se.liu.merpa433.calendar;

public class TimePoint {
    public int hour;
    public int minute;

    public TimePoint(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override public String toString() {
        return String.format("%02d:%02d", getHour(), getMinute());
    }
}
