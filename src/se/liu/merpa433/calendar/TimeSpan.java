package se.liu.merpa433.calendar;

public class TimeSpan {
    public TimePoint start;
    public TimePoint end;

    public TimeSpan(TimePoint start, TimePoint end) {
        this.start = start;
        this.end = end;
    }


    public TimePoint getStart() {
        return start;
    }

    public TimePoint getEnd() {
        return end;
    }

    @Override public String toString() {
        // GÖR KLART
        return String.format("%02d:%02d", start.getHour(), start.getMinute()) +
               " - " +
               String.format("%02d:%02d", end.getHour(), start.getMinute());
    }
}
