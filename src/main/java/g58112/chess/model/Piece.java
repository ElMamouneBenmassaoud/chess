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
     * This method provides us with the list of possible positions for a piece
     * located in a given position on the chessboard.
     *
     * @param position the position of the piece
     * @param board the chessboard on which it plays
     * @return the list of possible positions for a piece
     */
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> myList = new ArrayList();
//        if (position.getRow()==0 || position.getRow()==7) {
//            throw new IllegalArgumentException("Un pion ne peut pas être situé sur la première ou la dernière ligne de l'échiquier");
//        }

//    if (!color.equals(Color.BLACK)|| !color.equals(Color.WHITE)) {
//        throw new IllegalArgumentException("veuillez entrez une couleur logique soit noir et blanc");
//    }
        Direction direction;
        Direction directionDiagonalE;
        Direction directionDiagonalW;
        Position forward;
        Position diagonalE;
        Position diagonalW;
        if (this.color.equals(Color.WHITE)) {   //Vérifier la couleur du pion (Blanc ou Noir)
            direction = Direction.N;    //direction nord
            directionDiagonalE = Direction.NE;  //direction nord est
            directionDiagonalW = Direction.NW;  //direction nord west

            forward = position.next(direction); //Position nord a partir du pion
            diagonalE = position.next(directionDiagonalE);  //Position nord est a partir du pion
            diagonalW = position.next(directionDiagonalW);  //Position nord west a partir du pion

        } else {
            direction = Direction.S;    //direction sud
            directionDiagonalE = Direction.SE;  //direction sud est
            directionDiagonalW = Direction.SW;  //direction sud west

            forward = position.next(direction); //Position sud a partir du pion
            diagonalE = position.next(directionDiagonalE);  //Position sud est a partir du pion
            diagonalW = position.next(directionDiagonalW);  //Position sud west a partir du pion

        }
        try {
            if (board.isFree(forward)) {    //vérifie si la case devant lui est vide
                myList.add(forward);    //ajout dans la liste la position du déplacement d'une case vers l'avant

                if (board.isFree(forward.next(direction)) && position.getRow() == board.getInitialPawnRow(color)) { //vérifie si les 2 cases devant lui sont vides et qu'il se trouve a sa position initial
                    myList.add(forward.next(direction));    //ajout dans la liste les positions du déplacement de 2 cases vers l'avant
                }
            }

            if (board.containsOppositeColor(diagonalE, color)) {    //vérifie si la diagonale East du pion contient un pion de couleur opposé
                myList.add(diagonalE);  //ajout dans la liste, la position du déplacement de la case vers la diagonale East
            }

            if (board.containsOppositeColor(diagonalW, color)) {    //vérifie si la diagonale West du pion contient un pion de couleur opposé
                myList.add(diagonalW);  //ajout dans la liste, la position du déplacement de la case vers la diagonale West
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
