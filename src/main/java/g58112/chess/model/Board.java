/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

/**
 *This class will represent the game board (the chessboard)
 * @author g58112
 */
public class Board {

    private Square[][] squares;

    /**
     * The constructor initializes a new board of 8 times 8 squares (not
       containing no parts).
     */
    public Board() {
        this.squares = new Square[8][8];
    }

    
    /**
     * check if the square exists on the chessboard
     * @param pos position we want to check
     * @return true : pos exist on the chessboard and false: pos does not exist in the chessboard
     */
    public boolean contains(Position pos) {
        boolean Posexist = false;
        if (pos.getRow() >= 0 && pos.getRow() <= 7 && pos.getColumn() >= 0 && pos.getColumn() <= 7) {
            Posexist = true;
        }
        return Posexist;
    }
}

