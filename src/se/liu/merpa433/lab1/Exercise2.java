package se.liu.merpa433.lab1;

public class Exercise2 {
    public static int sumWhile(int min, int max) {
        int i = min;
        int summa = 0;
        while(i <= max) {
            summa += i;
            i++;
        }
        return summa;
    }
    public static int sumFor(int min, int max) {
        int summa = 0;
	for(int i = min; i <= max; i++) {
            summa += i;
        }
        return summa;
    }
    public static void main(String[] args) {
        final int min = 10;
        final int max = 20;
        System.out.println(sumFor(min, max));
        System.out.println(sumWhile(min, max));
    }
}
