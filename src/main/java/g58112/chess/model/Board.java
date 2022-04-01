/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will represent the game board (the chessboard)
 *
 * @author g58112
 */
public class Board {

    private Square[][] squares;

    /**
     * The constructor initializes a new board of 8 times 8 squares (not
     * containing no parts).
     */
    public Board() {
        squares = new Square[8][8];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                squares[i][j] = new Square(null);
            }
        }
    }

    /**
     * check if the square exists on the chessboard
     *
     * @param pos position we want to check
     * @return true : pos exist on the chessboard and false: pos does not exist
     * in the chessboard
     */
    public boolean contains(Position pos) {
        boolean posexist = false;
        if (pos.getRow() >= 0 && pos.getRow() <= 7 && pos.getColumn() >= 0 && pos.getColumn() <= 7) {
            posexist = true;
        }
        return posexist;
    }

    /**
     * this method places the piece passed in parameter on the corresponding
     * square of the board.
     *
     * @throw an IllegalArgumentException if the given position is not on the
     * chessboard
     * @param piece the piece we would like to place on the chessboard
     * @param position the position (row, column) where the piece will be placed
     */
    public void setPiece(Piece piece, Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("la position n'existe pas sur l'échequier");
        }
        Square casePiece = new Square(piece);
        squares[position.getRow()][position.getColumn()] = casePiece;
    }

    /**
     * this method is used to retrieve the piece in the position set in the
     * parameters
     *
     * @throw an IllegalArgumentException if the given position is not on the
     * chessboard
     * @param pos the position of the piece to be retrieved
     * @return the piece that is in the received position in the parameters
     */
    public Piece getPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("la position n'existe pas sur l'échequier");
        }

        int row = pos.getRow();
        int column = pos.getColumn();
        Piece piece = squares[row][column].getPiece();
        return piece;
    }

    /**
     * This method will be useful for positioning the pieces on the board, as
     * well as to determine if a piece is still on its initial position or not
     *
     * @param color colour of the pawn received as a parameter
     * @return return 6 for black pieces that are positioned on row 6, or 1 for
     * white pieces that are positioned on line 1
     */
    public int getInitialPawnRow(Color color) {
        int nbColor = 1;
        if (color == Color.BLACK) {
            nbColor = 6;
        }
        return nbColor;
    }

    /**
     * removes the piece from the cell whose position is passed in parameter.
     *
     * @throw an IllegalArgumentException if the given position is not on the
     * chessboard
     * @param pos the position of the piece to be deleted
     */
    public void dropPiece(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("la position n'existe pas sur l'échequier");
        }
        setPiece(null, pos);
    }

    /**
     * check if the square is free or not
     *
     * @throw an IllegalArgumentException if the given position is not on the
     * chessboard
     * @param pos the position of the square to be checked
     * @return true for isFree and false for isNotFree
     */
    public boolean isFree(Position pos) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("la position n'existe pas sur l'échequier");
        }

        return squares[pos.getRow()][pos.getColumn()].isFree();
    }

    /**
     * This method allows you to check if a square is occupied by an opponent's
     * piece.
     *
     * @throw an IllegalArgumentException if the given position is not on the
     * chessboard
     * @param pos the position of the piece
     * @param col the colour of a piece that you want to compare with another
     * @return A boolean that checks if the cell whose position is passed as a
     * parameter contains a piece of the opposite colour to the one passed as a
     * parameter
     */
    public boolean containsOppositeColor(Position pos, Color col) {
        if (!contains(pos)) {
            throw new IllegalArgumentException("la position n'existe pas sur l'échequier");
        }
        boolean opposite = false;
        if (!isFree(pos) && squares[pos.getRow()][pos.getColumn()].getPiece().getColor() != col) {
            opposite = true;
        }
        return opposite;
    }

    /**
     * this method creates a list of all the positions occupied by the player
     * received in parameter
     *
     * @param player is the player given
     * @return a list of all positions occupied by the given
     */
    public List<Position> getPositionOccupiedBy(Player player) {
        List<Position> liste = new ArrayList();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                Position pos = new Position(i, j);
                if (!isFree(pos) && player.getColor() == squares[i][j].getPiece().getColor()) {
                    liste.add(pos);
                }
            }
        }
        return liste;
    }
}
