package se.liu.merpa433.shapes;

import java.awt.*;

public interface Shape {
    public void draw(final Graphics g);

    int getX();

    int getY();

    Color getColor();
}
