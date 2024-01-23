package se.liu.merpa433.lab1;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private LocalDate birthDay;

    public Person(final String name, final LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }

    public int getAge() {
	LocalDate todaysDate = LocalDate.now();
	Period periodDifference = Period.between(this.birthDay, todaysDate);
	final int numberOfYears = periodDifference.getYears();
	return numberOfYears;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", Age=" + getAge() +
                '}';
    }

    public static void main(String[] args) {
        final Person mervan = new Person("Mervan Palmér", LocalDate.of(2002, 12, 31));
        System.out.println(mervan);
        final Person pelle = new Person("Pelle Andersson", LocalDate.of(1992, 12, 31));
        System.out.println(pelle);
        final Person andreas = new Person("Andreas Palmér", LocalDate.of(1972, 12, 31));
        System.out.println(andreas);
        final Person olle = new Person("Olle Jonsson", LocalDate.of(1962, 12, 31));
        System.out.println(olle);
    }
}
