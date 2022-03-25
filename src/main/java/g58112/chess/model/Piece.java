/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * the Piece class will represent a piece and its color
 *
 * @author g58112
 */
public class Piece {

    private Color color;

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
     * 
     * @param position
     * @param board
     * @return 
     */
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> myList = new ArrayList();
//        if (position.getRow()==0 || position.getRow()==7) {
//            throw new IllegalArgumentException("Un pion ne peut pas être situé sur la première ou la dernière ligne de l'échiquier");
//        }
        Direction direction;
        Direction directionDiagonalE;
        Direction directionDiagonalW;
        Position forward;
        Position diagonalE;
        Position diagonalW;
        if (this.color.equals(Color.WHITE)) {
            direction = Direction.N;
            directionDiagonalE = Direction.NE;
            directionDiagonalW = Direction.NW;
            forward = position.next(direction);
            diagonalE = position.next(directionDiagonalE);
            diagonalW = position.next(directionDiagonalW);

        } else {
            direction = Direction.S;
            forward = position.next(direction);
            directionDiagonalE = Direction.SE;
            directionDiagonalW = Direction.SW;
            diagonalE = position.next(directionDiagonalE);
            diagonalW = position.next(directionDiagonalW);

        }
        try {
            if (board.isFree(forward)) {
                myList.add(forward);
            }

            if (board.isFree(forward) && board.isFree(forward.next(direction)) && position.getRow() == board.getInitialPawnRow(color)) {
                myList.add(forward.next(direction));
            }

            if (board.containsOppositeColor(diagonalE, color)) {
                myList.add(diagonalE);
            }

            if (board.containsOppositeColor(diagonalW, color)) {
                myList.add(diagonalW);
            }
        } catch (IllegalArgumentException e) {
        }

        return myList;
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
