package se.liu.merpa433.lab1;

public class Exercise10 {
    public static void main(String[] args) {
	int number = 16777217;
	double decimal = number;
	System.out.println(number + " " + decimal);
	int intergerAgain = (int) decimal;
	System.out.println(intergerAgain);
	// Det blir omvandlat till så det slutar på 216 vid omvandling till decimal
	// Vid byte till double istället för float fungerar det
	int big = 2147483647;
	long bigger = (long) big + 1;
	System.out.println(big + " " + bigger);
	// Ingen skillnad blir fortfarande negativt
	// Med ett L fungerar det nu
	// Med casting fungerar det också som vid L
    }
}
