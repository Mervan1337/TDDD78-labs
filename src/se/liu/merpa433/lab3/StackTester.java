package se.liu.merpa433.lab3;

import se.liu.merpa433.lab1.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StackTester
{

    public static void main(String[] args) {
	List<Person> elementsTestOne = new ArrayList<>();
	List<Person> elementsTestTwo = new ArrayList<>();
	Stack testStack = new Stack(elementsTestOne);
	Queue testQueue = new Queue(elementsTestTwo);

	Person gabriel = new Person("Gabriel", LocalDate.of(2002,12,31));
	testStack.add(gabriel);
	testQueue.add(gabriel);

	Person liam = new Person("Liam", LocalDate.of(2002,8,15));
	testStack.add(liam);
	testQueue.add(liam);

	Person max = new Person("Max", LocalDate.of(1992,12,31));
	testStack.add(max);
	testQueue.add(max);

	Person mervan = new Person("Mervan", LocalDate.of(2002,11,15));
	testStack.add(mervan);
	testQueue.add(mervan);

	Person jocke = new Person("Jocke", LocalDate.of(1992,12,9));
	testStack.add(jocke);
	testQueue.add(jocke);

	System.out.println("----------- Testing Stack ----------------");
	while(!testStack.isEmpty()){
	    System.out.println(testStack.pop());
	}

	System.out.println("--------------- Testing Queue -------------");
	while(!testQueue.isEmpty()){
	    System.out.println(testQueue.dequeue());
	}
    }
}
