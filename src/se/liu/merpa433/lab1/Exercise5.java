package se.liu.merpa433.lab1;

public class Exercise5 {
    public static void main(String[] args) {
	// Efter 16 blir int:en fullt det kan man lösa med BigInteger eller long
	for (int i = 0; i <= 10; i++) {
	    System.out.println(i + "-fakultet: " + factorial(i));
	}
    }

    /**
     * Calculates f! given f.
     * @param f
     * @return f!
     */
    private static int factorial(int f) {
	if (f == 0)
	    return 1;

	int result = 1;
	for(int i = 1; i <= f; i++) {
		result *= i;
	}

	return result;
    }
}

