package g58112.chess.model.pieces;

import g58112.chess.model.Board;
import g58112.chess.model.Color;
import g58112.chess.model.Direction;
import g58112.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mamou
 */
public class Knight extends Piece {

    /**
     * The constructor initializes the knight with the given color
     *
     * @param color the color of the knight
     */
    public Knight(Color color) {
        super(color);
    }
    
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> possibleMoves = new ArrayList();
        
        Color oppositeColor;
        if (getColor() == Color.WHITE) oppositeColor = Color.BLACK;
        else oppositeColor = Color.WHITE;
        
        possibleMoves.add(position.next(Direction.NW).next(Direction.W));
        possibleMoves.add(position.next(Direction.NW).next(Direction.N));
        possibleMoves.add(position.next(Direction.NE).next(Direction.E));
        possibleMoves.add(position.next(Direction.NE).next(Direction.N));
        possibleMoves.add(position.next(Direction.SW).next(Direction.W));
        possibleMoves.add(position.next(Direction.SW).next(Direction.S));
        possibleMoves.add(position.next(Direction.SE).next(Direction.E));
        possibleMoves.add(position.next(Direction.SE).next(Direction.S));
  
        List<Position> positionsToRemove = new ArrayList();
        for (Position pos : possibleMoves) {
            if (!board.contains(pos) || board.containsOppositeColor(pos, oppositeColor)) positionsToRemove.add(pos);
        }
        
        for (Position pos : positionsToRemove) possibleMoves.remove(pos);
        
        return possibleMoves;
    }
    
}
