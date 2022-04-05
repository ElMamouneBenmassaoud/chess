package g58112.chess.model.pieces;

import g58112.chess.model.Board;
import g58112.chess.model.Color;
import g58112.chess.model.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * the Piece class will represent a piece and its color
 *
 * @author g58112
 */
public abstract class Piece {

    private final Color color;

    /**
     * The constructor initializes the piece with the given color
     *
     * @param color the color of the piece
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * this getter allows to get the color provided for the piece
     *
     * @return the color of the piece
     */
    public Color getColor() {
        return color;
    }

    /**
     * This method provides us with the list of possible positions for a piece
     * located in a given position on the chessboard.
     *
     * @param position the position of the piece
     * @param board the chessboard on which it plays
     * @return the list of possible positions for a piece
     */
    public abstract List<Position> getPossibleMoves(Position position, Board board);

    /**
     * This method provides us with the list of the positions on which a piece
     * located in a given position on the chessboard can capture an opposite piece.
     *
     * @param position the position of the piece
     * @param board the chessboard on which it plays
     * @return the list of the positions on which the piece can capture an opposite piece.
     */
    public List<Position> getCapturePositions(Position position, Board board){
        List<Position> capturePositions = new ArrayList();
        List<Position> possibleMoves = getPossibleMoves(position, board);
        
        for (Position pos : possibleMoves) {
            if (board.containsOppositeColor(pos, color)) {
                capturePositions.add(pos);
            }
        }
        
        return capturePositions;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.color);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

}
