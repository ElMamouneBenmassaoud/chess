package g58112.chess.model.pieces;

import g58112.chess.model.Board;
import g58112.chess.model.Color;
import g58112.chess.model.Direction;
import g58112.chess.model.Position;
import java.util.ArrayList;
import java.util.List;

/**
 * the Pawn class will represent a pawn and its color
 *
 * @author g58112
 */
public class Pawn extends Piece {

    /**
     * The constructor initializes the pawn with the given color
     *
     * @param color the color of the pawn
     */
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public List<Position> getPossibleMoves(Position position, Board board) {
        List<Position> myList = new ArrayList();

        Direction direction;
        Direction directionDiagonalE;
        Direction directionDiagonalW;
        Position forward;
        Position diagonalE;
        Position diagonalW;
        if (getColor().equals(Color.WHITE)) {   //Vérifier la couleur du pion (Blanc ou Noir)
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
        try {   //catch l'exception si la position n'existe pas sur le chessboard et verifier la condition suivante
            if (board.isFree(forward)) {    //vérifie si la case devant lui est vide
                myList.add(forward);    //ajout dans la liste la position du déplacement d'une case vers l'avant

                if (position.getRow() == board.getInitialPawnRow(getColor()) && board.isFree(forward.next(direction))) { //vérifie si les 2 cases devant lui sont vides et qu'il se trouve a sa position initial
                    myList.add(forward.next(direction));    //ajout dans la liste les positions du déplacement de 2 cases vers l'avant
                }
            }
        } catch (IllegalArgumentException e) {
        }
        try { //catch l'exception si la position n'existe pas sur le chessboard et verifier la condition suivante
            if (board.containsOppositeColor(diagonalE, getColor())) {    //vérifie si la diagonale East du pion contient un pion de couleur opposé
                myList.add(diagonalE);  //ajout dans la liste, la position du déplacement de la case vers la diagonale East
            }
        } catch (IllegalArgumentException e) {
        }

        try { //catch l'exception si la position n'existe pas sur le chessboard
            if (board.containsOppositeColor(diagonalW, getColor())) {    //vérifie si la diagonale West du pion contient un pion de couleur opposé
                myList.add(diagonalW);  //ajout dans la liste, la position du déplacement de la case vers la diagonale West
            }
        } catch (IllegalArgumentException e) {
        }
        return myList;
    }

    /**
     * This method provides us with the list of the positions on which a pawn
     * located in a given position on the chessboard can capture an opposite piece.
     *
     * @param position the position of the pawn
     * @param board the chessboard on which it plays
     * @return the list of the positions on which the pawn can capture an opposite piece.
     */
    @Override
    public List<Position> getCapturePositions(Position position, Board board){
        List<Position> capturePositions = new ArrayList();
        List<Position> possibleMoves = getPossibleMoves(position, board);
        
        for (Position pos : possibleMoves) {
            boolean canTake = false;
            
            Position posNE = position.next(Direction.NE);
            Position posNW = position.next(Direction.NW);
            Position posSE = position.next(Direction.SE);
            Position posSW = position.next(Direction.SW);
            
            if (board.containsOppositeColor(pos, getColor())) {
                if (getColor() == Color.WHITE && ((board.contains(posNE) && pos.equals(posNE)) || (board.contains(posNW) && pos.equals(posNW)))) {
                    canTake = true;
                }
                if (getColor() == Color.BLACK && ((board.contains(posSE) && pos.equals(posSE)) || (board.contains(posSW) && pos.equals(posSW)))) {
                    canTake = true;
                }
                
                if (canTake) capturePositions.add(pos);
            }
        }
        
        return capturePositions;
    }
}
