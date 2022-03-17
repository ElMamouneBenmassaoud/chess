/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

/**
 * the Piece class will represent a piece and its color
 * @author g58112
 */
public class Piece {
    private Color color;

    
    /**
     * The constructor initializes the piece with the given color
     * @param color the color of the piece
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * this getter allows to get the color provided for the piece
     * @return the color of the piece 
     */
    public Color getColor() {
        return color;
    }    
}
