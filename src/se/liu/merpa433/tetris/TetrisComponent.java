package se.liu.merpa433.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.AbstractMap;
import java.util.EnumMap;


public class TetrisComponent extends JComponent implements BoardListener {
    private JFrame frame;
    private Board board;
    private AbstractMap<SquareType, Color> colorMap;
    private Graphics graphics;

    private final static int SQUARE_SIZE = 30;

    public TetrisComponent(final JFrame frame, final Board board) {
	this.frame = frame;
	this.board = board;
	this.board.addBoardListener(this);
	colorMap = new EnumMap<SquareType, Color>(SquareType.class);
	colorMap.put(SquareType.EMPTY, Color.BLACK);
	colorMap.put(SquareType.S, Color.RED);
	colorMap.put(SquareType.Z, Color.GREEN);
	colorMap.put(SquareType.O, Color.YELLOW);
	colorMap.put(SquareType.T, Color.MAGENTA);
	colorMap.put(SquareType.I, Color.CYAN);
	colorMap.put(SquareType.J, Color.PINK);
	colorMap.put(SquareType.L, Color.ORANGE);
	colorMap.put(SquareType.OUTSIDE, Color.WHITE);

	JComponent pane = frame.getRootPane();

	final InputMap in = pane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("LEFT"), "LEFT");
	in.put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT");
	in.put(KeyStroke.getKeyStroke("UP"), "UP");
	in.put(KeyStroke.getKeyStroke("DOWN"), "DOWN");

	final ActionMap act = pane.getActionMap();
	act.put("LEFT", new MoveAction(Direction.LEFT));
	act.put("RIGHT", new MoveAction(Direction.RIGHT));
	act.put("UP", new MoveAction(Direction.UP));
	act.put("DOWN", new MoveAction(Direction.DOWN));
    }

    private class MoveAction extends AbstractAction {
	private Direction direction;

	private MoveAction(Direction direction) {
	    this.direction = direction;
	}

	@Override public void actionPerformed(final ActionEvent e) {
	    if (direction == Direction.DOWN || direction == Direction.UP) {
		board.rotate(direction);
	    }
	    else {
		board.move(direction);
	    }
	}
    }

    public Dimension getPreferredSize() {
	int height = board.getHeight() * SQUARE_SIZE;
	int width = board.getWidth() * SQUARE_SIZE;
	return new Dimension(width, height);
    }

    @Override
    public void boardChanged() {
	this.repaint();
    }

    @Override
    protected void paintComponent (Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;

	int width = board.getWidth();
	int height = board.getHeight();

	for (int i = 0; i < height; i++) {
	    for (int j = 0; j < width; j++) {
		if (board.getVisibleSquareAt(j, i) == SquareType.EMPTY) {
		    g2d.setColor(Color.BLACK);
		    g2d.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE );
		}
		else {
		    g2d.setColor(colorMap.get(board.getVisibleSquareAt(j, i)));
		    g2d.fillRect(j * SQUARE_SIZE, i * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE );
		}
	    }
	}

    }
}
