package g58112.chess.model;

import g58112.chess.model.pieces.Piece;

/**
 * This class will represent one of the 64 squares on the game board
 *
 * @author g58112
 */
public class Square {

    private Piece piece;

    /**
     * the constructor initializes a piece on the square
     *
     * @param piece
     */
    public Square(Piece piece) {
        this.piece = piece;
    }

    /**
     * allows you to get the piece in the square
     *
     * @return
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * allows you to set the piece in the square
     *
     * @param piece
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * check if the square is free or not
     *
     * @return true for isFree and false for isNotFree
     */
    public boolean isFree() {
        boolean isFree = false;
        if (getPiece() == null) {
            isFree = true;
        }
        return isFree;
    }
}
