package se.liu.merpa433.lab1;

import javax.swing.*;

public class Exercise8 {
    public static void main(String[] args) {
	boolean looping = true;
	while (true) {
	    System.out.println("Skriver du med ett & går den vidare direkt till really " +
			       "jämfört med && där den bara börjar om fråga quit. Därför fungerar && bättre här");
		if (askUser("Quit") & askUser("Really?")) {
		    return;
	    }
	}
    }
    public static boolean askUser(String question) {
	return JOptionPane.showConfirmDialog(null, question, "Hello World!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
