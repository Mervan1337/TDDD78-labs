package se.liu.merpa433.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CircleTest {
    public static void main(String[] args) {
	final List<Circle> circles = new ArrayList<>();
	final Circle circle1 = new Circle(1, 5, 7, Color.red);
	circles.add(circle1);
	final Circle circle2 = new Circle(5,7,12,Color.green);
	circles.add(circle2);
	final Circle circle3 = new Circle(7,12,2, Color.gray);
	circles.add(circle3);
	for (Circle circle : circles) {
	    System.out.println(circle);
	}
    }
}
