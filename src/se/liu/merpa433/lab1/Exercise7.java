package se.liu.merpa433.lab1;

import javax.swing.*;

public class Exercise7 {
    public static int sumWhile(int min, int max) {
	int i = min;
	int summa = 0;
	while(i <= max) {
	    summa += i;
	    i++;
	}
	return summa;
	// Ville bara testa
	/*
	do {
	    summa += i;
	} while(i <= max);
	return summa;
	 */
    }
    public static int sumFor(int min, int max) {
	int summa = 0;
	for(int i = min; i <= max; i++) {
	    summa += i;
	}
	return summa;
    }
    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("For eller while?");
	switch(input) {
	    case "for":
		System.out.println(sumFor(10, 20));
		break;

	    case "while":
		System.out.println(sumWhile(10, 20));
		break;

	    default:
		System.out.println("Du skrev fel!");
	}
    }
}
