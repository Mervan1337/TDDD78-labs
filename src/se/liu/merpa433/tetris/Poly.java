package se.liu.merpa433.tetris;

public class Poly {
    private SquareType[][] array;
    private int width, height;

    public Poly(final SquareType[][] array) {
	this.array = array;
	width = array.length;
	height = array[0].length;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }
    public SquareType getSquareType(int x, int y) {
	return array[y][x];
    }

    public Poly rotateRight() {
	Poly newPoly = new Poly(new SquareType[array.length][array.length]);

	for (int r = 0; r < array.length; r++) {
	    for (int c = 0; c < array.length; c++){
		newPoly.array[c][array.length-1-r] = this.array[r][c];
	    }
	}

	return newPoly;
    }

    public Poly rotateLeft() {
	Poly newPoly = new Poly(new SquareType[array.length][array.length]);

	newPoly = rotateRight();
	newPoly = rotateRight();
	newPoly = rotateRight();

	return newPoly;
    }

}
