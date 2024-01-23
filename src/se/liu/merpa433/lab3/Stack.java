package se.liu.merpa433.lab3;

import se.liu.merpa433.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack extends ListManipulator {
    protected Stack(final List<Person> elements) {
	super(elements);
    }

    public void push(Person person) {
	elements.add(elements.size() - 1, person);
    }

    public Person pop() {
	Person firstPerson = elements.get(elements.size() - 1);
	elements.remove(elements.size() - 1);
	return firstPerson;
    }
}
