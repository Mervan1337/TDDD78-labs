package se.liu.merpa433.tetris;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;


public class Board {
    private SquareType[][] squares;
    private int width;
    private int height;
    private final static Random RND = new Random();
    private Poly falling = null;
    private Point fallingPos;
    private List<BoardListener> listener;
    private boolean gameOver = false;


    private final static int MARGIN = 3;
    private final static int DOUBLE_MARGIN = 2 * MARGIN;

    public Board(final int width, final int height) {
	listener = new ArrayList<>();
	this.width = width;
	this.height = height;
	squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];


	for(int i = 0; i < height + DOUBLE_MARGIN; i++) {
	    for(int j = 0; j < width + DOUBLE_MARGIN; j++) {
		if ((i < MARGIN || i >= height + MARGIN) || (j < MARGIN || j >= width + MARGIN)) {
		    squares[i][j] = SquareType.OUTSIDE;
		} else {
		    squares[i][j] = SquareType.EMPTY;
		}
	    }
	}
	falling = new TetrominoMaker().getPoly(1);
	fallingPos = new Point(0, 0);
	this.notifyListeners();
    }

    public void generateRandomBoard() {
	for (int i = 0; i < getHeight(); i++) {
	    for (int j = 0; j < getWidth(); j++) {
		squares[i][j] = SquareType.values()[RND.nextInt(SquareType.values().length)];
		this.notifyListeners();
	    }
	}
    }

    public int getWidth() {

	return width;
    }

    public int getHeight() {

	return height;
    }

    public SquareType getSquareType(int x, int y) {
	return squares[y + MARGIN][x + MARGIN];
    }

    public SquareType getVisibleSquareAt(int x, int y) {
	if (falling == null) {
	    return getSquareType(x, y);
	}

	int fallingX = (int) fallingPos.getX();
	int fallingY = (int) fallingPos.getY();

	if (x < fallingX || x > fallingX + falling.getWidth() - 1)  {
	    return getSquareType(x, y);
	}
	if (y < fallingY || y > fallingY + falling.getHeight() - 1)  {
	    return getSquareType(x, y);
	}
	else {
	    SquareType typeOfSquare = falling.getSquareType(x - fallingX, y - fallingY);
	    if (typeOfSquare == SquareType.EMPTY) {
		return getSquareType(x, y);
	    }
	    else {
		return typeOfSquare;
	    }

	}
    }

    public void addBoardListener(BoardListener bl) {
	this.listener.add(bl);
    }

    private void notifyListeners() {
	for (BoardListener boardListener : listener) {
	    boardListener.boardChanged();
	}
    }

    private void setFalling() {
	falling = new TetrominoMaker().getPoly(RND.nextInt(0,6));
	fallingPos = new Point ((getWidth()/2) - (falling.getWidth()/2),0);
	if (hasCollision()) {
	    gameOver = true;
	}
    }

    public void tick() {
	//for (SquareType[] row:squares) {
	//    System.out.println(Arrays.toString(row));
	//}

	if(!gameOver) {
	    if (falling == null) {
		setFalling();
	    }
	    else {
		setFallingY(getFallingY() + 1);
	    }
	    if (hasCollision()) {
		setFallingY(getFallingY() - 1);
		addToBoard();
		List<Integer> rows = getFullRows();
		if (!rows.isEmpty()) {
		    for (Number row: rows) {
			moveRows(row.intValue());
		    }
		}
		falling = null;
	    }
	    notifyListeners();
	}
	else {
	    System.out.println("Game Over");

	}
    }

    private void moveRows(int rows) {
	for (int i = rows; i >= MARGIN; i--) {
	    if (i - 1 >= MARGIN) {
		squares[i] = squares[i-1];
	    }

	}
    }

    private List<Integer> getFullRows() {
	List<Integer> rows = new ArrayList<>();
	boolean rowIsFull = true;
	for (int i = 0; i < height; i++) {
	    rowIsFull = true;
	    for (int j = 0; j < width; j++) {
		if (getSquareType(j,i) == SquareType.EMPTY) {
		    rowIsFull = false;
		    break;
		}
	    }
	    if (rowIsFull) {
		rows.add(Integer.valueOf(i + MARGIN));
	    }
	}
	return rows;
    }

    public void setFallingY(int fallingY) {
	this.fallingPos.setLocation(getFallingX(), fallingY);
	notifyListeners();
    }

    public void setFallingX(int fallingX) {
	this.fallingPos.setLocation(fallingX, getFallingY());
	notifyListeners();
    }

    public void moveFallingXLeft() {
	setFallingX(getFallingX() - 1);

	if(hasCollision()) {
	    setFallingX(getFallingX() + 1);
	}

	notifyListeners();
    }

    public void moveFallingXRight() {
	setFallingX(getFallingX() + 1);

	if(hasCollision()) {
	    setFallingX(getFallingX() -1);
	}

	notifyListeners();
    }

    public int getFallingX() {
	return (int) fallingPos.getX();
    }

    public int getFallingY() {
	return (int) fallingPos.getY();
    }

    public void move(Direction direction) {
	switch (direction){
	    case LEFT -> moveFallingXLeft();
	    case RIGHT -> moveFallingXRight();
	}
	notifyListeners();
    }

    public void rotate(Direction dir) {
	Poly oldFalling = falling;
	if (dir == Direction.UP) {
	    falling = falling.rotateRight();
	    if(hasCollision()) {
		falling = oldFalling;
	    }
	}
	else if (dir == Direction.DOWN){
	    falling = falling.rotateLeft();
	    if (hasCollision()) {
		falling = oldFalling;
	    }
	}
	notifyListeners();
    }

    public void addToBoard() {
	for (int i = 0; i < falling.getWidth(); i++) {
	    for (int j = 0; j < falling.getWidth(); j++) {
		if(falling.getSquareType(j, i) != SquareType.EMPTY) {
		    setSquareTypeAtPos(j+getFallingX(), i + getFallingY(), falling.getSquareType(j,i));
		}
	    }
	}
    }

    private void setSquareTypeAtPos(int x, int y, SquareType type) {
	this.squares[y + MARGIN][x + MARGIN] = type;
    }

    public boolean hasCollision()  {
	int fallingPosX = (int) fallingPos.getX();
	int fallingPosY = (int) fallingPos.getY();

	if (falling != null) {
	    for (int i = fallingPosY; i < fallingPosY + falling.getHeight(); i++) {
		for (int j = fallingPosX; j < fallingPosX + falling.getWidth(); j++) {
		    if (getSquareType(j,i) != SquareType.EMPTY && falling.getSquareType(j - fallingPosX,i - fallingPosY) != SquareType.EMPTY) {
			return true;
		    }
		}
	    }
	}


	return false;
    }

    public static void main(String[] args) {
	final Board testBoard = new Board(22, 21);
	int randomCoordinateX = 12;
	int randomCoordinateY = 16;
	testBoard.getSquareType(randomCoordinateX,randomCoordinateY);
    }

}
