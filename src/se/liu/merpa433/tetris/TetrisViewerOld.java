package se.liu.merpa433.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewerOld
{
    private Board board;
    private JFrame frame;


    public TetrisViewerOld(Board board, final JFrame frame) {
        this.board = board;
        this.frame = frame;
    }

    public void show() {
        /*
        JFrame frame = new JFrame("Tetris");
        JTextArea textArea = new JTextArea("Tetris", board.getWidth(), board.getHeight());
        StringBuilder convertedToText = new BoardToTextConverter();
        convertedToText = convertedToText.convertToText(board);
        textArea.setText(convertedToText);
        frame.setLayout(new BorderLayout());
        frame.add(textArea, BorderLayout.CENTER);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        frame.pack();
        frame.setVisible(true);

         */

    }
    public void updateBoard(Board board) {
        this.board = board;
        this.show();
        this.frame.revalidate();
    }

}
