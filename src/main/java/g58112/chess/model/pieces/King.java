package g58112.chess.model.pieces;

import g58112.chess.model.Board;
import g58112.chess.model.Color;
import g58112.chess.model.Direction;
import g58112.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * the King class will represent a pawn and its color
 * 
 * @author g58112
 */
public class King extends Piece {

    /**
     * The constructor initializes the King with the given color
     *
     * @param color the color of the king
     */
    public King(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves = new ArrayList();

        Color oppositeColor;
        if (getColor() == Color.WHITE) {
            oppositeColor = Color.BLACK;
        } else {
            oppositeColor = Color.WHITE;
        }

        possibleMoves.add(position.next(Direction.N));
        possibleMoves.add(position.next(Direction.S));
        possibleMoves.add(position.next(Direction.E));
        possibleMoves.add(position.next(Direction.W));
        possibleMoves.add(position.next(Direction.NW));
        possibleMoves.add(position.next(Direction.NE));
        possibleMoves.add(position.next(Direction.SE));
        possibleMoves.add(position.next(Direction.SW));

        List<Position> positionsToRemove = new ArrayList();
        for (Position pos : possibleMoves) {
            if (!board.contains(pos) || board.containsOppositeColor(pos, oppositeColor)) {
                positionsToRemove.add(pos);
            }
        }
        
        for (Position pos : positionsToRemove) {
            possibleMoves.remove(pos);
        }
        
        return possibleMoves;
    }

}
