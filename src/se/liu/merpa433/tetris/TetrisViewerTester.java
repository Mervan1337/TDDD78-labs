package se.liu.merpa433.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewerTester {
    public static void main(String[] args) {
	Board board = new Board(10, 15);
	JFrame frame = new JFrame();
	TetrisViewer tetrisViewer = new TetrisViewer(board);
	TetrisComponent tetrisComponent = new TetrisComponent(frame, board);
	tetrisViewer.show();
	final Action doOneStep = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
		board.tick();



	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);


	clockTimer.setCoalesce(true);
	clockTimer.start();



    }



}
