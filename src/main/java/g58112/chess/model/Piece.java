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

    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> myList = new ArrayList();
        if (board.getPiece(position) != this) {
            throw new IllegalArgumentException("La couleur du joueur ne correspend pas celle de la pièce");
        }
        Position devant;
        if (this.color.equals(color.WHITE)) {
            devant = position.next(Direction.N);
        }else{
            devant = position.next(Direction.S);
        }
            
        if(board.isFree(devant)){
            myList.add(devant);
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
