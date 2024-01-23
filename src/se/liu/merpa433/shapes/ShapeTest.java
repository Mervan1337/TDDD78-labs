package se.liu.merpa433.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeTest
{
    public static void main(String[] args) {
	DiagramComponent diagramComponent = new DiagramComponent();
	final List<Shape> shapes = new ArrayList<>();
	Shape shape1 = new Circle(1, 5, 7, Color.red);
	shapes.add(shape1);
	Shape shape2 = new Circle(5,7,12,Color.green);
	shapes.add(shape2);
	Shape shape3 = new Circle(7,12,2, Color.gray);
	shapes.add(shape3);
	Shape shape4 = new Rectangle(12,4,4,3,Color.red);
	shapes.add(shape4);
	Shape shape5 = new Text(1,4,5,Color.cyan, "Hello World!");
	shapes.add(shape5);

	System.out.println(shapes);

    }
}
