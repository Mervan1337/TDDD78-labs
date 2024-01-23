package se.liu.merpa433.lab3;

import se.liu.merpa433.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue extends ListManipulator {

    protected Queue(final List<Person> elements) {
	super(elements);
    }

    public void enqueue(Person person) {
	elements.add(elements.size() - 1, person);
    }

    public Person dequeue() {
	Person firstPerson = elements.get(0);
	elements.remove(0);
	return firstPerson;
    }

}
