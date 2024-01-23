package se.liu.merpa433.tetris;

public class BoardTester {
    public static void main(String[] args) {
	Board board = new Board(3, 6);
	StringBuilder boardString = new BoardToTextConverter().convertToText(board);
	System.out.println(boardString);
	System.out.println("--------------");
	for(int i = 1; i <= 10; i++) {
	    board.generateRandomBoard();
	}
	StringBuilder boardScrambledString = new BoardToTextConverter().convertToText(board);
	System.out.println(boardScrambledString);
    }

}
