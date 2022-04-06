package g58112.chess.model.pieces;

import g58112.chess.model.Board;
import g58112.chess.model.Color;
import g58112.chess.model.Direction;
import g58112.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * the Rook class will represent a rook and its color
 * 
 * @author g58112
 */
public class Rook extends Piece {

    /**
     * The constructor initializes the rook with the given color
     *
     * @param color the color of the rook
     */
    public Rook(Color color) {
        super(color);
    }
    
    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        Direction[] possibleDirections = {Direction.N, Direction.S, Direction.E, Direction.W};
        
        List<Position> possibleMoves = new ArrayList();
        
        for (Direction direction : possibleDirections) {
            List<Position> possibleMovesInDirection = super.getAllMovesInDirection(position, board, direction);
            possibleMoves.addAll(possibleMovesInDirection);
        }
        
        return possibleMoves;
    }
}
