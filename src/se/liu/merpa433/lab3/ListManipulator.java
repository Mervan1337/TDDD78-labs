package se.liu.merpa433.lab3;

import se.liu.merpa433.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ListManipulator {

    protected List<Person> elements = new ArrayList<>();

    protected ListManipulator(final List<Person> elements) {
	this.elements = elements;
    }

    public int size() {
	return elements.size();
    }

    public boolean isEmpty() {
	return elements.isEmpty();
    }

    public boolean contains(final Object o) {
	return elements.contains(o);
    }

    public Iterator<Person> iterator() {
	return elements.iterator();
    }

    public boolean add(Person person) {
	return elements.add(person);
    }

    public Person remove(final int index) {
	return elements.remove(index);
    }

    public void clear() {
	elements.clear();
    }
}
