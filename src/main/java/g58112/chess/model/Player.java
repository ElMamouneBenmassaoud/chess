/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

/**
 * this class represent a player and his color
 * @author g58112
 */
public class Player {
    private Color color;

    /**
     * The constructor will initialize a new player of given color
     * @param colorplayer's color 
     */
    public Player(Color color) {
        this.color = color;
    }

    
    /**
     * the color of the player that matches the color of his pieces.
     * @return the color 
     */
    public Color getColor() {
        return color;
    }
    
    
}
