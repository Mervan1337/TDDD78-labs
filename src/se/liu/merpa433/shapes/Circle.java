package se.liu.merpa433.shapes;

import java.awt.*;

public class Circle extends AbstractShape {
    private int radius;

    @Override public void draw(final Graphics g) {
	g.setColor(color);
	float width = radius * 2;
	float height = radius * 2;
	g.drawOval(x, y, (int) width, (int) height); // calc. from radius!
    }

    public Circle(final int x, final int y, final int radius, final Color color) {
	super(x, y, color);
	if (radius < 0) {
	    throw new IllegalArgumentException("Negativ radie!");
	}
	this.radius = radius;
    }

    @Override public String toString() {
	return "Circle{" + "x=" + getX() + ", y=" + getY() + ", radius=" + radius + ", color=" + getColor() + '}';
    }

    public int getRadius() {
	return radius;
    }

}
