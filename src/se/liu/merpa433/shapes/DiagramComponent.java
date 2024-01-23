package se.liu.merpa433.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DiagramComponent extends JComponent {
    private List<Shape> shapes = new ArrayList<>();

    public DiagramComponent() {
	this.shapes = new ArrayList<>();
    }

    @Override protected void paintComponent(final Graphics g) {
	super.paintComponent(g);
	for (Shape shape: shapes) {
	    shape.draw(g);
	}
	// Senare ska vi rita upp alla former här!
    }

    public void addShape(Shape s) {
	shapes.add(s);
    }
}