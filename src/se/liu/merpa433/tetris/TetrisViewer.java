package se.liu.merpa433.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewer {
    private Board board;
    private TetrisComponent graphicArea;
    private BoardToTextConverter convertedToText;
    private BoardListener boardListener;


    public TetrisViewer(Board board) {
        this.board = board;
    }

    public void show() {
        JFrame frame = new JFrame("Tetris");
        graphicArea = new TetrisComponent(frame, board);
        frame.setLayout(new BorderLayout());
        frame.add(graphicArea, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
    public void updateBoard() {
        boardListener.boardChanged();

    }


}
