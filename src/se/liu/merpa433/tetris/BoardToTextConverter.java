package se.liu.merpa433.tetris;

public class BoardToTextConverter {

    public StringBuilder convertToText(Board board) {

	StringBuilder convertedText = new StringBuilder();
	for(int i = 0; i < board.getHeight(); i++) {
	    if(i != 0) {
		convertedText.append("\n");
	    }
	    for(int j = 0; j < board.getWidth(); j++) {
		switch (board.getVisibleSquareAt(j,i)) {
		    case EMPTY:
			convertedText.append("+");
			break;
		    case I:
			convertedText.append("!");
			break;
		    case J:
			convertedText.append("#");
			break;
		    case L:
			convertedText.append("%");
			break;
		    case O:
			convertedText.append("&");
			break;
		    case S:
			convertedText.append("/");
			break;
		    case T:
			convertedText.append(":");
			break;
		    case Z:
			convertedText.append(";");
			break;
		}
	    }
	}
	return convertedText;
    }
}
