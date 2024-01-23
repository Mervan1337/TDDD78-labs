package se.liu.merpa433.calendar;

public class SimpleDate {
    public int year;
    public Month month;
    public int day;

    public SimpleDate(int year, Month month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return "SimpleDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
